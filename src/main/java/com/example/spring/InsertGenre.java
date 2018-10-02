package com.example.spring;

import java.io.File;
import java.net.UnknownHostException;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class InsertGenre {

	public static void main(String[] args) {
		insert();
	}

	private static void insert() {
		try {
			MongoClientURI connectionString = new MongoClientURI("mongodb://localhost:27017");
			MongoClient mongoClient = new MongoClient(connectionString);
			MongoDatabase database = mongoClient.getDatabase("genreDB");
			MongoCollection<Document> collection = database.getCollection("genre");

			File root = new File("/home/garyhsu/Downloads/genres");
			for (File rootInner : root.listFiles()) {
				if (rootInner.isDirectory()) {
					for (File file : rootInner.listFiles()) {
						if (file.getName().contains("mp3")) {
							Document doc = new Document("type", rootInner.getName())
									.append("filepath",file.getAbsolutePath());
							collection.insertOne(doc);
						}
					}
				}
			}
		} catch (MongoException e) {
			e.printStackTrace();
		}
	}

}
