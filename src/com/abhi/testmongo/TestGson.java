package com.abhi.testmongo;

import org.bson.Document;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TestGson {
	
	public static void main(String[] args) {
		String jsonString = "{ 'a': 'Name', 'b': 100 }";
		Document document = new Document("a", "name").append("b", 100);
		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
		System.out.println(gson.toJson(document));
		System.out.println(document);
		System.out.println(gson.fromJson(jsonString, Document.class));
	}
	
}
