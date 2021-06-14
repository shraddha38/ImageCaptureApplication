package com.ImageCaptureApplications.Downloader;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
 
public class BatchReport {
	/*	External Archives
	 * 	mongodb-driver-3.6.3.jar
	 * 	mongo-java-driver-3.6.3.jar
	 */
	
	private static MongoClient mongoClient;
	private static MongoDatabase mongoDatabase;
	private static MongoCollection<Document> mongoCollection;

	/*public void printAllDocuments() {
		FindIterable<Document> cursor = mongoCollection.find();
		for(Document doc : cursor) {
			System.out.println(doc.toJson());
		}
	}*/
		
	public static void createNewDocumet(String batchId, int downloadFail,int downloads,int extracted,int extractionFail,String CreatedDate) {
		MongoClientURI uri = new MongoClientURI("mongodb://sraddha_1:sraddha@cluster0-shard-00-00.bv1x1.mongodb.net:27017,cluster0-shard-00-01.bv1x1.mongodb.net:27017,cluster0-shard-00-02.bv1x1.mongodb.net:27017/icaextract?ssl=true&replicaSet=atlas-10gdcd-shard-0&authSource=admin&retryWrites=true&w=majority");
		mongoClient = new MongoClient(uri);
		mongoDatabase = mongoClient.getDatabase("icaextract");
		mongoCollection = mongoDatabase.getCollection("BatchReports");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		 DateTimeFormatter bid = DateTimeFormatter.ofPattern("ddMMyy");
		 
		 LocalDateTime now = LocalDateTime.now();  
		 String createdDate = dtf.format(now);
		
		Document document = new Document();
		document.put("BatchId", batchId);
		document.put("DownloadFailed",downloadFail);
		document.put("Downloads", downloads);
		document.put("ExtractionFailed",extractionFail);
		document.put("Extracted",extracted);
		document.put("CreatedDate",createdDate);
		document.put("TotalCounts",downloadFail+downloads);
		
		mongoCollection.insertOne(document);
	}
}