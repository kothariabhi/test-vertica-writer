package com.abhi.processors;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.log4j.Logger;

import com.abhi.pojo.DelFrmSys;
import com.abhi.util.LoggerUtil;

public class PR1_DEL_FRM_SYS extends AbstractTask {
private Logger logger = Logger.getLogger(this.getClass());
	
	public void run() {
		try {
			long startTime = System.currentTimeMillis();

			logger.info(requestId + " - KafkaString : " + kafkaString);
			DelFrmSys delFrmSys = (DelFrmSys) LoggerUtil.getObjectFromJson(kafkaString, DelFrmSys.class);
			String schema = "s_" + delFrmSys.getClientId(), where;
			String listTabel = schema + ".userDetailsLists", attrTable = schema + ".userDetailsAttrs";
			String userIds = IntStream.of(delFrmSys.getUserId()).mapToObj(Integer::toString).collect(Collectors.joining(","));
			where = "uid IN (" + userIds + ")";
			LoggerUtil.pushForDeleteInVertica(listTabel, where);
			LoggerUtil.pushForUpdateInVertica(attrTable, "d", "1", where);
			
			logger.info(requestId + " - Time taken : " + (System.currentTimeMillis() - startTime));
		} catch (Exception e) {
			logger.error(requestId + " - Error : " + e.getMessage(), e);
		}
	}
	
	public static void main(String[] args) {
		PR1_DEL_FRM_SYS object = new PR1_DEL_FRM_SYS();
		object.kafkaString = "{\"clientId\":19130,\"userId\":[93],\"ts\":181120175941}";
		Thread thread = new Thread(object);
		thread.start();
	}

}
