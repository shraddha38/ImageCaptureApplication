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

public class CommentUpdater {	
	
	private static MongoClient mongoClient;
	private MongoDatabase mongoDatabase;
	private MongoCollection<Document> mongoCollection;
	
	public CommentUpdater()  {
		MongoClientURI uri = new MongoClientURI("mongodb://sraddha_1:sraddha@cluster0-shard-00-00.bv1x1.mongodb.net:27017,cluster0-shard-00-01.bv1x1.mongodb.net:27017,cluster0-shard-00-02.bv1x1.mongodb.net:27017/icaextract?ssl=true&replicaSet=atlas-10gdcd-shard-0&authSource=admin&retryWrites=true&w=majority");
		mongoClient = new MongoClient(uri);
		mongoDatabase = mongoClient.getDatabase("icaextract");
		mongoCollection = mongoDatabase.getCollection("BatchProcess");
	}
	
	public void printAllDocuments() {
		FindIterable<Document> cursor = mongoCollection.find();
		for(Document doc : cursor) {
			System.out.println(doc.toJson());
		}
	}

	public void modifyDocument(String parameter1oldDoc,String parameter1newDoc ) {
		BasicDBObject query = new BasicDBObject();
		query.put("FileName", parameter1oldDoc);

		BasicDBObject newDocument = new BasicDBObject();
		newDocument.put("Comment", parameter1newDoc);
					
		BasicDBObject updateObj = new BasicDBObject();
		updateObj.put("$set", newDocument);

		mongoCollection.updateOne(query, updateObj);// or mongoCollection.updateMany(query, updateObj);
	}
	public static void main (String parameter1oldDoc,String parameter1newDoc) {
		CommentUpdater mongoDBxAtlasExemple= new CommentUpdater();

		mongoDBxAtlasExemple.modifyDocument(parameter1oldDoc,parameter1newDoc);
		mongoDBxAtlasExemple.printAllDocuments();
		//mongoDBxAtlasExemple.printAllDocuments();
		mongoClient.close();
	}// end main
	
}