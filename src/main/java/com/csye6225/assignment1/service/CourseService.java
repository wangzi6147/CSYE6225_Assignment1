package com.csye6225.assignment1.service;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDeleteExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.csye6225.assignment1.model.Database;
import com.csye6225.assignment1.model.CourseModel;
import com.csye6225.assignment1.model.DynamoDBConnector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CourseService {

    static DynamoDBConnector dynamoDb;
    DynamoDBMapper mapper;

    public CourseService() {
        dynamoDb = new DynamoDBConnector();
        dynamoDb.init();
        mapper = new DynamoDBMapper(dynamoDb.getClient());
    }

    public CourseModel delete(String id) {
        CourseModel cm = get(id);
        mapper.delete(cm, new DynamoDBDeleteExpression());
        return cm;
    }

    public CourseModel get(String id) {
        HashMap<String, AttributeValue> eav = new HashMap<>();
        eav.put(":v1",  new AttributeValue().withS(id));

        DynamoDBQueryExpression<CourseModel> queryExpression = new DynamoDBQueryExpression<CourseModel>()
                .withIndexName("courseId-index")
                .withKeyConditionExpression("courseId = :v1")
                .withConsistentRead(false)
                .withExpressionAttributeValues(eav);

        List<CourseModel> list =  mapper.query(CourseModel.class, queryExpression);
        if (list.size() == 0) return null;
        return list.get(0);
    }

    public List<CourseModel> getAll(){
        return mapper.scan(CourseModel.class, new DynamoDBScanExpression());
    }

    public CourseModel add(CourseModel cm) {
        mapper.save(cm);
        return cm;
    }

    public CourseModel update(CourseModel cm) {
        delete(cm.getCourseId());
        mapper.save(cm);
        return cm;
    }
}
