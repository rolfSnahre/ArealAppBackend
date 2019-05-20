package aws.arealapp.dynamo.marker;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

import aws.arealapp.dynamo.model.*;
import aws.arealapp.dynamo.util.DUtil;
import aws.arealapp.dynamo.util.DatabaseOperations;

import java.util.HashMap;
import java.util.Map;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.*;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;


public class AddMarker implements RequestHandler<Map<String, Object>, Object> {
    
	@Override
	public Object handleRequest(Map<String, Object> input, Context context) {
		
		DatabaseOperations databaseOp = new DatabaseOperations();
		
		return databaseOp.addObjRandId(input, "Markers", new MarkersParams());
		
//        Table table = DUtil.getTable("Markers");
//
//        String id = input.getKey();
//        Map<String,Double> coords = input.getcoordinate();
//        String pinColor = input.getPinColor();
//        Map<String, Object> markerData = input.getMarkerData();
//        
//        try {
//        	PutItemOutcome outcome = table
//        			.putItem(new Item().withPrimaryKey("key", id)
//        			.withMap("coordinate", (Map<String, Double>) coords)
//        			.withString("pinColor", pinColor)
//        			.withMap("markerData", markerData));
//        	
//        	return input;
//        	
//        }catch(Exception e) {
//        	return e.getMessage();
//        }
        
        
	}
}
