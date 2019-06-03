package aws.arealapp.dynamo.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.joda.time.DateTime;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazonaws.services.dynamodbv2.document.QueryOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.google.gson.Gson;

import Interfaces.Params;

public class DUtil {
	public static Gson gson = new Gson();
	
	public static Table getTable(String table) {
		AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
				.withRegion(Regions.EU_WEST_2)
				.build();

        DynamoDB dynamoDB = new DynamoDB(client);

        return dynamoDB.getTable(table);
	}
	
	public static List<Map<String, Object>> itemCollectToMapList(ItemCollection itemColection){
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		for(Object i : itemColection) {
			mapList.add( ((Item) i).asMap());
		}
		return mapList;
	}
	
	public static Item makeItemWithParams(Map input, Params paramObj) throws Exception{
        
		String[] params = paramObj.getStringParams();

		Item item = new Item();
        
    	for(String param : params) {
    		if(!input.containsKey(param)) {
    			throw new Exception("Missing string param: " + param);
    		}
    		item = item.withString(param,(String) input.get(param));
    	}
    	
    	params = paramObj.getNumberParams();
    	for(String param : params) {
    		if(!input.containsKey(param)) {
    			throw new Exception("Missing number param: " + param);
    		}
    		item = item.withNumber(param,(Number) input.get(param));
    	}
    	
    	params = paramObj.getBooleanParams();
    	for(String param : params) {
    		if(!input.containsKey(param)) {
    			throw new Exception("Missing boolean param: " + param);
    		}
    		item = item.withBoolean(param,(Boolean) input.get(param));
    	}
        
    	params = paramObj.getMapParams();
    	for(String param : params) {
    		if(!input.containsKey(param)) {
    			throw new Exception("Missing map param: " + param);
    		}
    		item = item.withMap(param,(Map<String, ?>) input.get(param));
    	}
    	return item;		
	}
	
	public static Item addRandomPK(Item item, Map input, Params paramsObj) {
		Random r = new Random();
		String pk = String.valueOf(r.nextLong());
		
		return item.withPrimaryKey(paramsObj.getPk(), pk);
	}
	

	
	
	
}
