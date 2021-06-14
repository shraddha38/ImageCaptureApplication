package com.ImageCaptureApplications.Service;



import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;   

public class bro 
{
	/*	External Archives
	 * 	mongodb-driver-3.6.3.jar
	 * 	mongo-java-driver-3.6.3.jar
	 */
	private static MongoClient mongoClient;
	private static MongoDatabase mongoDatabase;
	private static MongoCollection<Document> mongoCollection;
	/*
	public bro() {
		MongoClientURI uri = new MongoClientURI("mongodb+srv://GDuser:GDuser@cluster0.fifzk.gcp.mongodb.net/");
		mongoClient = new MongoClient(uri);
		mongoDatabase = mongoClient.getDatabase("icaextract");
		mongoCollection = mongoDatabase.getCollection("mongoOne");
	}*/
	
	public static void printAllDocuments() {
		/*MongoClientURI uri = new MongoClientURI("mongodb+srv://GDuser:GDuser@cluster0.fifzk.gcp.mongodb.net/");
		mongoClient = new MongoClient(uri);
		mongoDatabase = mongoClient.getDatabase("icaextract");
		mongoCollection = mongoDatabase.getCollection("mongoOne");
		*/
		FindIterable<Document> cursor = mongoCollection.find();
		for(Document doc : cursor) {
			System.out.println(doc.toJson());
			
		}
	}
		
	public static void createNewDocumet(String FileName, String CreatedDate,String BatchId,String Status,String Comment) 
	{
		MongoClientURI uri = new MongoClientURI("mongodb+srv://GDuser:GDuser@cluster0.fifzk.gcp.mongodb.net/");
		mongoClient = new MongoClient(uri);
		mongoDatabase = mongoClient.getDatabase("icaextract");
		mongoCollection = mongoDatabase.getCollection("mongoOne");
	
		Document document = new Document();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		 DateTimeFormatter bid = DateTimeFormatter.ofPattern("ddMMyy");
		LocalDateTime now = LocalDateTime.now();  
		 String createdDate = dtf.format(now);  
		 String bidn = bid.format(now);
		document.put("FileName", FileName);
		document.put("CreatedDate", CreatedDate);
		document.put("BatchId", bidn);
		document.put("Status", Status);
		document.put("Comment", Comment);

		mongoCollection.insertOne(document);
		
		
	}
	
		
	
}