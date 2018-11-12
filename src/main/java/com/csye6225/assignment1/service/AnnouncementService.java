package com.csye6225.assignment1.service;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDeleteExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.csye6225.assignment1.model.AnnouncementModel;
import com.csye6225.assignment1.model.DynamoDBConnector;

import java.util.HashMap;
import java.util.List;

public class AnnouncementService {
    static DynamoDBConnector dynamoDb;
    DynamoDBMapper mapper;

    public AnnouncementService() {
        dynamoDb = new DynamoDBConnector();
        dynamoDb.init();
        mapper = new DynamoDBMapper(dynamoDb.getClient());
    }

    public AnnouncementModel get(String boardId, String announcementId) {
        HashMap<String, AttributeValue> eav = new HashMap<>();
        eav.put(":v1",  new AttributeValue().withS(boardId));
        eav.put(":v2",  new AttributeValue().withS(announcementId));

        DynamoDBQueryExpression<AnnouncementModel> queryExpression = new DynamoDBQueryExpression<AnnouncementModel>()
                .withIndexName("boardId-announcementId-index")
                .withConsistentRead(false)
                .withKeyConditionExpression("boardId = :v1 and begins_with(announcementId, :v2)")
                .withExpressionAttributeValues(eav);

        List<AnnouncementModel> iList =  mapper.query(AnnouncementModel.class, queryExpression);
        if (iList.size() == 0) return null;
        return iList.get(0);
    }

    public AnnouncementModel add(AnnouncementModel announcement) {
        mapper.save(announcement);
        return announcement;
    }

    public AnnouncementModel delete(String boardId, String announcementId) {
        AnnouncementModel am = get(boardId, announcementId);
        mapper.delete(am, new DynamoDBDeleteExpression());
        return am;
    }

    public List<AnnouncementModel> getAll(){
        return mapper.scan(AnnouncementModel.class, new DynamoDBScanExpression());
    }

    public AnnouncementModel update(AnnouncementModel am) {
        delete(am.getBoardId(), am.getAnnouncementId());
        mapper.save(am);
        return am;
    }
}
