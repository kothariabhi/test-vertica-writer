package com.abhi.processors;


public class PR1_BULKACT extends PR1_APPACT {
	/*private Logger logger = Logger.getLogger(this.getClass());
	
	public void run() {
		try {
			long startTime = System.currentTimeMillis();

			logger.info(requestId + " - KafkaString : " + kafkaString);
			PushQuery pq = (PushQuery) LoggerUtil.getObjectFromJson(kafkaString, PushQuery.class);
			long[] act = LoggerUtil.getDOWDayTimefromTS(pq.getCts());
			int[] bodData = LoggerUtil.getBod(String.valueOf(pq.getBod()));
			String schema = "s_" + pq.getClientId(), table;
			if (pq.isIdentified()) {
				table = schema + "." + LoggerUtil.ENGAGEMENT_TABLE + "_" + pq.getEventId();
			} else {
				table = schema + "." + LoggerUtil.ANON_ENGAGEMENT_TABLE + "_" + pq.getEventId();
			}
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
						Object systemData = LoggerUtil.getPojoField(pq, column, "a");
						data.add(systemData);
					}
				} else {
					String key = column.replaceFirst("vt_", "");
					data.add(pq.getPayloadMap().getOrDefault(key, null));
				}
			}
			
			String rows = LoggerUtil.getListAsCsvString(data);
			String header = LoggerUtil.getListAsCsvString(columns);
			LoggerUtil.pushForFurtherProcessing(table, header, rows);
			
			logger.info(requestId + " - Time taken : " + (System.currentTimeMillis() - startTime));
		} catch (Exception e) {
			logger.error(requestId + " - Error : " + e.getMessage(), e);
		}
	}

	public static void main(String[] args) {
		PR1_BULKACT object = new PR1_BULKACT();
		object.kafkaString = "{\"typeAwarePayload\":{\"sts\":69,\"tx\":1543300620888,\"npv\":1,\"autoid\":0,\"purl\":\"null\",\"title\":\"pankajnetcore\",\"url\":\"https://pankajnetcore.myshopify.com/\",\"pts\":0},\"sourceId\":1302,\"automationId\":0,\"browserId\":1,\"tx\":1543300620888,\"sessionid\":1543300620888,\"purl\":\"null\",\"title\":\"pankajnetcore\",\"activityId\":1,\"identified\":false,\"notificationId\":0,\"webGuid\":\"df7c85bd-11ba-462e-87fc-b61c20092b41\",\"clientId\":18870,\"ip\":\"127.0.0.1\",\"tsDate\":1543300876000,\"eventType\":\"w\",\"userId\":334,\"pts\":0,\"url\":\"https://pankajnetcore.myshopify.com/\",\"sts\":69,\"bod\":1514,\"siteId\":\"dc5b428f82126754b5f816d66debb4ee\",\"visit\":\"returning\",\"ts\":181127121116}";
		Thread thread = new Thread(object);
		thread.start();
	}*/

}
