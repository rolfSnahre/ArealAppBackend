package aws.arealapp.dynamo.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.amazonaws.services.dynamodbv2.document.DeleteItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazonaws.services.dynamodbv2.document.KeyAttribute;
import com.amazonaws.services.dynamodbv2.document.PrimaryKey;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.ScanOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.DeleteItemSpec;
import com.amazonaws.services.dynamodbv2.document.spec.GetItemSpec;
import com.amazonaws.services.dynamodbv2.document.spec.ScanSpec;
import com.amazonaws.services.lambda.runtime.Context;
import com.google.gson.Gson;

import Interfaces.Params;
import aws.arealapp.dynamo.model.Marker;
import aws.arealapp.dynamo.model.AreaParams;

public class DatabaseOperations {
	
	public Object addObjRandId(Map<String, Object> input, String tableName, Params paramObj) {
		Random r = new Random();
		String pk = String.valueOf(r.nextLong());
		
		return addObj(pk, input, tableName, paramObj);
	}
		
	public Object addObj(String pk, Map<String, Object> input, String tableName, Params paramObj) {
		
		Table table = DUtil.getTable(tableName);
		
		
        
		Item item = new Item().withPrimaryKey(paramObj.getPk(), pk);
		
        
        String[] params = paramObj.getStringParams();
        
    	for(String param : params) {
    		if(!input.containsKey(param)) {
    			return "Missing string param: " + param;
    		}
    		item = item.withString(param,(String) input.get(param));
    	}
    	
    	params = paramObj.getNumberParams();
    	for(String param : params) {
    		if(!input.containsKey(param)) {
    			return "Missing number param: " + param;
    		}
    		item = item.withNumber(param,(Number) input.get(param));
    	}
    	
    	params = paramObj.getBooleanParams();
    	for(String param : params) {
    		if(!input.containsKey(param)) {
    			return "Missing boolean param: " + param;
    		}
    		item = item.withBoolean(param,(Boolean) input.get(param));
    	}
        
    	params = paramObj.getMapParams();
    	for(String param : params) {
    		if(!input.containsKey(param)) {
    			return "Missing map param: " + param;
    		}
    		item = item.withMap(param,(Map) input.get(param));
    	}
    	
    	try {
    		PutItemOutcome outcome = table.putItem(item);
    		input.put(paramObj.getPk(), pk);
    		
    		return input;
    	}catch(Exception e){
    		return e.getMessage();
    		
    	}
	}
	
	public Object  getAll(Map<String, Object> input, String tableName, Params paramObj) {
		Gson gson = new Gson();
		
		Table table = DUtil.getTable(tableName);

		ScanSpec spec = new ScanSpec();
				//withProjectionExpression("coordinate, pinColor, StringData");
		try {
			ItemCollection<ScanOutcome> mCol = table.scan(spec);
			Iterator<Item> mIter = mCol.iterator();

			List<Map<String, Object>> items = new ArrayList<Map<String,Object>>();
			Map<String, Object> itemAsMap;
			
			while(mIter.hasNext()) {
				Item item = mIter.next();

				itemAsMap = item.asMap();
				
				items.add(itemAsMap);
			}

			return items;
		}catch(Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	public Object deleteObj(String id, String tableName, Params paramObj) {
		Table table = DUtil.getTable(tableName);

        DeleteItemSpec spec = new DeleteItemSpec().
        		withPrimaryKey(paramObj.getPk(), id);
        
        try {
            DeleteItemOutcome outcome = table.deleteItem(spec);
            
            return outcome;
        }
        catch (Exception e) {
        	e.printStackTrace();
            return e.getMessage();
        }
        
	} 
	
	public Object getObj(String id, String tableName, Params paramObj) {
		 
		Table table = DUtil.getTable(tableName);

        GetItemSpec spec = new GetItemSpec().withPrimaryKey(paramObj.getPk(), id);
        
        Gson gson = new Gson();
        
        try {
            Item outcome = table.getItem(spec);
            
            if(outcome == null) {
            	return "could not find objeckt";
            }else {
            	Map m = outcome.asMap();

                return m;
            }
            
        }
        catch (Exception e) {
        	e.printStackTrace();
            return e.getMessage();
        }
	}
	
	
}
