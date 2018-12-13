package com.abhi.processors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;

import com.abhi.pojo.Embc;
import com.abhi.util.LoggerUtil;

public class PR1_EMBC {
	final static Logger logger = Logger.getLogger(PR1_EMBC.class);

	public static void main(String[] args) {
		String queueName = "PR1_EMBC";
		String kafkaString = "{\"clientId\":15260,\"msgId\":272,\"skip\":false,\"userId\":[4722361,6767,7878],\"ts\":181210185631,\"status\":\"drop\"}";
		try {
			long startTime = System.currentTimeMillis();
			logger.info(" kafkaString =" + kafkaString);
			List<Embc> embcList = new ArrayList<Embc>();
			Embc embcRequest = (Embc) LoggerUtil.getObjectFromJson(kafkaString, Embc.class);
			embcList.add(embcRequest);
			emmBC(embcList);
			logger.info(embcList.toString() + " - Execution time " + (System.currentTimeMillis() - startTime));

		} catch (Exception e) {
			logger.error(" FAILED RPUSH " + queueName + " " + kafkaString);
			e.printStackTrace();
		}
	}

	public static void emmBC(List<Embc> embcList) {

		try {
			for (Embc embcRequest : embcList) {
				try {
					String clientId = "s_" + embcRequest.getClientId() + ".";
					long ts = embcRequest.getTs();
					int userids[] = embcRequest.getUserId();
					String key = clientId + "userDetails_e_";
					String table = key + "s";

					if (embcRequest.getStatus() != null && embcRequest.getStatus().equals("drop")) {
						table = key + "sfd";
					}

					long[] act = LoggerUtil.getDOWDayTimefromTS(embcRequest.getTs());
					String query = "uid,mid,aid,ad,adat";
					String dataString = "";
					String delimiter = "";
					try {
						act = LoggerUtil.getDOWDayTimefromTS(ts);
						for (int uid : userids) {
							List<Object> data = Arrays.asList(uid, embcRequest.getMsgId(), 0, act[1], act[3]);
							logger.info("===" + dataString + "---------");
							if (!dataString.isEmpty()) {
								delimiter = "/n";
							}
							dataString = dataString + delimiter + LoggerUtil.getListAsCsvString(data);
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						logger.error(e.getMessage(), e);
					}
					LoggerUtil.pushForFurtherProcessing(table, query, dataString);

				} catch (Exception e) {
					// TODO Auto-generated catch block
					logger.error("Error while iterating App Activity " + e.getMessage());
					e.printStackTrace();
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("Error while inserting in App Activity table " + e.getMessage());
			e.printStackTrace();
		}
		// TODO Auto-generated method stub

	}

}
