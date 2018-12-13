package com.abhi.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.google.gson.Gson;

public class LoggerUtil {
	private static Logger logger = Logger.getLogger(LoggerUtil.class);

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
