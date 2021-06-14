package com.ImageCaptureApplications.Downloader;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import java.time.LocalDateTime;   

public class InsertingDocument {
	/*	External Archives
	 * 	mongodb-driver-3.6.3.jar
	 * 	mongo-java-driver-3.6.3.jar
	 */
	
	private MongoClient mongoClient;
	private MongoDatabase mongoDatabase;
	private MongoCollection<Document> mongoCollection;
	
	public InsertingDocument() {
		MongoClientURI uri = new MongoClientURI("mongodb://sraddha_1:sraddha@cluster0-shard-00-00.bv1x1.mongodb.net:27017,cluster0-shard-00-01.bv1x1.mongodb.net:27017,cluster0-shard-00-02.bv1x1.mongodb.net:27017/icaextract?ssl=true&replicaSet=atlas-10gdcd-shard-0&authSource=admin&retryWrites=true&w=majority");
		mongoClient = new MongoClient(uri);
		mongoDatabase = mongoClient.getDatabase("icaextract");
		mongoCollection = mongoDatabase.getCollection("icatest");
	}
	
	public void printAllDocuments() {
		FindIterable<Document> cursor = mongoCollection.find();
		for(Document doc : cursor) {
			System.out.println(doc.toJson());
		}
	}	
	public void createNewDocumet(String FileName, String CreatedDate,String BatchId,String Status,String Comment) {
		Document document = new Document();
		String uuid = UUID.randomUUID().toString().replace("-", "");
		document.put("UID", uuid);
		document.put("FileName", FileName);
		document.put("CreatedDate", CreatedDate);
		document.put("BatchId", BatchId);
		document.put("Status", Status);
		document.put("Comment", Comment);
		
		mongoCollection.insertOne(document);
	}
		
	public static void main (String FileName, String CreatedDate,String BatchId,String Status,String Comment) {
		InsertingDocument mongoDBxAtlasExemple= new InsertingDocument();
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		 DateTimeFormatter bid = DateTimeFormatter.ofPattern("ddMMyy");
		LocalDateTime now = LocalDateTime.now();  
		 String createdDate = dtf.format(now);  
		 String bidn = bid.format(now);
		mongoDBxAtlasExemple.createNewDocumet(FileName,createdDate,bidn,Status,Comment);
		mongoDBxAtlasExemple.printAllDocuments();
		
	}// end main
	
}