package com.abhi.testmongo;

import java.util.HashMap;
import java.util.Map;

import org.bson.Document;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TestObject {
	
	public static void main(String[] args) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("int", new Integer(1));
		map.put("float", new Double(1.52));
		map.put("string", "name");
		map.put("long", 1000L);
		
		Document document = new Document();
		document.putAll(map);
		System.out.println("Document : " + document.toJson());
		
		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
		document = gson.fromJson("{\"tx\":1506796266260,\"autoid\":0,\"TIME\":\"00:01:06\",\"MISSEDCALL_TIME\":\"2017-10-01 00:01:06\",\"pts\":0,\"CIRCLE\":\"Gujarat\",\"DATE\":\"01-10-2017\",\"sts\":0,\"OPERATOR\":\"Vodafone\",\"YEAR\":\"2017\",\"COUNTRY\":\"India\",\"npv\":0,\"ts\":0,\"MOBILE\":\"8469068185\"}", Document.class);
		System.out.println("Document : " + document.toJson());
	}

}
