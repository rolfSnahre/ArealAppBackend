package aws.arealapp.dynamo.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazonaws.services.dynamodbv2.document.Table;

import Interfaces.Params;

public class DUtil {
	
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
	
	public static Item makeItemWithParams(Map<String, Object> input, Params paramObj) throws Exception{
        
		Item item = new Item();
        
    	for(String param : paramObj.getReqParams()) {
    		if(!input.containsKey(param)) {
    			throw new Exception("Missing required param: " + param);
    		}
    	}
    	
    	for(String param : input.keySet()) {
    		item.with(param, input.get(param));
    	}
    	
    	return item;		
	}
	
	public static Item addRandomPK(Item item, Params paramsObj) {
		Random r = new Random();
		String pk = String.valueOf(r.nextLong());
		
		return item.withPrimaryKey(paramsObj.getPk(), pk);
	}
	
	public static String getDate() {
		DateTime dateTime = DateTime.now(DateTimeZone.forOffsetHours(2));
		String date = dateTime.getDayOfMonth() + "/" + dateTime.getMonthOfYear() + "/" + dateTime.getYear() + "-" + dateTime.getHourOfDay() + dateTime.getMinuteOfHour(); 
		return date;
	}
	
	public static String inputToID(Object input, Params paramObj) {
		if(input instanceof String) {
			return (String) input;
		}else {
			return (String) ((Map) input).get(paramObj.getPk());
		}
		
	}
	

	
	
	
}
