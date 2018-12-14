package com.abhi.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.google.gson.Gson;

public class LoggerUtil {
	private static Logger logger = Logger.getLogger(LoggerUtil.class);
	
	public static final String EVENT_TYPE_APP="app";
	public static final String EVENT_TYPE_WEB="web";
	public static final String NOTIFICATION_TYPE_ONSITE = "onsite";
	public static final String NOTIFICATION_TYPE_WEBPUSH = "webpush";
	
	public static final int ANDROID_OSID = 1;
	public static final int IOS_OSID = 2;
	public static final int CHROME_BROWSERID = 1;
	public static final int FIREFOX_BROWSERID = 2;
	public static final int SAFARI_BROWSERID = 3;
	
	public static final int PAGE_EXIT = 0;
	public static final int PAGE_BROWSE = 1;
	public static final int ADD_TO_CART = 2;
	public static final int CHECKOUT = 3;
	public static final int CART_EXPIRY = 4;
	public static final int REMOVE_FROM_CART = 5;
	public static final int ADD_TO_WISHLIST = 35;
	public static final int REMOVE_FROM_WISHLIST = 36;
	public static final int PRODUCT_SEARCH = 27;
	public static final int PRODUCT_VIEW = 28;
	public static final int LEAD_SUBMITTED = 29;
	public static final int PRODUCT_PURCHASE = 30;
	
	public static final int PUSH_SUBSCRIBE = 10;
	public static final int PUSH_UNSUBSCRIBE = 11;
	public static final int PUSH_DELIVERED = 12;
	public static final int PUSH_OPENED = 13;
	public static final int PUSH_DISMISSED = 14;
	public static final int PUSH_FAILED = 15;
	public static final int PUSH_SENT = 16;
	public static final int APP_UNINSTALLED = 24;
	
	public static final int ONSITE_SHOWN = 31;
	public static final int ONSITE_CLICK = 32;
	public static final int ONSITE_CLOSE = 33;
	public static final int ONSITE_FORMSUBMIT = 34;
	
	public static final int INAPP_SHOWN = 41;
	public static final int INAPP_CLICK = 42;
	public static final int INAPP_CLOSE = 43;
	
	public static final int CHANNEL_EMAIL = 1;
	public static final int CHANNEL_SMS = 2;
	public static final int CHANNEL_VOICE = 3;
	public static final int CHANNEL_APPPUSH = 4;
	public static final int CHANNEL_WEBPUSH = 5;
	public static final int CHANNEL_WEBMSG = 6;
	
	// EventType, Status, UserType
	@SuppressWarnings("serial")
	public static final Map<String, Map<String, Map<Integer, String>>> PN_BC_TR_TABLE_MAP = new HashMap<String, Map<String, Map<Integer, String>>>() {{
		put("web", new HashMap<String, Map<Integer, String>>() {{
			put("sent", new HashMap<Integer, String>(){{
				put(0, "anonUserDetails_w_wpssent");
				put(1, "userDetails_w_wpssent");
			}});
			put("failed", new HashMap<Integer, String>(){{
				put(0, "anonUserDetails_w_wpsfailed");
				put(1, "userDetails_w_wpsfailed");
			}});
			put("drop", new HashMap<Integer, String>(){{
				put(0, "anonUserDetails_w_wpsfd");
				put(1, "userDetails_w_wpsfd");
			}});
		}});
		put("app", new HashMap<String, Map<Integer, String>>() {{
			put("sent", new HashMap<Integer, String>(){{
				put(0, "anonUserDetails_p_pssent");
				put(1, "userDetails_p_pssent");
			}});
			put("failed", new HashMap<Integer, String>(){{
				put(0, "anonUserDetails_p_psfailed");
				put(1, "userDetails_p_psfailed");
			}});
			put("drop", new HashMap<Integer, String>(){{
				put(0, "anonUserDetails_p_psfd");
				put(1, "userDetails_p_psfd");
			}});
		}});
	}};
	
