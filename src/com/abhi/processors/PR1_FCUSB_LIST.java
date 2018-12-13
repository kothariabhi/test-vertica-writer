package com.abhi.processors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.abhi.pojo.FcUsbList;
import com.abhi.util.LoggerUtil;

public class PR1_FCUSB_LIST extends AbstractTask {
	
	public void run() {
		try {
			long startTime = System.currentTimeMillis();
			
			System.out.println("KafkaString : " + kafkaString);
			FcUsbList usb = (FcUsbList) LoggerUtil.getObjectFromJson(kafkaString, FcUsbList.class);
			List<String> rows = new ArrayList<String>();
			String trIdArr[] = LoggerUtil.getTrIDDetails(usb.getTrId());
			int clientId = Integer.valueOf(trIdArr[0]);
			int msgId = Integer.valueOf(trIdArr[1]);
			int userId = Integer.valueOf(trIdArr[2]);
			int automationId = Integer.valueOf(trIdArr[3]);
			long ts = Long.valueOf(trIdArr[4]);
			long[] act = LoggerUtil.getDOWDayTimefromTS(ts);
			String schema = "s_" + clientId, header = "uid,mid,aid,ad,adat", table;
			boolean toBeBlacklisted = true;
			if (usb.getType().equals("bounced")) {
				table = schema + ".userDetails_e_bnc";
				if (usb.getBounceType().equalsIgnoreCase("SOFTBOUNCE")) {
					toBeBlacklisted = false;
				}
			} else if (usb.getType().equals("unsubscribed")) {
				table = schema + ".userDetails_e_u";
			} else {
				table = schema + ".userDetails_e_spm";
			}
			rows.add(LoggerUtil.getListAsCsvString(Arrays.asList(userId, msgId, automationId, act[1], act[3])));
			LoggerUtil.pushForFurtherProcessing(table, header, rows);
			
			if (toBeBlacklisted) {
				LoggerUtil.pushForUpdateInVertica(table, "bl", "1");
			}
			
			System.out.println("Time taken : " + (System.currentTimeMillis() - startTime));
		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		PR1_FCUSB_LIST object = new PR1_FCUSB_LIST();
		object.kafkaString = "{\"trId\":\"56921-41-278953-6-181213100030\",\"reason\":\"172.217.197.26 - smtp;550 5.1.1 The email account that you tried to reach does not exist. Please try double-checking the recipient's email address for typos or unnecessary spaces. Learn more at https://support.google.com/mail/?p=NoSuchUs\",\"type\":\"bounced\"}";
		Thread thread = new Thread(object);
		thread.start();
	}

}
