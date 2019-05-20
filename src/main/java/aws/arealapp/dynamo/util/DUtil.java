package aws.arealapp.dynamo.util;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.google.gson.Gson;

public class DUtil {
	public static Gson gson = new Gson();
	
	public static Table getTable(String table) {
		AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
				.withRegion(Regions.EU_WEST_2)
				.build();

        DynamoDB dynamoDB = new DynamoDB(client);

        return dynamoDB.getTable(table);
	}
	
}
