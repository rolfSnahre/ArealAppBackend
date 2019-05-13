package aws.arealapp.dynamo;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

import aws.arealapp.dynamo.model.*;

import java.util.HashMap;
import java.util.Map;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.*;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;


public class AddMarker implements RequestHandler<Marker, Object> {
    
	@Override
	public Object handleRequest(Marker input, Context context) {
		
        Table table = DUtil.getTable();
        
        double lat = input.getLatitude();
        double lon = input.getLongditude();
        
        String pinColour = input.getPinColour();
        Map info = input.getInfo();
        
        System.out.println("lat: " + lat);
        
        try {
        	PutItemOutcome outcome = table
        			.putItem(new Item().withPrimaryKey("latitude", lat, "longditude", lon)
        			.withString("pinColour", pinColour)
        			.withMap("info", info));
        	
        	return input;
        	
        }catch(Exception e) {
        	return e.getMessage();
        }
        
        
		//return null;
	}
}
