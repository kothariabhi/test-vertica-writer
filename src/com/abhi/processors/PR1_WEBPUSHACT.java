package com.abhi.processors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;

import com.abhi.pojo.WebAct;
import com.abhi.util.LoggerUtil;

public class PR1_WEBPUSHACT extends AbstractTask {
	private Logger logger = Logger.getLogger(this.getClass());
	
	public void run() {
		try {
			long startTime = System.currentTimeMillis();

			logger.info(requestId + " - KafkaString : " + kafkaString);
			WebAct webAct = (WebAct) LoggerUtil.getObjectFromJson(kafkaString, WebAct.class);
			
			if (webAct.getActivityId()  == LoggerUtil.PUSH_SUBSCRIBE || webAct.getActivityId() == LoggerUtil.PUSH_UNSUBSCRIBE ) {
				return;
			}
			
			String schema = "s_" + webAct.getClientId(), header, row = "", table;
			long[] act = LoggerUtil.getDOWDayTimefromTS(webAct.getTs());
			int[] bodData = LoggerUtil.getBod(String.valueOf(webAct.getBod()));
			List<Object> data;
			if (webAct.getNotificationType().equals("webpush")) {
				table = schema + "." + LoggerUtil.PR1_WEBPUSHACT_TABLE_MAP.get(webAct.getAction()).get(webAct.isIdentified() ? 1 : 0);
				header = "uid,mid,aid,b,o,d,ad,adat";
				data = new ArrayList<>(Arrays.asList(webAct.getUserId(), webAct.getMsgId(), webAct.getAutomationId(), bodData[2], 
						bodData[1], bodData[0], act[1], act[3]));
				if (webAct.getAction().equals("open")) {
					header += ",fid";
					data.add(webAct.getClickLinkId());
				}
			} else {
				table = schema + "." + (webAct.isIdentified() ? LoggerUtil.ENGAGEMENT_TABLE : LoggerUtil.ANON_ENGAGEMENT_TABLE) + "_" + webAct.getActivityId();
				List<String> columns = LoggerUtil.getTableColumns(table);
				data = new ArrayList<Object>();
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
							Object systemData = LoggerUtil.getWebActField(webAct, column, PR1_WEBPUSHACT.class.getName());
							data.add(systemData);
						}
					} else {
						String key = column.replaceFirst("vt_", "");
						data.add(webAct.getTypeAwarePayload().getOrDefault(key, "NULL"));
					}
				}
				header = LoggerUtil.getListAsCsvString(columns);
			}
			
			row = LoggerUtil.listToCsvString(row, data);
			LoggerUtil.pushForFurtherProcessing(table, header, row);
			
			logger.info(requestId + " - Time taken : " + (System.currentTimeMillis() - startTime));
		} catch (Exception e) {
			logger.error(requestId + " - Error : " + e.getMessage(), e);
		}
	}

	public static void main(String[] args) {
		PR1_WEBPUSHACT object = new PR1_WEBPUSHACT();
		object.kafkaString = "{\"typeAwarePayload\":{\"sts\":0,\"npv\":0,\"autoid\":0,\"mid\":272,\"pts\":0},\"sourceId\":876,\"automationId\":0,\"browserId\":1,\"notificationType\":\"webpush\",\"trId\":\"18740-272-0-0-181127112239-A\",\"activityId\":12,\"identified\":false,\"action\":\"delivered\",\"notificationId\":0,\"webGuid\":\"98a2daf4-0ccc-471a-a8bf-39214f19188c\",\"clientId\":18740,\"ip\":\"192.168.41.40\",\"tsDate\":1543297964000,\"eventType\":\"w\",\"userId\":35330,\"pts\":0,\"token\":\"dQCZK4N2TPU:APA91bEyTEpx_YrpZnbQ4vSHdV21KriBDWpLc2u0qzvfaNwiacCkUE54CAbhgc6DS7WcOkYpGEINz6UoYBnBuIuIsRh9C_H0vcdEEGjo8LFF3qzkFB9MAysoiHU3EfbK2r4hk_Kmfbpt\",\"sts\":0,\"bod\":1514,\"siteId\":\"118217387f12dbb115129d655f3044af\",\"ts\":181127112244}";
		Thread thread = new Thread(object);
		thread.start();
	}

}
