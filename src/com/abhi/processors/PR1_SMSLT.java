package com.abhi.processors;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;

import com.abhi.pojo.SmsLt;
import com.abhi.util.LoggerUtil;

public class PR1_SMSLT extends AbstractTask {
	private Logger logger = Logger.getLogger(this.getClass());

	public void run() {
		try {
			long startTime = System.currentTimeMillis();

			logger.info(requestId + " - KafkaString : " + jsonPayload);
			String datastring = "";
			SmsLt smsLt = (SmsLt) LoggerUtil.getObjectFromJson(jsonPayload, SmsLt.class);
			int[] bodData = LoggerUtil.getBod(String.valueOf(smsLt.getAgentCode()));
			long[] act = LoggerUtil.getDOWDayTimefromTS(smsLt.getTs());
			String schema = "s_" + smsLt.getClientId(), header = "uid,mid,aid,fid,b,o,d,ad,adat";
			String table = schema + ".userDetails_s_sc";
			List<Object> data = Arrays.asList(smsLt.getUserId(), smsLt.getMsgId(), smsLt.getAutomationId(),
					smsLt.getLinkId(), bodData[2], bodData[1], bodData[0], act[1], act[3]);
			datastring = LoggerUtil.listToCsvString(datastring, data);

			LoggerUtil.pushForFurtherProcessing(table, header, datastring);
			logger.info(requestId + " - Time taken : " + (System.currentTimeMillis() - startTime));
		} catch (Exception e) {
			logger.error(requestId + " - Error : " + e.getMessage(), e);
		}
	}

	public static void main(String[] args) {
		PR1_SMSLT object = new PR1_SMSLT();
		object.jsonPayload = "{\"automationId\":0,\"clientId\":18740,\"linkId\":398,\"agentCode\":1514,\"ip\":\"192.168.41.85\",\"msgId\":94,\"linkText\":\"https://demo1.netcoresmartech.com/pssegment/\",\"userId\":1115538,\"trId\":\"\",\"ts\":181210185610}";
		Thread thread = new Thread(object);
		thread.start();
	}

}
