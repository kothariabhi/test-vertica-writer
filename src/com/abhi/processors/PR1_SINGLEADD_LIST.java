package com.abhi.processors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.abhi.pojo.SingleAddList;
import com.abhi.util.LoggerUtil;

public class PR1_SINGLEADD_LIST extends AbstractTask {
	final static Logger logger = Logger.getLogger(PR1_EMBC.class);

	public void run() {
		try {
			long startTime = System.currentTimeMillis();

			System.out.println("KafkaString : " + kafkaString);
			SingleAddList singleAddListRequest = (SingleAddList) LoggerUtil.getObjectFromJson(kafkaString,
					SingleAddList.class);
			int existing = singleAddListRequest.getExisting();
			if (existing == 0) {
				singleUserADD(singleAddListRequest, kafkaString, this.requestId, existing);
			} else {
				singleUserUpdate(singleAddListRequest, kafkaString, this.requestId, existing);
			}

			System.out.println("Time taken : " + (System.currentTimeMillis() - startTime));
		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		}
	}

	private void singleUserUpdate(SingleAddList singleAddListRequest, String kafkaString, String requestId,
			int existing) {
		// TODO Auto-generated method stub

		String clientId = "s_" + singleAddListRequest.getClientId() + ".";
		String t1 = clientId + "userDetailsAttrs";
		String t2 = clientId + "tmpUserDetailsAttrs";
		singleUserADD(singleAddListRequest, kafkaString, requestId, existing);
		Map<String, Object> attributes = singleAddListRequest.getAttributes();
		String updateString = "";
		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String header = entry.getKey();
			String setKey = header + "=t2." + header;
			List<Object> updateData = Arrays.asList(setKey);
			updateString = LoggerUtil.listToCommaString(updateString, updateData);
		}
		LoggerUtil.mergetable(t1, t2, "uid", updateString);

	}

	public static void main(String[] args) {
		PR1_SINGLEADD_LIST object = new PR1_SINGLEADD_LIST();
		object.kafkaString = "{\"existing\":0,\"clientId\":14340,\"identified\":1,\"mobileCount\":0,\"attributes\":{\"email\":\"kafkaload493630@m.pragatee.com\",\"disabled\":0.0,\"blacklisted\":0.0,\"foreignkey\":\"kafkaload493630@m.pragatee.com\"},\"list\":[10,0],\"wc\":1,\"userId\":5037642,\"sendToEaf\":1,\"ts\":181213192316,\"emailCount\":1}";
		//object.kafkaString = "{\"existing\":1,\"clientId\":18040,\"mobileCount\":0,\"attributes\":{\"disabled\":0.0,\"email\":\"aman.netcore@gmail.com\",\"foreignkey\":\"aman.netcore@gmail.com\",\"mobile\":\"9891641844\",\"att2\":{\"datatype\":\"text\",\"value\":\"\"},\"att3\":{\"datatype\":\"text\",\"value\":\"\"},\"att4\":{\"datatype\":\"text\",\"value\":\"\"},\"att5\":{\"datatype\":\"text\",\"value\":\"\"},\"att6\":{\"datatype\":\"text\",\"value\":\"AMANDEEP SINGH \"},\"att7\":{\"datatype\":\"text\",\"value\":\"\"},\"att8\":{\"datatype\":\"text\",\"value\":\"MALE\"},\"att9\":{\"datatype\":\"int\",\"value\":\"\"},\"att10\":{\"datatype\":\"int\",\"value\":\"\"},\"att11\":{\"datatype\":\"int\",\"value\":\"25\"},\"att12\":{\"datatype\":\"int\",\"value\":\"\"},\"att13\":{\"datatype\":\"int\",\"value\":\"\"},\"att14\":{\"datatype\":\"date\"},\"att15\":{\"datatype\":\"date\"},\"att19\":{\"datatype\":\"int\",\"value\":\"\"},\"att21\":{\"datatype\":\"text\",\"value\":\"\"},\"att22\":{\"datatype\":\"decimal\",\"value\":\"\"},\"att23\":{\"datatype\":\"text\",\"value\":\"\"},\"att24\":{\"datatype\":\"text\",\"value\":\"\"},\"att25\":{\"datatype\":\"text\",\"value\":\"\"},\"att27\":{\"datatype\":\"text\",\"value\":\"xyz\"},\"att28\":{\"datatype\":\"text\",\"value\":\"\"},\"att29\":{\"datatype\":\"text\",\"value\":\"xyz\"},\"att30\":{\"datatype\":\"decimal\",\"value\":\"\"},\"att31\":{\"datatype\":\"text\",\"value\":\"\"},\"att32\":{\"datatype\":\"text\",\"value\":\"\"},\"att33\":{\"datatype\":\"text\",\"value\":\"\"},\"att34\":{\"datatype\":\"text\",\"value\":\"\"}},\"whitelisted\":0,\"wc\":1,\"userId\":1383189,\"sendToEaf\":1,\"ts\":181213180005,\"emailCount\":0}";
		Thread thread = new Thread(object);
		thread.start();
	}

	public void singleUserADD(SingleAddList bal, String kafkaString, String requestId, int existing) {
		String tableName = "userDetailsAttrs";
		if (existing == 1) {
			tableName = "tmpUserDetailsAttrs";
		}
		Map<String, Object> attributes = bal.getAttributes();
		int userid = bal.getUserId();
		long ts = bal.getTs();
		int[] list = bal.getList();
		String attrString = "", listString = "", attrHeader = "";
		String clientId = "s_" + bal.getClientId() + ".";
		String attrTable = clientId + tableName;
		String listHeader = "uid,lid,ad";
		String listSchema = clientId + "userDetailsLists";
		List<Object> values = new ArrayList<Object>();
		List<Object> attrs = new ArrayList<Object>();
		try {
			if (userid != 0) {
				attrs.add("uid");
				values.add(userid);
			}
			if (ts != 0) {
				attrs.add("ad");
				values.add(ts);
			}
			for (Map.Entry<String, Object> entry : attributes.entrySet()) {
				String header = entry.getKey();
				Object value = entry.getValue();
				switch (header) {
				case "userId":
					attrs.add("uid");
					values.add(value);
					break;
				case "email":
					attrs.add("em");
					values.add(LoggerUtil.getStringOp(value));
					break;
				case "mobile":
					attrs.add("mo");
					values.add(LoggerUtil.getStringOp(value));
					break;
				case "disabled":
					attrs.add("d");
					values.add(value);
					break;
				case "blacklisted":
					attrs.add("bl");
					values.add(LoggerUtil.getStringOp(value));
					break;
				case "foreignkey":
					attrs.add("fk");
					values.add(LoggerUtil.getStringOp(value));
					break;
				default:
					if (header.startsWith("att")) {
						Map dMap = (Map) value;
						Object obj = dMap.get("value");
						if (obj == null)
							continue;
						String dataType = (String) dMap.get("datatype");
						switch (dataType) {
						case "text":
							attrs.add(header);
							values.add(LoggerUtil.getStringOp(dMap.get("value")));
							break;
						case "int":
						case "boolean":
							String valStr = (String) dMap.get("value");
							valStr = valStr.replace("\n", "").replace("\r", "");
							if (valStr.equals("")) {
								valStr = "0";
							}
							attrs.add(header);
							values.add(Integer.parseInt(valStr));
							break;
						case "decimal":
							String valStrd = (String) dMap.get("value");
							valStrd = valStrd.replace("\n", "").replace("\r", "");
							if (valStrd.equals("")) {
								valStrd = "0";
							}
							attrs.add(header);
							values.add(Double.valueOf(valStrd));
							break;
						case "date":
							attrs.add(header);
							values.add(LoggerUtil.getStringOp(dMap.get("value")));
							break;
						default:
							logger.info("Unmapped data type for attribute " + dataType);
							break;
						}
					}
				}

			}
			try {
				if (list != null && list.length > 0) {
					for (int listId : list) {
						List<Object> openData = Arrays.asList(userid, listId, ts);
						listString = LoggerUtil.listToCsvString(listString, openData);
					}
				}

				if (!listString.isEmpty()) {
					LoggerUtil.pushForFurtherProcessing(listSchema, listHeader, listString);
				}
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
			try {
				attrHeader = LoggerUtil.listToCsvString(attrHeader, attrs);
				attrString = LoggerUtil.listToCsvString(attrString, values);
				if (!attrString.isEmpty()) {
					LoggerUtil.pushForFurtherProcessing(attrTable, attrHeader, attrString);
				}
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}

		} catch (Exception e) {
			logger.error(requestId + " FAILED RPUSH PR1_BULKADD_LIST '" + kafkaString + "' " + e.getMessage(), e);
		}
	}

}
