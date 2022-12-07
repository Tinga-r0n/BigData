/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.usermanagementcrud;

import com.mongodb.ErrorCategory;
import com.mongodb.MongoException;
import com.mongodb.MongoWriteException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.Iterator;
import org.bson.BsonDocument;
import org.bson.BsonInt64;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author Student.admin
 */
public class MongoClientConnection {
     public static void main(String[] args) {
        // Replace the uri string with your MongoDB deployment's connection string
        String uri = "mongodb://jane:janejane14@ac-qjm7xdg-shard-00-00.yshvdop.mongodb.net:27017,ac-qjm7xdg-shard-00-01.yshvdop.mongodb.net:27017,ac-qjm7xdg-shard-00-02.yshvdop.mongodb.net:27017/test?replicaSet=atlas-brfw5o-shard-0&ssl=true&authSource=admin";
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("UserManagement");
            MongoCollection<Document> collection = database.getCollection("UserCollection");
            
            //retrieving the documents
//            FindIterable<Document> iterDoc = collection.find();
//            Iterator it = iterDoc.iterator();
//            while (it.hasNext()) {
//               System.out.println(it.next());
//            }

      
      //Insert a document into the "characters" collection.
  

            Document mickeyMouse = new Document();
           

            mickeyMouse.append("_id", 2)
                    .append("firstName", "Mickey")
                    .append("lastName", "Mouse").append("email", "mickey@mail.com").append("password", "0000").append("role", "cashier").append("status","active");

           

            try {
                collection.insertOne(mickeyMouse);
              
                System.out.println("Successfully inserted documents. \n");
            } catch (MongoWriteException mwe) {
                if (mwe.getError().getCategory().equals(ErrorCategory.DUPLICATE_KEY)) {
                    System.out.println("Document with that id already exists");
                }
            }
    

            try {
                Bson command = new BsonDocument("ping", new BsonInt64(1));
                Document commandResult = database.runCommand(command);
                System.out.println("Connected successfully to server.");
            } catch (MongoException me) {
                System.err.println("An error occurred while attempting to run a command: " + me);
            }
        }
    }
    
}
