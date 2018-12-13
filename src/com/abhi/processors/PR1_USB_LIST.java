package com.abhi.processors;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.log4j.Logger;

import com.abhi.pojo.UsbList;
import com.abhi.util.LoggerUtil;

public class PR1_USB_LIST extends AbstractTask {
	private Logger logger = Logger.getLogger(this.getClass());
	
	public void run() {
		try {
			long startTime = System.currentTimeMillis();	System.out.println("Time taken : " + (System.currentTimeMillis() - startTime));
			String dataString = "";
			logger.info(requestId + " - KafkaString : " + kafkaString);
			UsbList usb = (UsbList) LoggerUtil.getObjectFromJson(kafkaString, UsbList.class);
			long[] act = LoggerUtil.getDOWDayTimefromTS(usb.getTs());
			String schema = "s_" + usb.getClientId(), header = "uid,mid,aid,ad,adat", table;
			boolean toBeBlacklisted = true;
			if (usb.getType().equals("bounced")) {
				table = schema + ".userDetails_e_bnc";
				if (usb.getBounceType() != null && usb.getBounceType().equalsIgnoreCase("SOFTBOUNCE")) {
					toBeBlacklisted = false;
				}
			} else if (usb.getType().equals("unsubscribed")) {
				table = schema + ".userDetails_e_u";
			} else {
				table = schema + ".userDetails_e_spm";
			}
			String commonString = LoggerUtil.getListAsCsvString(Arrays.asList(usb.getMsgId(), 0, act[1], act[3]));
			for (int userId : usb.getUserId()) {
				List<Object> rows = Arrays.asList(userId + "," + commonString);
				dataString = LoggerUtil.listToCsvString(dataString, rows);
			}
			String uids = IntStream.of(usb.getUserId()).mapToObj(Integer::toString).collect(Collectors.joining(","));
			if (toBeBlacklisted) {
				LoggerUtil.pushForUpdateInVertica(table, "bl", "1", "uid IN (" + uids + ")");
			}
			
			LoggerUtil.pushForFurtherProcessing(table, header, dataString);
			logger.info(requestId + " - Time taken : " + (System.currentTimeMillis() - startTime));
		} catch (Exception e) {
			logger.error(requestId + " - Error : " + e.getMessage(), e);
		}
	}
	
	public static void main(String[] args) {
		PR1_USB_LIST object = new PR1_USB_LIST();
		object.kafkaString = "{\"reason\":\"204\",\"clientId\":18740,\"bounceType\":\"HARDBOUNCE\",\"msgId\":929,\"type\":\"bounced\",\"userId\":[1265103],\"ts\":181128234505}";
		Thread thread = new Thread(object);
		thread.start();
	}

}
