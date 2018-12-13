package com.abhi.processors;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;

import com.abhi.pojo.SmsBc;
import com.abhi.util.LoggerUtil;

public class PR1_SMSBC extends AbstractTask {
	private Logger logger = Logger.getLogger(this.getClass());

	public void run() {
		try {
			long startTime = System.currentTimeMillis();
			String datastring = "";
			String commonString = "";
			logger.info(requestId + " - KafkaString : " + kafkaString);
			SmsBc smsBc = (SmsBc) LoggerUtil.getObjectFromJson(kafkaString, SmsBc.class);
			long[] act = LoggerUtil.getDOWDayTimefromTS(smsBc.getTs());
			String schema = "s_" + smsBc.getClientId(), header = "uid,mid,aid,ad,adat";
			String table = schema + "."
					+ (smsBc.getStatus() != null && smsBc.getStatus().equals("drop") ? "userDetails_s_ssfd"
							: "userDetails_s_ss");
			List<Object> data = Arrays.asList(smsBc.getMsgId(), 0, act[1], act[3]);
			commonString = LoggerUtil.listToCsvString(datastring, data);
			for (int userId : smsBc.getUserId()) {
				List<Object> rows = Arrays.asList(userId + "," + commonString);
				datastring = LoggerUtil.listToCsvString(datastring, rows);
			}
			LoggerUtil.pushForFurtherProcessing(table, header, datastring);
			logger.info(requestId + " - Time taken : " + (System.currentTimeMillis() - startTime));
		} catch (Exception e) {
			logger.error(requestId + " - Error : " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		PR1_SMSBC object = new PR1_SMSBC();
		object.kafkaString = "{\"clientId\":18230,\"msgId\":1160,\"skip\":false,\"userId\":[5,9,15,4789695],\"ts\":"
				+ "181210174706,\"status\":\"drop\"}";
		Thread thread = new Thread(object);
		thread.start();
	}

}
