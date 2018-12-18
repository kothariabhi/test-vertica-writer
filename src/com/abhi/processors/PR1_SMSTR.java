package com.abhi.processors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;

import com.abhi.pojo.SmsTr;
import com.abhi.util.LoggerUtil;

public class PR1_SMSTR extends AbstractTask {
	private Logger logger = Logger.getLogger(this.getClass());

	public void run() {
		try {
			long startTime = System.currentTimeMillis();

			logger.info(requestId + " - KafkaString : " + jsonPayload);
			String datastring = "";
			SmsTr smsTr = (SmsTr) LoggerUtil.getObjectFromJson(jsonPayload, SmsTr.class);
			long[] act = LoggerUtil.getDOWDayTimefromTS(smsTr.getTs());
			String schema = "s_" + smsTr.getClientId(), header = "uid,mid,aid,ad,adat", table;
			List<Object> data = new ArrayList<>(Arrays.asList(smsTr.getUserId(), smsTr.getMsgId(), smsTr.getAutomationId(), act[1], act[3]));
			if (smsTr.getStatus() != null && smsTr.getStatus().equals("drop")) {
				table = schema + "." + "userDetails_s_ssfd";
				header += ",st";
				data.add("29");
			} else {
				table = schema + "." + "userDetails_s_ss";
			}
			datastring = LoggerUtil.listToCsvString(datastring, data);
			LoggerUtil.pushForFurtherProcessing(table, header, datastring);
			logger.info(requestId + " - Time taken : " + (System.currentTimeMillis() - startTime));
		} catch (Exception e) {
			logger.error(requestId + " - Error : " + e.getMessage(), e);
		}
	}

	public static void main(String[] args) {
		PR1_SMSTR object = new PR1_SMSTR();
		object.jsonPayload = "{\"automationId\":209,\"clientId\":18040,\"msgId\":144,\"userId\":1383189,\"freqCapFlag\":0,\"ts\":181210170054,\"trId\":\"18040-144-1383189-209-181210170054\"}";
		Thread thread = new Thread(object);
		thread.start();
	}

}
