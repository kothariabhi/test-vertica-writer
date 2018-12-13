package com.abhi.processors;

import java.util.Arrays;
import java.util.List;

import com.abhi.pojo.LTOT;
import com.abhi.pojo.LTOTMap;
import com.abhi.util.LoggerUtil;

public class PR1_BATCH_EMLT extends AbstractTask {

	public void run() {
		try {
			long startTime = System.currentTimeMillis();

			System.out.println("KafkaString : " + kafkaString);
			LTOTMap ltotMap = (LTOTMap) LoggerUtil.getObjectFromJson(kafkaString, LTOTMap.class);
			String openString = "", clickString = "";
			String openHeader = "uid,mid,aid,b,o,d,ad,adat", clickHeader = "uid,mid,aid,fid,b,o,d,ad,adat";
			String schema = "s_" + ltotMap.getClientId();
			String openTable = schema + ".userDetails_e_o", clickTable = schema + ".userDetails_e_c";

			for (LTOT ltot : ltotMap.getLtotList()) {
				int[] bodData = LoggerUtil.getBod(String.valueOf(ltot.getBod()));
				long[] act = LoggerUtil.getDOWDayTimefromTS(ltot.getTs());
				if (ltot.getActivity().equals("open")) {
					List<Object> openData = Arrays.asList(ltot.getUid(), ltot.getMid(), ltot.getAutomationId(),
							bodData[2], bodData[1], bodData[0], act[1], act[3]);
					openString = LoggerUtil.listToCsvString(openString, openData);

				} else {
					List<Object> clickData = Arrays.asList(ltot.getUid(), ltot.getMid(), ltot.getAutomationId(),
							ltot.getLid(), bodData[2], bodData[1], bodData[0], act[1], act[3]);
					clickString = LoggerUtil.listToCsvString(clickString, clickData);
				}
			}

			LoggerUtil.pushForFurtherProcessing(openTable, openHeader, openString);
			LoggerUtil.pushForFurtherProcessing(clickTable, clickHeader, clickString);

			System.out.println("Time taken : " + (System.currentTimeMillis() - startTime));
		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		PR1_BATCH_EMLT object = new PR1_BATCH_EMLT();
		object.kafkaString = "{\"clientId\":18230,\"ltotList\":[{\"cid\":18230,\"mid\":1160,\"automationId\":0,\"uid\":5}]}";
		object.kafkaString = "{\"clientId\":18230,\"ltotList\":[{\"cid\":18230,\"mid\":1160,\"automationId\":0,\"uid\":5,\"bod\":1615,\"ts\":181210055030,\"activity\":\"open\"},{\"cid\":18230,\"mid\":1160,\"automationId\":0,\"uid\":5,\"bod\":1615,\"ts\":181210055030,\"lid\":45,\"activity\":\"click\"},{\"cid\":18230,\"mid\":1160,\"automationId\":0,\"uid\":5,\"bod\":1615,\"ts\":181210055030,\"activity\":\"open\"},{\"cid\":18230,\"mid\":1160,\"automationId\":0,\"uid\":5,\"bod\":1615,\"ts\":181210055030,\"lid\":45,\"activity\":\"click\"}]}";
		Thread thread = new Thread(object);
		thread.start();
	}

}
