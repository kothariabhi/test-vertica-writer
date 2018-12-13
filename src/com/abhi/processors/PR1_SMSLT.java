package com.abhi.processors;

import java.util.Arrays;
import java.util.List;

import com.abhi.pojo.SmsLt;
import com.abhi.util.LoggerUtil;

public class PR1_SMSLT extends AbstractTask {

	public void run() {
		try {
			long startTime = System.currentTimeMillis();

			System.out.println("KafkaString : " + kafkaString);
			String datastring = "";
			SmsLt smsLt = (SmsLt) LoggerUtil.getObjectFromJson(kafkaString, SmsLt.class);
			int[] bodData = LoggerUtil.getBod(String.valueOf(smsLt.getAgentCode()));
			long[] act = LoggerUtil.getDOWDayTimefromTS(smsLt.getTs());
			String schema = "s_" + smsLt.getClientId(), header = "uid,mid,aid,fid,b,o,d,ad,adat";
			String table = schema + ".userDetails_s_sc";
			List<Object> data = Arrays.asList(smsLt.getUserId(), smsLt.getMsgId(), smsLt.getAutomationId(),
					smsLt.getLinkId(), bodData[2], bodData[1], bodData[0], act[1], act[3]);
			datastring = LoggerUtil.listToCsvString(datastring, data);

			LoggerUtil.pushForFurtherProcessing(table, header, datastring);
			System.out.println("Time taken : " + (System.currentTimeMillis() - startTime));
		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		PR1_SMSLT object = new PR1_SMSLT();
		object.kafkaString = "{\"automationId\":0,\"clientId\":18740,\"linkId\":398,\"agentCode\":1514,\"ip\":\"192.168.41.85\",\"msgId\":94,\"linkText\":\"https://demo1.netcoresmartech.com/pssegment/\",\"userId\":1115538,\"trId\":\"\",\"ts\":181210185610}";
		Thread thread = new Thread(object);
		thread.start();
	}

}
