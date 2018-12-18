package com.abhi.processors;

import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;

import com.abhi.pojo.BulkAddList;
import com.abhi.util.CSVHelper;
import com.abhi.util.LoggerUtil;

public class PR1_BULKADD_LIST extends AbstractTask {
	final static Logger logger = Logger.getLogger(PR1_EMBC.class);

	public void run() {
		try {
			long startTime = System.currentTimeMillis();

			logger.info("KafkaString : " + jsonPayload);
			BulkAddList bulkAddListRequest = (BulkAddList) LoggerUtil.getObjectFromJson(jsonPayload, BulkAddList.class);
			bulkUserADD(bulkAddListRequest, jsonPayload, this.requestId);
			logger.info("Time taken : " + (System.currentTimeMillis() - startTime));
		} catch (Exception e) {
			logger.error("Error : " + e.getMessage(), e);
		}
	}

	public static void main(String[] args) {
		PR1_BULKADD_LIST object = new PR1_BULKADD_LIST();
		object.jsonPayload = "{\"responseKey\":\"PR1_IMPORT_RESPONSE_39986_628155\",\"clientId\":14340,\"progressKey\":\"PR1_IMPORT_PROGRESS_39986_628155\",\"staticList\":0,\"dataType\":[\"int\",\"text\",\"text\",\"text\",\"text\",\"text\",\"text\",\"text\"],\"statusFlags\":\"PR1_IMPORT_HANDSHAKE_39986_628155\",\"mobileCount\":2,\"list\":[2595,0],\"wc\":46,\"proIncrCount\":30,\"url\":\"http://pnstage.netcore.co.in:8080/yi/1544525928823_new.csv\",\"cwc\":2,\"jobId\":\"628155\",\"attr\":[\"userid\",\"domid\",\"MOBILE\",\"EMAIL\",\"att7\",\"att3\",\"att4\",\"att8\"],\"foreignKey\":\"MOBILE\",\"sendToEaf\":1,\"ts\":181030132945,\"emailCount\":2}";
		Thread thread = new Thread(object);
		thread.start();
	}

	public void bulkUserADD(BulkAddList bal, String redisString, String requestId) {
		int[] list = bal.getList();
		long ts = bal.getTs();
		String[] attributes = bal.getAttr();
		String attrString = "", listString = "", attrHeader = "";
		String clientId = "s_" + bal.getClientId() + ".";
		String attrTable = clientId + "userDetailsAttrs";
		String listHeader = "uid,lid,ad";
		String listSchema = clientId + "userDetailsLists";
		Reader fr;
		boolean listType = true;
		try {
			if (bal.getUrl().endsWith("existing.csv")) {
				listType = false;
			}
			fr = LoggerUtil.getFileReader(bal.getUrl());
			int indexOfUserid = java.util.Arrays.asList(attributes).indexOf("userid");
			List<Object> values = CSVHelper.parseLine(fr);
			List<Object> attrs = new ArrayList<Object>();
			for (int idx = 0; idx < attributes.length; idx++) {
				String header = attributes[idx];
				switch (header) {
				case "userid":
					attrs.add("uid");
					break;
				case "EMAIL":
					attrs.add("em");
					break;
				case "MOBILE":
					attrs.add("mo");
					break;
				case "disabled":
					attrs.add("d");
					break;
				case "blacklisted":
					attrs.add("bl");
					break;
				case "foreignkey":
					attrs.add("fk");
					break;
				default:
					if (header.startsWith("att")) {
						attrs.add(header);
					}
				}

			}
			attrs.add("ad");
			attrHeader = LoggerUtil.listToCsvString(attrHeader, attrs);
			while (values != null) {
				values.add(bal.getTs());
				try {
					if (list.length > 0) {

						for (int listId : list) {
							List<Object> openData = Arrays.asList(values.get(indexOfUserid), listId, ts);
							listString = LoggerUtil.listToCsvString(listString, openData);
						}
					}
					attrString = LoggerUtil.listToCsvString(attrString, values);
				} catch (Exception e) {
					logger.error(e.getMessage(), e);
				}

				values = CSVHelper.parseLine(fr);
			}
			if (!listString.isEmpty()) {
				LoggerUtil.pushForFurtherProcessing(listSchema, listHeader, listString);
			}
			if (!attrString.isEmpty()) {
				LoggerUtil.pushForFurtherProcessing(attrTable, attrHeader, attrString);
			}

		} catch (Exception e) {
			logger.error(requestId + " FAILED RPUSH PR1_BULKADD_LIST '" + redisString + "' " + e.getMessage(), e);
		}
	}

}
