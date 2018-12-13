package com.abhi.processors;

public class PR1_SMSPINGBACK extends PR1_DMPINGBCK2 {
	
	public static void main(String[] args) {
		PR1_SMSPINGBACK object = new PR1_SMSPINGBACK();
		object.kafkaString = "{\"clientId\":18230,\"status\":\"smsother\",\"dlrList\":[{\"clientid\":18230,\"msgid\":1160,\"automationid\":0,\"userid\":5,\"sc\":0,\"circleid\":-1,\"ts\":\"181210174706\",\"status\":\"smsother\",\"mobile\":\"\",\"reqid\":\"0\",\"deliverytime\":\"2018-12-10 17:47:06\",\"operator\":\"\",\"circle\":\"\",\"txnid\":\"18230-1160-5-0-181210174706\",\"feedid\":\"358097\",\"senttime\":\"2018-12-10 17:47:06\",\"bbtxnid\":\"\",\"publishDate\":\"181210\",\"sentTs\":\"181210174706\",\"send_to_eaf\":1,\"statuscode\":\"28\",\"operatorid\":-1},{\"clientid\":18230,\"msgid\":1160,\"automationid\":0,\"userid\":9,\"sc\":0,\"circleid\":-1,\"ts\":\"181210174706\",\"status\":\"smsother\",\"mobile\":\"\",\"reqid\":\"0\",\"deliverytime\":\"2018-12-10 17:47:06\",\"operator\":\"\",\"circle\":\"\",\"txnid\":\"18230-1160-9-0-181210174706\",\"feedid\":\"358097\",\"senttime\":\"2018-12-10 17:47:06\",\"bbtxnid\":\"\",\"publishDate\":\"181210\",\"sentTs\":\"181210174706\",\"send_to_eaf\":1,\"statuscode\":\"28\",\"operatorid\":-1},{\"clientid\":18230,\"msgid\":1160,\"automationid\":0,\"userid\":15,\"sc\":0,\"circleid\":-1,\"ts\":\"181210174706\",\"status\":\"smsother\",\"mobile\":\"\",\"reqid\":\"0\",\"deliverytime\":\"2018-12-10 17:47:06\",\"operator\":\"\",\"circle\":\"\",\"txnid\":\"18230-1160-15-0-181210174706\",\"feedid\":\"358097\",\"senttime\":\"2018-12-10 17:47:06\",\"bbtxnid\":\"\",\"publishDate\":\"181210\",\"sentTs\":\"181210174706\",\"send_to_eaf\":1,\"statuscode\":\"28\",\"operatorid\":-1}]}";
		Thread thread = new Thread(object);
		thread.start();
	}

}
