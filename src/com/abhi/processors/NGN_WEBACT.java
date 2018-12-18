package com.abhi.processors;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.abhi.pojo.NGNWebAct;
import com.abhi.util.LoggerUtil;

public class NGN_WEBACT extends AbstractTask {
	private Logger logger = Logger.getLogger(this.getClass());

	public void run() {
		try {
			long startTime = System.currentTimeMillis();
			logger.info(this.requestId + " - KafkaString : " + jsonPayload);
			NGNWebAct webAct = (NGNWebAct) LoggerUtil.getObjectFromJson(jsonPayload, NGNWebAct.class);
			long[] act = LoggerUtil.getDOWDayTimefromTS(webAct.getTs());
			int[] bodData = LoggerUtil.getBod(String.valueOf(webAct.getBod()));
			String schema = "s_" + webAct.getClientId();
			String table = schema + "."
					+ (webAct.isIdentified() ? LoggerUtil.ENGAGEMENT_TABLE : LoggerUtil.ANON_ENGAGEMENT_TABLE) + "_"
					+ webAct.getEventId();
			List<String> columns = LoggerUtil.getTableColumns(table);
			Map<String, Object> otherColumns = new LinkedHashMap<String, Object>();
			for (String column : columns) {
				if (!column.startsWith("vt_")) {
					otherColumns.put(column, "NULL");
				}
			}
			for (String column : otherColumns.keySet()) {
				if (column.equals("b")) {
					otherColumns.put(column, bodData[2]);
				} else if (column.equals("o")) {
					otherColumns.put(column, bodData[1]);
				} else if (column.equals("d")) {
					otherColumns.put(column, bodData[0]);
				} else if (column.equals("ad")) {
					otherColumns.put(column, act[1]);
				} else if (column.equals("adat")) {
					otherColumns.put(column, act[3]);
				} else {
					Object systemData = LoggerUtil.getNGNWebActField(webAct, column, NGN_WEBACT.class.getName());
					otherColumns.put(column, systemData);
				}
			}
			Map<String, Object> payload = webAct.getPayload();
			List<Object> data = LoggerUtil.processPayload(payload, columns, otherColumns);
			String header = LoggerUtil.getListAsCsvString(columns), rows = "";
			for (Object object : data) {
				rows = LoggerUtil.listToCsvString(rows, (List<Object>) object);
			}
			LoggerUtil.pushForFurtherProcessing(table, header, rows);

			logger.info(this.requestId + " - Time taken : " + (System.currentTimeMillis() - startTime));
		} catch (Exception e) {
			logger.error(this.requestId + " - Error : " + e.getMessage(), e);
		}
	}

	public static void main(String[] args) {
		NGN_APPACT object = new NGN_APPACT();
		object.jsonPayload = "{\"sourceId\":1217,\"tx\":1543321889131,\"uuid\":\"02f14b19-8a77-4324-bf03-5e7d8c39cd08\",\"identified\":true,\"payload\":{\"page_url\":\"http://demo1.netcoresmartech.com/ngn_pr/\"},\"eventName\":\"pageview\",\"notificationId\":0,\"eventId\":105,\"tsDate\":1543321885000,\"eventType\":\"w\",\"userTimings\":1543321889138,\"userKey\":\"ADGMOT35CHFLVDHBJNIG50K96AESQ4JA990AB2TFT7AEALKN98L0\",\"sts\":0,\"bod\":1510,\"customerKey\":\"abhinandan.kothari@netcore.co.in\",\"automationId\":0,\"msgId\":0,\"title\":\"E-Cart – Web Tracking – Demo\",\"sid\":1543321889131,\"isAmplified\":0,\"channelId\":0,\"conversion\":false,\"clientId\":20140,\"userId\":43,\"pts\":0,\"url\":\"http://demo1.netcoresmartech.com/ngn_pr/\",\"ptx\":0,\"npv\":1,\"siteId\":\"268eab354174d4df44c3f420088055f4\",\"visit\":\"returning\",\"ts\":181127180125}";
		Thread thread = new Thread(object);
		thread.start();
	}

}
