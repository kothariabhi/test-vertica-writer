package com.abhi.processors;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;

import com.abhi.pojo.PnBcTr;
import com.abhi.util.LoggerUtil;

public class PR1_PN_BC_TR extends AbstractTask {
	private Logger logger = Logger.getLogger(this.getClass());
	
	public void run() {
		try {
			long startTime = System.currentTimeMillis();

			logger.info(requestId + " - KafkaString : " + jsonPayload);
			PnBcTr pnBcTr = (PnBcTr) LoggerUtil.getObjectFromJson(jsonPayload, PnBcTr.class);
			int[] userIds = pnBcTr.getUserId();
			long[] act = LoggerUtil.getDOWDayTimefromTS(pnBcTr.getTs());
			String header = "uid,mid,aid,ad,adat", rows = "";
			String schema = "s_" + pnBcTr.getClientId();
			String table = schema + "." + LoggerUtil.PN_BC_TR_TABLE_MAP.get(pnBcTr.getEventType()).get(pnBcTr.getStatus()).get(pnBcTr.getIdentified());
			for (int i=0; i<userIds.length; i++) {
				List<Object> data = Arrays.asList(userIds[i], pnBcTr.getMsgId(), pnBcTr.getAutomationId(), act[1], act[3]);
				rows = LoggerUtil.listToCsvString(rows, data);
			}
			LoggerUtil.pushForFurtherProcessing(table, header, rows);
			
			logger.info(requestId + " - Time taken : " + (System.currentTimeMillis() - startTime));
		} catch (Exception e) {
			logger.error(requestId + " - Error : " + e.getMessage(), e);
		}
	}

	public static void main(String[] args) {
		PR1_PN_BC_TR object = new PR1_PN_BC_TR();
		object.jsonPayload = "{\"sourceId\":876,\"automationId\":0,\"clientId\":18740,\"msgId\":272,\"skip\":true,\"eventType\":\"web\",\"userId\":[21289,35336,35330],\"trId\":\"18740-272-0-0-181127112239-A\",\"token\":[\"f7kWTDRIDRY:APA91bGeb8Ea5_-9Mhxoxas0QAXODR5yxLLMqM6xjPCwi_rODiXnaulxyr0ju5s0xORaHQIkebxTPxugYW0pHSddaAsGryCiq430aXgYFOrxq49cSTqH9rj2r1SC1PX6BN1GsLHeL7JN\",\"eYx1eR-LX9g:APA91bHn0qCxbJdnfxk4RrIHVTqvx13HRBxOyLHWhSkyQ4REuFUgT17S8LV6bWkcvjgRMsa8rTRKFRsP2OBD74t9PXAyKqlviyKdfWYs2xjGCbxkGgB0H51XYQOjseGRhJ5EBDqhVDao\",\"dQCZK4N2TPU:APA91bEyTEpx_YrpZnbQ4vSHdV21KriBDWpLc2u0qzvfaNwiacCkUE54CAbhgc6DS7WcOkYpGEINz6UoYBnBuIuIsRh9C_H0vcdEEGjo8LFF3qzkFB9MAysoiHU3EfbK2r4hk_Kmfbpt\"],\"pushId\":[\"47f012f9-3be7-4d58-8ce4-986d73cacaf0\",\"9df893fb-55de-47a3-8e43-786da6cc4ac2\",\"98a2daf4-0ccc-471a-a8bf-39214f19188c\"],\"identified\":0,\"bod\":[2614,1514,1514],\"siteId\":\"118217387f12dbb115129d655f3044af\",\"ts\":181127112239,\"status\":\"sent\"}";
		Thread thread = new Thread(object);
		thread.start();
	}

}
