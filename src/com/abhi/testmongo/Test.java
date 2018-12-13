package com.abhi.testmongo;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoWriteException;
import com.mongodb.WriteError;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Test {
	
	public static void main(String[] args) {
		MongoClient client = new MongoClient();
		MongoDatabase db = client.getDatabase("test");
		MongoCollection<Document> collection = db.getCollection("testduplicate");
		try {
			collection.insertOne(new Document("_id", 1));
		} catch (MongoWriteException e) {
			System.out.println("Error occured : " + e.getCode() + ", " + e.getError().getCategory());
			WriteError error = e.getError();
			error.getCategory();
		}
		client.close();
	}
	
	public int abc(int abc) {
		return 0;
	}

}
