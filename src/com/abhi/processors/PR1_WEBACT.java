package com.abhi.processors;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.abhi.pojo.WebAct;
import com.abhi.util.LoggerUtil;

public class PR1_WEBACT extends AbstractTask {
	private Logger logger = Logger.getLogger(this.getClass());
	
	public void run() {
		try {
			long startTime = System.currentTimeMillis();

			logger.info(requestId + " - KafkaString : " + kafkaString);
			WebAct webAct = (WebAct) LoggerUtil.getObjectFromJson(kafkaString, WebAct.class);
			String schema = "s_" + webAct.getClientId();
			long[] act = LoggerUtil.getDOWDayTimefromTS(webAct.getTs());
			int[] bodData = LoggerUtil.getBod(String.valueOf(webAct.getBod()));
			String table = schema + "." + (webAct.isIdentified() ? LoggerUtil.ENGAGEMENT_TABLE : LoggerUtil.ANON_ENGAGEMENT_TABLE) + "_" + webAct.getActivityId();
			List<String> columns = LoggerUtil.getTableColumns(table);
			List<Object> data = new ArrayList<Object>();
			for (String column : columns) {
				if (!column.startsWith("vt_")) {
					if (column.equals("b")) {
						data.add(bodData[2]);
					} else if (column.equals("o")) {
						data.add(bodData[1]);
					} else if (column.equals("d")) {
						data.add(bodData[0]);
					} else if (column.equals("ad")) {
						data.add(act[1]);
					} else if (column.equals("adat")) {
						data.add(act[3]);
					} else {
						Object systemData = LoggerUtil.getWebActField(webAct, column, PR1_WEBACT.class.getName());
						data.add(systemData);
					}
				} else {
					String key = column.replaceFirst("vt_", "");
					data.add(webAct.getTypeAwarePayload().getOrDefault(key, "NULL"));
				}
			}
			
			logger.info(requestId + " - Time taken : " + (System.currentTimeMillis() - startTime));
		} catch (Exception e) {
			logger.error(requestId + " - Error : " + e.getMessage(), e);
		}
	}

	public static void main(String[] args) {
		PR1_WEBACT object = new PR1_WEBACT();
		object.kafkaString = "{\"typeAwarePayload\":{\"sts\":69,\"tx\":1543300620888,\"npv\":1,\"autoid\":0,\"purl\":\"null\",\"title\":\"pankajnetcore\",\"url\":\"https://pankajnetcore.myshopify.com/\",\"pts\":0},\"sourceId\":1302,\"automationId\":0,\"browserId\":1,\"tx\":1543300620888,\"sessionid\":1543300620888,\"purl\":\"null\",\"title\":\"pankajnetcore\",\"activityId\":1,\"identified\":false,\"notificationId\":0,\"webGuid\":\"df7c85bd-11ba-462e-87fc-b61c20092b41\",\"clientId\":18870,\"ip\":\"127.0.0.1\",\"tsDate\":1543300876000,\"eventType\":\"w\",\"userId\":334,\"pts\":0,\"url\":\"https://pankajnetcore.myshopify.com/\",\"sts\":69,\"bod\":1514,\"siteId\":\"dc5b428f82126754b5f816d66debb4ee\",\"visit\":\"returning\",\"ts\":181127121116}";
		Thread thread = new Thread(object);
		thread.start();
	}

}
