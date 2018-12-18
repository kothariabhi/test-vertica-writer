package com.abhi.processors;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;

import com.abhi.pojo.PnBcTr;
import com.abhi.util.LoggerUtil;

public class PR1_APPUNINSTALL extends AbstractTask {
	private Logger logger = Logger.getLogger(this.getClass());
	
	public void run() {
		try {
			long startTime = System.currentTimeMillis();

			logger.info(requestId + " - KafkaString : " + jsonPayload);
			PnBcTr pnBcTr = (PnBcTr) LoggerUtil.getObjectFromJson(jsonPayload, PnBcTr.class);
			int[] userIds = pnBcTr.getUserId();
			long[] act = LoggerUtil.getDOWDayTimefromTS(pnBcTr.getTs());
			String rows = "", header = "uid,evtid,srcid,et,ad,adat";
			String table = "s_" + pnBcTr.getClientId() + ".engagementDetails_" + LoggerUtil.APP_UNINSTALLED;
			for (int i=0; i<userIds.length; i++) {
				List<Object> data = Arrays.asList(userIds[i], LoggerUtil.APP_UNINSTALLED, pnBcTr.getSourceId(), "a", act[1], act[3]);
				rows = LoggerUtil.listToCsvString(rows, data);
			}
			LoggerUtil.pushForFurtherProcessing(table, header, rows);
			
			logger.info(requestId + " - Time taken : " + (System.currentTimeMillis() - startTime));
		} catch (Exception e) {
			logger.error(requestId + " - Error : " + e.getMessage(), e);
		}
	}

	public static void main(String[] args) {
		PR1_APPUNINSTALL object = new PR1_APPUNINSTALL();
		object.jsonPayload = "{\"sourceId\":0,\"automationId\":0,\"clientId\":18740,\"os\":\"android\",\"msgId\":849,\"description\":[\"NotRegistered\"],\"skip\":false,\"eventType\":\"app\",\"userId\":[1694],\"trId\":\"18740-849-1694-0-181127115931\",\"token\":[\"emyXL2YMJXE:APA91bEcBR3hfB7tAKbyYt5rF1OLth9aN2-7Vzx_gN1xHJZn0Fq7fULAiyRTP1Gy_Am9XyE6FxMmNDwEP8jXtStgiENejZJn3IBGcqxLi7Cgj1_qJmAkLvdoKFr0k1yuyJa0gRB_fel9\"],\"pushId\":[\"32f2a345-01e0-4be8-a849-c43a6f253e83\"],\"identified\":1,\"bod\":[2602],\"appId\":\"caac4797a13be33eb14617e5935086f9\",\"ts\":181127115931,\"status\":\"failed\"}";
		Thread thread = new Thread(object);
		thread.start();
	}

}
