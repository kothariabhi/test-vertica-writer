package com.abhi.processors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.abhi.pojo.SmsBc;
import com.abhi.util.LoggerUtil;

public class PR1_SMSBC extends AbstractTask {
	
	public void run() {
		try {
			long startTime = System.currentTimeMillis();
			
			System.out.println("KafkaString : " + kafkaString);
			SmsBc smsBc = (SmsBc) LoggerUtil.getObjectFromJson(kafkaString, SmsBc.class);
			List<String> rows = new ArrayList<String>();
			long[] act = LoggerUtil.getDOWDayTimefromTS(smsBc.getTs());
			String schema = "s_" + smsBc.getClientId(), header = "uid,mid,aid,ad,adat";
			String table = schema + "." + (smsBc.getStatus() != null && smsBc.getStatus().equals("drop") ? "userDetails_s_ssfd" : "userDetails_s_ss");
			String commonRow = LoggerUtil.getListAsCsvString(Arrays.asList(smsBc.getMsgId(), 0, act[1], act[3]));
			for (int userId : smsBc.getUserId()) {
				rows.add(userId+","+commonRow);
			}
			
			LoggerUtil.pushForFurtherProcessing(table, header, rows);
			System.out.println("Time taken : " + (System.currentTimeMillis() - startTime));
		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		PR1_SMSBC object = new PR1_SMSBC();
		object.kafkaString = "{\"clientId\":18230,\"msgId\":1160,\"skip\":false,\"userId\":[5,9,15,4789695],\"ts\":" + 
		"181210174706,\"status\":\"drop\"}";
		Thread thread = new Thread(object);
		thread.start();
	}

}
