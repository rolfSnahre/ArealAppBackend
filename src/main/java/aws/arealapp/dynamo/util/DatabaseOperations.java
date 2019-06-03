package aws.arealapp.dynamo.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.amazonaws.services.dynamodbv2.document.DeleteItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.ScanOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.DeleteItemSpec;
import com.amazonaws.services.dynamodbv2.document.spec.GetItemSpec;
import com.amazonaws.services.dynamodbv2.document.spec.ScanSpec;
import com.google.gson.Gson;

import Interfaces.Params;
import Interfaces.ParamsWithSK;

public class DatabaseOperations {
	
	public Object addObjRandId(Map<String, Object> input, String tableName, Params paramObj) {
		Random r = new Random();
		//String pk = String.valueOf(r.nextLong());
		String pk = "-8631806665401014697";
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
		
		Table table = DUtil.getTable(tableName);

		ScanSpec spec = new ScanSpec();
		try {
			ItemCollection<ScanOutcome> result = table.scan(spec);
			
			return DUtil.itemCollectToMapList(result);

		}catch(Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	public Object deleteObj(String id, String tableName, Params paramObj)throws Exception {
		Table table = DUtil.getTable(tableName);

        DeleteItemSpec spec = new DeleteItemSpec().
        		withPrimaryKey(paramObj.getPk(), id);
        		
        
        DeleteItemOutcome outcome = table.deleteItem(spec);
        
        return outcome;
	} 
	
	public Object deleteObjWithSortKey(String pk, String sk, String tableName, ParamsWithSK paramObj) throws Exception{
		Table table = DUtil.getTable(tableName);

        DeleteItemSpec spec = new DeleteItemSpec().
        		withPrimaryKey(paramObj.getPk(), pk, paramObj.getSk(), sk);
        		
        
        DeleteItemOutcome outcome = table.deleteItem(spec);
        
        return outcome;
	}
	
	public Object getObj(String id, String tableName, Params paramObj) {
		 
		Table table = DUtil.getTable(tableName);

        GetItemSpec spec = new GetItemSpec().withPrimaryKey(paramObj.getPk(), id);
        
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
	
	public Object getObjectWithKeyValue(String tableName, String key, String value) {
		Table table = DUtil.getTable("Ads");
		
		Map<String, Object> valueMap = new HashMap<String, Object>();
		
		valueMap.put(":key", value);
		
		//lager scanne spesifikasjon objeckt
		//Spesifiserer at man bare skal ha elementer med som har en parameter med navnet key og verdien value so er sendt inn
		ScanSpec spec = new ScanSpec()
				.withFilterExpression(key+"= :key")
				.withValueMap(valueMap);
		
		try{
			//bruker scanne spesifikasjons objektet i scan opperasjon
			ItemCollection<ScanOutcome> outcome = table.scan(spec);
			
			return DUtil.itemCollectToMapList(outcome);
			
		}catch(Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
}
