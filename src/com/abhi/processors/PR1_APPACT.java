package com.abhi.processors;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.abhi.pojo.PushQuery;
import com.abhi.util.LoggerUtil;

public class PR1_APPACT extends AbstractTask {
	private Logger logger = Logger.getLogger(this.getClass());

	public void run() {
		try {
			long startTime = System.currentTimeMillis();
			logger.info(this.requestId + " - KafkaString : " + jsonPayload);
			PushQuery pq = (PushQuery) LoggerUtil.getObjectFromJson(jsonPayload, PushQuery.class);
			pnInAppUActivity(pq, this.requestId);
			addLastLocationAttribute(pq, requestId);
			logger.info(this.requestId + " - Time taken : " + (System.currentTimeMillis() - startTime));
		} catch (Exception e) {
			logger.error(this.requestId + " - Error : " + e.getMessage(), e);
		}
	}

	public static void main(String[] args) {
		PR1_APPACT object = new PR1_APPACT();
		object.jsonPayload = "{\"appVersion\":\"1.0\",\"tx\":1538645152620,\"pushId\":\"aeb68041-563e-4e90-ab6c-4282163a62ae\",\"identified\":true,\"payload\":[{\"prqt\":1,\"price\":\"15000 Rs.\",\"name\":\"Nexus 5\",\"prid\":2}],\"appId\":\"1827b0219c3702b8f4380562192c237c\",\"model\":\"Lenovo K8 Plus\",\"lat\":\"17.805972\",\"eventId\":0,\"cts\":181004145552,\"lng\":\"83.279058\",\"tsDate\":\"Dec 14, 2018 2:30:37 PM\",\"osId\":1,\"sts\":0,\"bod\":2602,\"sdkVersion\":\"1.0.9\",\"automationId\":0,\"osVersion\":\"7.1.1\",\"identity\":\"kafkaload491936@m.pragatee.com\",\"osType\":\"Android\",\"make\":\"LENOVO\",\"channelId\":0,\"payloadMap\":{\"prqt\":1,\"price\":\"15000 Rs.\",\"name\":\"Nexus 5\",\"prid\":2},\"clientId\":14340,\"sessionId\":\"1538645120324\",\"userId\":5035884,\"pts\":0,\"atci\":0,\"ts\":181004145554}";
		Thread thread = new Thread(object);
		thread.start();
	}

	private void pnInAppUActivity(PushQuery pq, String requestId) {
		// TODO Auto-generated method stub
		try {
			String rows = "";
			long[] act = LoggerUtil.getDOWDayTimefromTS(pq.getTs());
			int[] bodData = LoggerUtil.getBod(String.valueOf(pq.getBod()));
			String tableName = pq.isIdentified() ? LoggerUtil.ENGAGEMENT_TABLE : LoggerUtil.ANON_ENGAGEMENT_TABLE;
			String clientId = "s_" + pq.getClientId() + ".";
			String clientTable = clientId + tableName + "_" + pq.getEventId();
			List<String> columnNames = LoggerUtil.getTableColumns(clientTable);
			List<Object> dataObject = new ArrayList<Object>();
			for (String column : columnNames) {
				if (!column.startsWith("vt_")) {
					if (column.equals("b")) {
						dataObject.add(bodData[2]);
					} else if (column.equals("o")) {
						dataObject.add(bodData[1]);
					} else if (column.equals("d")) {
						dataObject.add(bodData[0]);
					} else if (column.equals("ad")) {
						dataObject.add(act[1]);
					} else if (column.equals("adat")) {
						dataObject.add(act[3]);
					} else {
						Object systemData = LoggerUtil.getPojoField(pq, column, "a");
						dataObject.add(systemData);
					}
				} else {
					String key = column.replaceFirst("vt_", "");
					dataObject.add(pq.getPayloadMap().get(key));
				}
			}
			rows = LoggerUtil.getListAsCsvString(dataObject);
			String header = LoggerUtil.getListAsCsvString(columnNames);
			LoggerUtil.pushForFurtherProcessing(clientTable, header, rows);
		} catch (Exception e) {
			logger.error(requestId + " " + e.getMessage(), e);
		}

	}

	public void addLastLocationAttribute(PushQuery pq, String requestId) {
		/*try {
			if (pq.getCoordinates() != null && pq.getCoordinates().size() > 0) {
				String tableName = pq.isIdentified() ? LoggerUtil.USER_Table : LoggerUtil.ANON_USER_Table;
				String clientId = "s_" + pq.getClientId() + ".";
				String clientTable = clientId + tableName + "_" + pq.getEventId();
				Document query = new Document("uid", pq.getUserid());
				Document attributeDoc = new Document();
				Map<String, Object> map = new HashMap<>();
				map.put("type", "Point");
				map.put("coordinates", pq.getCoordinates());
				Document cordinate = new Document(map);
				attributeDoc.put("a.lc", cordinate);
				col.updateOne(query, new Document("$set", attributeDoc), new UpdateOptions().upsert(true));
			}
		} catch (Exception e) {
			logger.error(requestId + " " + e.getMessage(), e);
		}*/
	}

}
