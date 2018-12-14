package com.abhi.processors;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;

import com.abhi.pojo.PushQuery;
import com.abhi.util.LoggerUtil;

public class PR1_APN_DASHBOARD extends AbstractTask {
	private Logger logger = Logger.getLogger(this.getClass());
	
	public void run() {
		try {
			long startTime = System.currentTimeMillis();

			logger.info(requestId + " - KafkaString : " + kafkaString);
			PushQuery pq = (PushQuery) LoggerUtil.getObjectFromJson(kafkaString, PushQuery.class);
			String schema = "s_" + pq.getClientId(), header = "uid,mid,aid,b,o,d,ad,adat", row = "";
			String table = schema + ( pq.isIdentified() ? ".userDetails_p_pdl" : ".anonUserDetails_p_pdl" );
			long[] act = LoggerUtil.getDOWDayTimefromTS(pq.getTs());
			int[] bodData = LoggerUtil.getBod(String.valueOf(pq.getBod()));
			List<Object> data = Arrays.asList(pq.getUserId(), pq.getMessageId(), pq.getAutomationId(), bodData[2], bodData[1], 
					bodData[0], act[1], act[3]);
			if (pq.getAction().equals("open")) {
				table = schema + ( pq.isIdentified() ? ".userDetails_p_po" : ".anonUserDetails_p_po" );
				header += ",fid";
				data.add(pq.getClickLinkId());
			}
			row = LoggerUtil.listToCsvString(row, data);
			LoggerUtil.pushForFurtherProcessing(table, header, row);
			
			logger.info(requestId + " - Time taken : " + (System.currentTimeMillis() - startTime));
		} catch (Exception e) {
			logger.error(requestId + " - Error : " + e.getMessage(), e);
		}
	}

	public static void main(String[] args) {
		PR1_APN_DASHBOARD object = new PR1_APN_DASHBOARD();
		object.kafkaString = "{\"appVersion\":\"1.0\",\"tx\":0,\"trId\":\"18740-849-0-0-181127115931-A\",\"pushId\":\"ece4f4e0-f046-4d4d-b89e-e6da4dbc7574\",\"identified\":false,\"appId\":\"1e20ad1cbfdb6998e3abc3625463200e\",\"action\":\"delivered\",\"model\":\"Redmi Note 5\",\"lat\":\"\",\"eventId\":0,\"cts\":181127115930,\"lng\":\"\",\"messageId\":\"849\",\"tsDate\":\"Dec 14, 2018 2:30:37 PM\",\"osId\":1,\"sts\":0,\"bod\":2602,\"sdkVersion\":\"1.1.2\",\"automationId\":0,\"notificationType\":\"apppush\",\"osVersion\":\"8.1.0\",\"identity\":\"\",\"osType\":\"Android\",\"make\":\"Xiaomi\",\"channelId\":0,\"clientId\":18740,\"userId\":35349,\"pts\":0,\"token\":\"c1Sv-GxVWMc:APA91bFznyZef_w85jlh6DgipKleZdBYlT3impwEM6KGVUidti_juc14qGlwg239A_R968phoQn6yH1g3PxsKkU3GJmbCigsKhDdZyNPv8xLtbRuO6VGq3713TeUxrmVV8DMEK_IGkBn\",\"atci\":0,\"ts\":181127115931}";
		Thread thread = new Thread(object);
		thread.start();
	}

}
