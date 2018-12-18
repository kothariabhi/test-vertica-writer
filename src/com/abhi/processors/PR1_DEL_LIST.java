package com.abhi.processors;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.log4j.Logger;

import com.abhi.pojo.DelList;
import com.abhi.util.LoggerUtil;

public class PR1_DEL_LIST extends AbstractTask {
	private Logger logger = Logger.getLogger(this.getClass());
	
	public void run() {
		try {
			long startTime = System.currentTimeMillis();

			logger.info(requestId + " - KafkaString : " + jsonPayload);
			DelList delList = (DelList) LoggerUtil.getObjectFromJson(jsonPayload, DelList.class);
			String table = "s_" + delList.getClientId() + ".userDetailsLists";
			String listIds = IntStream.of(delList.getList()).mapToObj(Integer::toString).collect(Collectors.joining(","));
			String where = "lid in (" + listIds + ")";
			
			LoggerUtil.pushForDeleteInVertica(table, where);
			logger.info(requestId + " - Time taken : " + (System.currentTimeMillis() - startTime));
		} catch (Exception e) {
			logger.error(requestId + " - Error : " + e.getMessage(), e);
		}
	}
	
	public static void main(String[] args) {
		PR1_DEL_LIST object = new PR1_DEL_LIST();
		object.jsonPayload = "{\"clientId\":14340,\"list\":[187]}";
		Thread thread = new Thread(object);
		thread.start();
	}

}
