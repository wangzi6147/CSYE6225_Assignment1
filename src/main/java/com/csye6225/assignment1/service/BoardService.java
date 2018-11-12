package com.csye6225.assignment1.service;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDeleteExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.csye6225.assignment1.model.BoardModel;
import com.csye6225.assignment1.model.DynamoDBConnector;

import java.util.HashMap;
import java.util.List;

public class BoardService {
    static DynamoDBConnector dynamoDb;
    DynamoDBMapper mapper;

    public BoardService() {
        dynamoDb = new DynamoDBConnector();
        dynamoDb.init();
        mapper = new DynamoDBMapper(dynamoDb.getClient());
    }

    public BoardModel delete(String id) {
        BoardModel bm = get(id);
        mapper.delete(bm, new DynamoDBDeleteExpression());
        return bm;
    }

    public BoardModel get(String id) {
        HashMap<String, AttributeValue> eav = new HashMap<>();
        eav.put(":v1",  new AttributeValue().withS(id));

        DynamoDBQueryExpression<BoardModel> queryExpression = new DynamoDBQueryExpression<BoardModel>()
                .withIndexName("boardId-index")
                .withKeyConditionExpression("boardId = :v1")
                .withConsistentRead(false)
                .withExpressionAttributeValues(eav);

        List<BoardModel> list =  mapper.query(BoardModel.class, queryExpression);
        if (list.size() == 0) return null;
        return list.get(0);
    }

    public List<BoardModel> getAll(){
        return mapper.scan(BoardModel.class, new DynamoDBScanExpression());
    }

    public BoardModel add(BoardModel bm) {
        mapper.save(bm);
        return bm;
    }

    public BoardModel update(BoardModel bm) {
        delete(bm.getBoardId());
        mapper.save(bm);
        return bm;
    }
}
