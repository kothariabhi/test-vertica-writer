package com.abhi.processors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.abhi.pojo.FcSent;
import com.abhi.util.LoggerUtil;

public class PR1_FCSENT extends AbstractTask {
	
	public void run() {
		try {
			long startTime = System.currentTimeMillis();
			
			System.out.println("KafkaString : " + kafkaString);
			FcSent fcSent = (FcSent) LoggerUtil.getObjectFromJson(kafkaString, FcSent.class);
			List<String> rows = new ArrayList<String>();
			long[] act = LoggerUtil.getDOWDayTimefromTS(fcSent.getTs());
			String schema = "s_" + fcSent.getClientId(), header = "uid,mid,aid,ad,adat";
			String table = schema + "." + (fcSent.getStatus() != null && fcSent.getStatus().equals("drop") 
					? "userDetails_e_sfd" : "userDetails_e_s");
			rows.add(LoggerUtil.getListAsCsvString(Arrays.asList(fcSent.getUserId(), fcSent.getMsgId(), 
					fcSent.getAutomationId(), act[1], act[3])));
			
			LoggerUtil.pushForFurtherProcessing(table, header, rows);
			System.out.println("Time taken : " + (System.currentTimeMillis() - startTime));
		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		PR1_FCSENT object = new PR1_FCSENT();
		object.kafkaString = "{\"automationId\":209,\"clientId\":18040,\"size\":0,\"msgId\":461,\"userId\":1383191,\"freqCapFlag\":0,\"ts\":181210172427,\"trId\":\"18040-461-1383191-209-181210172427\"}";
		Thread thread = new Thread(object);
		thread.start();
	}

}