	@SuppressWarnings("serial")
	public static final Map<String, Map<Integer, String>> PR1_WEBPUSHACT_TABLE_MAP = new HashMap<String, Map<Integer, String>>() {{
		put("open", new HashMap<Integer, String>() {{
			put(0, "anonUserDetails_w_wpcopen");
			put(1, "userDetails_w_wpcopen");
		}});
		put("dismissed", new HashMap<Integer, String>() {{
			put(0, "anonUserDetails_w_wpcdismis");
			put(1, "userDetails_w_wpcdismis");
		}});
		put("delivered", new HashMap<Integer, String>() {{
			put(0, "anonUserDetails_w_wpdl");
			put(1, "userDetails_w_wpdl");
		}});
	}};
	
	public static final ObjectMapper OBJECTMAPPER = new ObjectMapper().registerModule(new SimpleModule()
			.addDeserializer(Object.class, new CustomDateDeseralizer()).addSerializer(new CustomDateSerializer()));

	@SuppressWarnings("unchecked")
	public static Object getObjectFromJson(String json, Class clas) {
		Gson gson = new Gson();
		return gson.fromJson(json, clas);
	}

	public static long[] getDOWDayTimefromTS(long ts) throws ParseException {
		String tsStr = String.valueOf(ts);
		if ((tsStr).trim().length() == 14) {
			tsStr = tsStr.substring(2);
		}
		long ret[] = new long[4];
		String dateStr = String.valueOf(ts);
		DateFormat formatter = new SimpleDateFormat("yyMMddHHmmss");
		Date date = formatter.parse(dateStr);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		ret[0] = calendar.get(Calendar.DAY_OF_WEEK);
		ret[1] = Integer.valueOf(dateStr.substring(0, 6));
		ret[2] = Integer.valueOf(dateStr.substring(6));
		ret[3] = Long.valueOf(dateStr);
		return ret;
	}

	public static int[] getBod(String bod) {
		// TODO Auto-generated method stub
		int bodData[] = new int[3];
		if (bod.length() >= 4) {
			bodData[0] = Integer.parseInt(bod.substring(0, 1));
			bodData[1] = Integer.parseInt(bod.substring(1, 2));
			bodData[2] = Integer.parseInt(bod.substring(2));
		}
		return bodData;

	}

	public static String getListAsCsvString(List<Object> list) {
		StringBuilder sb = new StringBuilder();
		for (Object str : list) {
			if (sb.length() != 0) {
				sb.append(",");
			}
			sb.append(str);
		}
		return sb.toString();
	}

	public static void pushForFurtherProcessing(String table, String header, String rows) {
		logger.info("*********** Start Of Query And Data ***********");
		String query = "copy " + table + "(" + header + ") from stdin delimiter ','";
		logger.info(query);
		logger.info("(" + rows + ")");
		logger.info("*********** End Of Query And Data ***********");
	}
	
	public static void pushForUpdateInVertica(String table, String key, String value, String where) {
		logger.info("*********** Start Of Query And Data ***********");
		logger.info("Operation Update => { 'table': '" + table + "', 'key': '" + key + "', 'value': '" + value + "', 'where': '" + where + "' }");
		logger.info("*********** End Of Query And Data ***********");
	}
	
	public static void pushForDeleteInVertica(String table, String where) {
		logger.info("*********** Start Of Query And Data ***********");
		logger.info("Operation Delete => { 'table': '" + table + "', 'where': '" + where + "' }");
		logger.info("*********** End Of Query And Data ***********");
	}
	
	public static String[] getTrIDDetails(String trid){
		// trid: $clientid-$msgid-$userid-$automationid-$ts
		if (trid == null || trid.equals("None"))
			return null;
		StringTokenizer st = new StringTokenizer(trid, "-");
		if (st.countTokens() < 5)
			throw new IllegalArgumentException(
					"Incorrect trid Format, exptected: trid: $clientid-$msgid-$userid-$automationid-$ts");
		String ret[] = new String[6];
		int i = 0;
		while (st.hasMoreTokens()) {
			ret[i] = st.nextToken();
			i++;
		}
		return ret;
	}

	public static String listToCsvString(String dataString, List<Object> data) {
		String delimiter = "";
		if (!dataString.isEmpty()) {
			delimiter = "/n";
		}
		dataString = dataString + delimiter + getListAsCsvString(data);
		return dataString;
	}
}
