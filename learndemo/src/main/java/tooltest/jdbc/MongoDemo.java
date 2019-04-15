package tooltest.jdbc;


import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author DongYunxiang
 * @create 2019-01-16
 **/
public class MongoDemo {

    public static void main(String[] args) {
        MongoClientURI uri = new MongoClientURI("mongodb://cent:cent@192.168.200.128/?authSource=cent");
        MongoClient mongoClientUri = new MongoClient(uri);
        MongoDatabase database = mongoClientUri.getDatabase("cent");
//        database.createCollection("javacoll");
        MongoCollection<Document> temp = database.getCollection("temp");

        //插入文档
//        Document document = new Document("name", "javainsert");
//        document.append("age",18);
//        temp.insertOne(document);

        //更新文档
        UpdateResult updateResult = temp.updateMany(Filters.eq("name", "javainsert"), new Document("$set", new Document("name", "javaupdate")));
        System.out.println(updateResult);


        FindIterable<Document> documents = temp.find();
        for (Document document : documents) {
            System.out.println(document);
        }


    }



}
