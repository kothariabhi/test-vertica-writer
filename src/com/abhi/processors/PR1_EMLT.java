package com.abhi.processors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;

import com.abhi.pojo.EmLt;
import com.abhi.util.LoggerUtil;

public class PR1_EMLT extends AbstractTask {
	private Logger logger = Logger.getLogger(this.getClass());

	public void run() {
		try {
			long startTime = System.currentTimeMillis();

			logger.info(requestId + " - KafkaString : " + jsonPayload);
			EmLt emLt = (EmLt) LoggerUtil.getObjectFromJson(jsonPayload, EmLt.class);
			String rows = "";
			int[] bodData = LoggerUtil.getBod(String.valueOf(emLt.getBod()));
			long[] act = LoggerUtil.getDOWDayTimefromTS(emLt.getTs());
			String schema = "s_" + emLt.getClientId(), header = "uid,mid,aid,b,o,d,ad,adat";
			String table = schema + ".userDetails_e_o";
			List<Object> data = new ArrayList<>(Arrays.asList(emLt.getUserId(), emLt.getMsgId(), emLt.getAutomationId(),
					bodData[2], bodData[1], bodData[0], act[1], act[3]));
			if (emLt.getActivity().equals("click")) {
				table = schema + ".userDetails_e_c";
				header += ",fid";
				data.add(emLt.getLinkId());
			}
			rows = LoggerUtil.getListAsCsvString(data);

			LoggerUtil.pushForFurtherProcessing(table, header, rows);
			logger.info(requestId + " - Time taken : " + (System.currentTimeMillis() - startTime));
		} catch (Exception e) {
			logger.error(requestId + " - Error : " + e.getMessage(), e);
		}
	}

	public static void main(String[] args) {
		PR1_EMLT object = new PR1_EMLT();
		// Open
		object.jsonPayload = "{\"gmail\":1,\"automationId\":51,\"clientId\":14340,\"activity\":\"open\",\"linkId\":0,\"msgId\":43,\"type\":\"TROT\",\"userId\":2,\"domainId\":1,\"trId\":\"14340-43-2-51-180621192239\",\"bod\":0,\"ts\":181127112242}";
		// Click
		// object.kafkaString =
		// "{\"gmail\":1,\"automationId\":51,\"clientId\":19690,\"activity\":\"click\",\"linkId\":26,\"ip\":\"192.168.41.29\",\"msgId\":43,\"type\":\"TRLT\",\"userId\":2,\"domainId\":1,\"trId\":\"19690-43-2-51-180621192239\",\"bod\":1514,\"ts\":181210175846}";
		Thread thread = new Thread(object);
		thread.start();
	}

}
