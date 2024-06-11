package com.tasawar.mongoClient;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MongoClientApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MongoClientApplication.class, args);

    }

    public com.mongodb.client.MongoClient getClient() {
		return MongoClients.create();
    }


    @Override
    public void run(String... args) throws Exception {
        MongoClient client = getClient();
        MongoDatabase database =  client.getDatabase("test");
        MongoCollection<Document> employee =  database.getCollection("employeee");
        Document document = new Document();
            document.append("helo","Hi Bro");
            employee.insertOne(document);
    }
}
