package com.csye6225.assignment1;

import com.amazonaws.regions.Regions;
import com.csye6225.assignment1.model.*;

import java.util.HashMap;
import java.util.Map;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.KeyType;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.ScalarAttributeType;


public class Database {

    public static Map<String, CourseModel> courses = new HashMap<>();
    public static Map<String, LectureModel> lectures = new HashMap<>();
    public static Map<String, ProfessorModel> professors = new HashMap<>();
    public static Map<String, ProgramModel> programs = new HashMap<>();
    public static Map<String, StudentModel> students = new HashMap<>();


    public static String test() {
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().withRegion(Regions.US_EAST_2).build();

        DynamoDB dynamoDB = new DynamoDB(client);

        Table table = dynamoDB.getTable("professor");

        return table.describe().toString();

    }
}
