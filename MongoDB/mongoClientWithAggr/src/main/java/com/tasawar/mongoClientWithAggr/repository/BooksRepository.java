package com.tasawar.mongoClientWithAggr.repository;

import com.mongodb.BasicDBObject;
import com.mongodb.client.*;
import org.bson.Document;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BooksRepository {
    MongoClient mongoClient;

    private MongoClient getMongoClient() {

        if (mongoClient == null) {
            mongoClient = MongoClients.create();
        }
        return mongoClient;
    }

    public List<Object> getAllBooks() {
        MongoClient mongoClient = getMongoClient();
        MongoDatabase mongoDatabase = mongoClient.getDatabase("mongorepository");
        MongoCollection<Document> collection = mongoDatabase.getCollection("books");
        FindIterable<Document> documents = collection.find();
        List<Object> responseBooks = new ArrayList<>();

        for (Document doc : documents) {

            responseBooks.add(doc);
        }


        return responseBooks;
    }

    public String add(Document bookDocument) {
        MongoClient mongoClient = getMongoClient();
        MongoDatabase mongoDatabase = mongoClient.getDatabase("mongorepository");
        MongoCollection<Document> collection = mongoDatabase.getCollection("books");
        try {

            collection.insertOne(bookDocument);
            return "Successfully Inserted...";
        } catch (Exception exception) {
            return "Not Inserted, Try again...";

        }
    }

    public String updateBook(Document bookDocument, String id) {
        MongoClient mongoClient = getMongoClient();
        MongoDatabase mongoDatabase = mongoClient.getDatabase("mongorepository");
        MongoCollection<Document> collection = mongoDatabase.getCollection("books");
        BasicDBObject filter = new BasicDBObject("_id", id);
        BasicDBObject update = new BasicDBObject("$set", bookDocument);
        try {
            collection.updateOne(filter, update);
            return "Successfully Updated...";
        } catch (Exception exception) {
            return "Not Updated, Try again...";

        }
    }

    public String deleteBook(String id) {
        MongoClient mongoClient = getMongoClient();
        MongoDatabase mongoDatabase = mongoClient.getDatabase("mongorepository");
        MongoCollection<Document> collection = mongoDatabase.getCollection("books");
        BasicDBObject filter = new BasicDBObject("_id", id);
        try {
            collection.deleteOne(filter);
            return "Successfully Deleted...";
        } catch (Exception exception) {
            return "Not deleted, Try again...";

        }
    }

    public List<Object> getAllBooksByPage(int pageNo, int pageSize, String sortBy, List<String> fields) {
        MongoClient mongoClient = getMongoClient();
        MongoDatabase mongoDatabase = mongoClient.getDatabase("mongorepository");
        MongoCollection<Document> collection = mongoDatabase.getCollection("books");
        BasicDBObject projection = new BasicDBObject();
//        projection.append("_id",0);
        for(String field: fields){
            projection.append(field,1);
        }
        BasicDBObject sort = new BasicDBObject(sortBy,1);
        FindIterable<Document> documents = collection.find().projection(projection).sort(sort).skip(pageNo * pageSize).limit(pageSize);
        List<Object> responseBooks = new ArrayList<>();

        for (Document doc : documents) {

            responseBooks.add(doc);
        }


        return responseBooks;
    }

    public long countTotalNoOfElements() {
        MongoClient mongoClient = getMongoClient();
        MongoDatabase mongoDatabase = mongoClient.getDatabase("mongorepository");
        MongoCollection<Document> collection = mongoDatabase.getCollection("books");
        return collection.countDocuments();
    }

    public String countPage() {
        MongoClient mongoClient = getMongoClient();
        MongoDatabase mongoDatabase = mongoClient.getDatabase("mongorepository");
        MongoCollection<Document> collection = mongoDatabase.getCollection("books");

        return null;
    }
}
