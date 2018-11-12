package com.csye6225.assignment1.service;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDeleteExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.csye6225.assignment1.model.Database;
import com.csye6225.assignment1.model.DynamoDBConnector;
import com.csye6225.assignment1.model.ProfessorModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProfessorService {

    static DynamoDBConnector dynamoDb;
    DynamoDBMapper mapper;

    public ProfessorService() {
        dynamoDb = new DynamoDBConnector();
        dynamoDb.init();
        mapper = new DynamoDBMapper(dynamoDb.getClient());
    }

    public ProfessorModel delete(String id) {
        ProfessorModel pm = get(id);
        mapper.delete(pm, new DynamoDBDeleteExpression());
        return pm;
    }

    public ProfessorModel get(String id) {
        HashMap<String, AttributeValue> eav = new HashMap<>();
        eav.put(":v1",  new AttributeValue().withS(id));

        DynamoDBQueryExpression<ProfessorModel> queryExpression = new DynamoDBQueryExpression<ProfessorModel>()
                .withIndexName("professorId-index")
                .withKeyConditionExpression("professorId = :v1")
                .withConsistentRead(false)
                .withExpressionAttributeValues(eav);

        List<ProfessorModel> list =  mapper.query(ProfessorModel.class, queryExpression);
        if (list.size() == 0) return null;
        return list.get(0);
    }

    public List<ProfessorModel> getAll(){
        return mapper.scan(ProfessorModel.class, new DynamoDBScanExpression());
    }

    public ProfessorModel add(ProfessorModel pm) {
        mapper.save(pm);
        return pm;
    }

    public ProfessorModel update(ProfessorModel pm) {
        delete(pm.getProfessorId());
        mapper.save(pm);
        return pm;
    }
}
