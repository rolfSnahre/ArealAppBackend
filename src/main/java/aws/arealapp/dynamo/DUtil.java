package aws.arealapp.dynamo;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.google.gson.Gson;

import aws.arealapp.dynamo.model.Marker;
import aws.arealapp.dynamo.model.SimpleMarker;

public class DUtil {
	
	public static Table getTable() {
		AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
				.withRegion(Regions.EU_WEST_2)
				.build();

        DynamoDB dynamoDB = new DynamoDB(client);

        return dynamoDB.getTable("Markers");
	}
	
	public static Marker markerFromItem(Item outcome) {
		Gson gson = new Gson();
		return gson.fromJson(outcome.toJSON(), Marker.class);
	}
	
	public static SimpleMarker simplemarkFromItem(Item outcome) {
		Gson gson = new Gson();
		return gson.fromJson(outcome.toJSON(), SimpleMarker.class);
	}
}
