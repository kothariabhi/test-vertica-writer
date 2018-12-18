package com.abhi.processors;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;

import com.abhi.pojo.FcSent;
import com.abhi.util.LoggerUtil;

public class PR1_FCSENT extends AbstractTask {
	private Logger logger = Logger.getLogger(this.getClass());

	public void run() {
		try {
			long startTime = System.currentTimeMillis();

			logger.info(requestId + " - KafkaString : " + jsonPayload);
			FcSent fcSent = (FcSent) LoggerUtil.getObjectFromJson(jsonPayload, FcSent.class);
			String datastring = "";
			long[] act = LoggerUtil.getDOWDayTimefromTS(fcSent.getTs());
			String schema = "s_" + fcSent.getClientId(), header = "uid,mid,aid,ad,adat";
			String table = schema + "."
					+ (fcSent.getStatus() != null && fcSent.getStatus().equals("drop") ? "userDetails_e_sfd"
							: "userDetails_e_s");
			List<Object> data = Arrays.asList(fcSent.getUserId(), fcSent.getMsgId(), fcSent.getAutomationId(), act[1],
					act[3]);
			datastring = LoggerUtil.listToCsvString(datastring, data);

			LoggerUtil.pushForFurtherProcessing(table, header, datastring);
			logger.info(requestId + " - Time taken : " + (System.currentTimeMillis() - startTime));
		} catch (Exception e) {
			logger.error(requestId + " - Error : " + e.getMessage(), e);
		}
	}

	public static void main(String[] args) {
		PR1_FCSENT object = new PR1_FCSENT();
		object.jsonPayload = "{\"automationId\":209,\"clientId\":18040,\"size\":0,\"msgId\":461,\"userId\":1383191,\"freqCapFlag\":0,\"ts\":181210172427,\"trId\":\"18040-461-1383191-209-181210172427\"}";
		Thread thread = new Thread(object);
		thread.start();
	}

}
