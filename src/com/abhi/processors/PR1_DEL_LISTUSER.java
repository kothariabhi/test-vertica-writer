package com.abhi.processors;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.log4j.Logger;

import com.abhi.pojo.DelListUser;
import com.abhi.util.LoggerUtil;

public class PR1_DEL_LISTUSER extends AbstractTask {
	private Logger logger = Logger.getLogger(this.getClass());
	
	public void run() {
		try {
			long startTime = System.currentTimeMillis();

			logger.info(requestId + " - KafkaString : " + jsonPayload);
			DelListUser delListUser = (DelListUser) LoggerUtil.getObjectFromJson(jsonPayload, DelListUser.class);
			String table = "s_" + delListUser.getClientId() + ".userDetailsLists";
			String listIds = IntStream.of(delListUser.getList()).mapToObj(Integer::toString).collect(Collectors.joining(","));
			String userIds = IntStream.of(delListUser.getUserId()).mapToObj(Integer::toString).collect(Collectors.joining(","));
			String where = "lid IN (" + listIds + ") AND uid IN (" + userIds + ")";
			
			LoggerUtil.pushForDeleteInVertica(table, where);
			logger.info(requestId + " - Time taken : " + (System.currentTimeMillis() - startTime));
		} catch (Exception e) {
			logger.error(requestId + " - Error : " + e.getMessage(), e);
		}
	}
	
	public static void main(String[] args) {
		PR1_DEL_LISTUSER object = new PR1_DEL_LISTUSER();
		object.jsonPayload = "{\"clientId\":14340,\"list\":[421,420],\"userId\":[4739605,150445,150443,5029694,5029692,5029690,5029689],\"sendToEaf\":\"1\",\"ts\":181122143753}";
		Thread thread = new Thread(object);
		thread.start();
	}

}
