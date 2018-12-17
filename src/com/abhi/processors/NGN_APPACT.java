package com.abhi.processors;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import com.abhi.pojo.NGNAppAct;
import com.abhi.util.LoggerUtil;

public class NGN_APPACT extends AbstractTask {
	private Logger logger = Logger.getLogger(this.getClass());

	public void run() {
		try {
			long startTime = System.currentTimeMillis();
			logger.info(this.requestId + " - KafkaString : " + kafkaString);
			NGNAppAct pq = (NGNAppAct) LoggerUtil.getObjectFromJson(kafkaString, NGNAppAct.class);
			appActivity(pq, this.requestId);
			addLastLocationAttribute(pq, this.requestId);
			logger.info(this.requestId + " - Time taken : " + (System.currentTimeMillis() - startTime));
		} catch (Exception e) {
			logger.error(this.requestId + " - Error : " + e.getMessage(), e);
		}
	}

	public static void main(String[] args) {
		NGN_APPACT object = new NGN_APPACT();
		object.kafkaString = "{\"appVersion\":\"1.0\",\"tx\":0,\"pushId\":\"385a4e1a-c6ce-4f07-bc13-ed8005603730\",\"identified\":false,\"payload\":{\"items\":[{\"prqt\":5,\"namew\":\"app1\",\"prid\":2,\"date_app\":1541148825000},{\"date_app2\":1541148825000,\"prqt2\":5,\"name_app2\":\"app2\",\"prid2\":2,\"price2\":15000.12}]},\"appId\":\"28ba7e98a93ba417f2d0464ebd13303e\",\"eventName\":\"product_search_app\",\"model\":\"MI MAX\",\"eventId\":153,\"cts\":181112124512,\"tsDate\":\"Dec 14, 2018 2:30:37 PM\",\"osId\":1,\"adId\":\"71132424-8d84-49b2-80df-a0f5033c4a71\",\"bod\":2602,\"sdkVersion\":\"1.1.3\",\"isAmplified\":0,\"osVersion\":\"7.0\",\"identity\":\"\",\"osType\":\"Android\",\"make\":\"Xiaomi\",\"channelId\":0,\"clientId\":14340,\"appName\":\"Netcore FCM\",\"sessionId\":\"1542006885957\",\"userId\":2308,\"atci\":0,\"ts\":181112124512}";
		Thread thread = new Thread(object);
		thread.start();
	}

	@SuppressWarnings("unchecked")
	private void appActivity(NGNAppAct pq, String requestId) {
		// TODO Auto-generated method stub
		try {
			String listString = "";
			long[] act = LoggerUtil.getDOWDayTimefromTS(pq.getTs());
			int[] bodData = LoggerUtil.getBod(String.valueOf(pq.getBod()));
			String tableName = pq.isIdentified() ? LoggerUtil.ENGAGEMENT_TABLE : LoggerUtil.ANON_ENGAGEMENT_TABLE;
			String clientId = "s_" + pq.getClientId() + ".";
			String clientTable = clientId + tableName + "_" + pq.getEventId();
			List<String> columnNames = LoggerUtil.getTableColumns(clientTable);
			Map<String, Object> otherCol = new LinkedHashMap<String, Object>();
			for (String column : columnNames) {
				if (!column.startsWith("vt_")) {
					otherCol.put(column, "NULL");
				}
			}
			for (String column : columnNames) {
				if (!column.startsWith("vt_")) {
					if (column.equals("b")) {
						otherCol.put(column, bodData[2]);
					} else if (column.equals("o")) {
						otherCol.put(column, bodData[1]);
					} else if (column.equals("d")) {
						otherCol.put(column, bodData[0]);
					} else if (column.equals("ad")) {
						otherCol.put(column, act[1]);
					} else if (column.equals("adat")) {
						otherCol.put(column, act[3]);
					} else {
						Object systemData = LoggerUtil.getNgnPojoField(pq, column, "a");
						otherCol.put(column, systemData);
					}
				}
			}
			Map<String, Object> payload = pq.getPayload();
			List<Object> data = processPayload(payload, columnNames, otherCol);
			for (Object object : data) {
				listString = LoggerUtil.listToCsvString(listString, (List<Object>) object);
			}
			String header = LoggerUtil.getListAsCsvString(columnNames);
			LoggerUtil.pushForFurtherProcessing(clientTable, header, listString);
		} catch (Exception e) {
			logger.error(requestId + " " + e.getMessage(), e);
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private List<Object> processPayload(Map<String, Object> payload, List<String> columnNames,
			Map<String, Object> otherCol) {
		Set entries = payload.entrySet();
		Iterator entryIter = entries.iterator();
		List<Object> data = new ArrayList<Object>();
		while (entryIter.hasNext()) {
			Map.Entry entry1 = (Map.Entry) entryIter.next();
			Object key1 = entry1.getKey(); // Get the key from the entry.
			Object value = entry1.getValue();
			ArrayList<Object> arrlist = (ArrayList<Object>) value;
			for (int k = 0; k < arrlist.size(); k++) {
				Map<String, Object> payloadCol = new LinkedHashMap<String, Object>();
				Iterator it = otherCol.entrySet().iterator();
				while (it.hasNext()) {
					Map.Entry pair = (Map.Entry) it.next();
					payloadCol.put(pair.getKey().toString(), pair.getValue());
				}
				for (String column : columnNames) {
					if (column.startsWith("vt_")) {
						payloadCol.put(column, null);
					}
				}
				Map<String, Object> eacharray = (Map<String, Object>) arrlist.get(k);
				for (Map.Entry<String, Object> entry : eacharray.entrySet()) {
					String hkey = entry.getKey().replaceAll(" ", "");
					String nkey = "vt_" + key1 + "_" + hkey;
					Object hvalue = entry.getValue();
					if (columnNames.contains(nkey)) {
						payloadCol.put(nkey, hvalue);
					}
				}
				data.add(new ArrayList<Object>(payloadCol.values()));

			}

		}
		return data;

	}

	public void addLastLocationAttribute(NGNAppAct pq, String requestId) {
		/*
		 * try { if (pq.getCoordinates() != null && pq.getCoordinates().size() > 0) {
		 * String tableName = pq.isIdentified() ? LoggerUtil.USER_Table :
		 * LoggerUtil.ANON_USER_Table; String clientId = "s_" + pq.getClientId() + ".";
		 * String clientTable = clientId + tableName + "_" + pq.getEventId(); Document
		 * query = new Document("uid", pq.getUserid()); Document attributeDoc = new
		 * Document(); Map<String, Object> map = new HashMap<>(); map.put("type",
		 * "Point"); map.put("coordinates", pq.getCoordinates()); Document cordinate =
		 * new Document(map); attributeDoc.put("a.lc", cordinate); col.updateOne(query,
		 * new Document("$set", attributeDoc), new UpdateOptions().upsert(true)); } }
		 * catch (Exception e) { logger.error(requestId + " " + e.getMessage(), e); }
		 */
	}

}
