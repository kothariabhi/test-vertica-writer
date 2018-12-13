package com.abhi.processors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.abhi.pojo.SmsDlr;
import com.abhi.pojo.SmsDlrMap;
import com.abhi.util.LoggerUtil;

public class PR1_DMPINGBCK2 extends AbstractTask {
	
	public void run() {
		try {
			long startTime = System.currentTimeMillis();
			
			System.out.println("KafkaString : " + kafkaString);
			SmsDlrMap dlrMap = (SmsDlrMap) LoggerUtil.getObjectFromJson(kafkaString, SmsDlrMap.class);
			List<String> rows = new ArrayList<String>();
			String schema = "s_" + dlrMap.getClientId(), status = dlrMap.getStatus(), header = "uid,mid,aid,ad,adat", table;
			if (status.equals("smsdelivered")) {
				table = schema + ".userDetails_s_sd";
			} else if (status.equals("smsndnc")) {
				table = schema + ".userDetails_s_sn";
			} else {
				table = schema + ".userDetails_s_so";
			}
			for (SmsDlr smsDlr : dlrMap.getDlrList()) {
				long[] act = LoggerUtil.getDOWDayTimefromTS(Long.parseLong(smsDlr.getTs()));
				List<Object> data = Arrays.asList(smsDlr.getUserid(), smsDlr.getMsgid(), smsDlr.getAutomationid(), act[1], act[3]);
				rows.add(LoggerUtil.getListAsCsvString(data));
			}

			LoggerUtil.pushForFurtherProcessing(table, header, rows);
			System.out.println("Time taken : " + (System.currentTimeMillis() - startTime));
		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		PR1_DMPINGBCK2 object = new PR1_DMPINGBCK2();
		object.kafkaString = "{\"clientId\":18230,\"status\":\"smsother\",\"dlrList\":[{\"clientid\":18230,\"msgid\":1160,\"automationid\":0,\"userid\":5,\"sc\":0,\"circleid\":-1,\"ts\":\"181210174706\",\"status\":\"smsother\",\"mobile\":\"\",\"reqid\":\"0\",\"deliverytime\":\"2018-12-10 17:47:06\",\"operator\":\"\",\"circle\":\"\",\"txnid\":\"18230-1160-5-0-181210174706\",\"feedid\":\"358097\",\"senttime\":\"2018-12-10 17:47:06\",\"bbtxnid\":\"\",\"publishDate\":\"181210\",\"sentTs\":\"181210174706\",\"send_to_eaf\":1,\"statuscode\":\"28\",\"operatorid\":-1},{\"clientid\":18230,\"msgid\":1160,\"automationid\":0,\"userid\":9,\"sc\":0,\"circleid\":-1,\"ts\":\"181210174706\",\"status\":\"smsother\",\"mobile\":\"\",\"reqid\":\"0\",\"deliverytime\":\"2018-12-10 17:47:06\",\"operator\":\"\",\"circle\":\"\",\"txnid\":\"18230-1160-9-0-181210174706\",\"feedid\":\"358097\",\"senttime\":\"2018-12-10 17:47:06\",\"bbtxnid\":\"\",\"publishDate\":\"181210\",\"sentTs\":\"181210174706\",\"send_to_eaf\":1,\"statuscode\":\"28\",\"operatorid\":-1},{\"clientid\":18230,\"msgid\":1160,\"automationid\":0,\"userid\":15,\"sc\":0,\"circleid\":-1,\"ts\":\"181210174706\",\"status\":\"smsother\",\"mobile\":\"\",\"reqid\":\"0\",\"deliverytime\":\"2018-12-10 17:47:06\",\"operator\":\"\",\"circle\":\"\",\"txnid\":\"18230-1160-15-0-181210174706\",\"feedid\":\"358097\",\"senttime\":\"2018-12-10 17:47:06\",\"bbtxnid\":\"\",\"publishDate\":\"181210\",\"sentTs\":\"181210174706\",\"send_to_eaf\":1,\"statuscode\":\"28\",\"operatorid\":-1}]}";
		Thread thread = new Thread(object);
		thread.start();
	}

}
