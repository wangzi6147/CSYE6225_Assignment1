package com.csye6225.assignment1.service;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.csye6225.assignment1.model.DynamoDBConnector;
import com.csye6225.assignment1.model.RegistrarModel;

public class RegistrarService {

    static DynamoDBConnector dynamoDb;
    DynamoDBMapper mapper;

    public RegistrarService() {
        dynamoDb = new DynamoDBConnector();
        dynamoDb.init();
        mapper = new DynamoDBMapper(dynamoDb.getClient());
    }

    public RegistrarModel add(RegistrarModel rm) {
        mapper.save(rm);
        return rm;
    }

}
