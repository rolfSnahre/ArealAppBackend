package aws.arealapp.dynamo.area;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import aws.arealapp.dynamo.model.*;
import aws.arealapp.dynamo.util.DatabaseOperations;

import java.util.Map;


public class AddArea implements RequestHandler<Map<String, Object>, Object> {
    
	@Override
	public Object handleRequest(Map<String, Object> input, Context context) {
		
		DatabaseOperations databaseOp = new DatabaseOperations();
		
		return databaseOp.addObjRandId(input, "Areas", new MarkersParams());
		
//        Table table = DUtil.getTable("areas");
        
//        areaParams pp = new areaParams();
//        
//        Item item = new Item().withPrimaryKey(pp.pk, input.get(pp.pk));
//        
//        Map<String, String[]> paramTypesMap = pp.getParamsMap();
//        String[] params = pp.stringParams;
//        
//    	for(String param : params) {
//    		item = item.withString(param,(String) input.get(param));
//    	}
//        
//    	params = pp.mapParams;
//    	for(String param : params) {
//    		item = item.withMap(param,(Map) input.get(param));
//    	}
//    	
//    	try {
//    		PutItemOutcome outcome = table.putItem(item);
//    		
//    		return input;
//    	}catch(Exception e){
//    		return e.getMessage();
//    		
//    	}
        
//        Table table = DUtil.getTable("areas");
//		
//        String areaId = input.getareaId();
//        String kontakt = input.getKontakt();
//        String email = input.getEmail();
//        String number = input.getNumber();
//        String description = input.getDescription();
//        String date = input.getDate();
//        
//        Map<String, Object> user = input.getUser();
//
//        
//        try {
//        	PutItemOutcome outcome = table
//        			.putItem(new Item().withPrimaryKey("areaId", areaId)
//        			.withString("areaId", areaId)
//        			.withString("kontakt", kontakt)
//        			.withString("email", email)
//        			.withString("number", number)
//        			.withString("description", description)
//        			.withString("date", date)
//        			.withMap("user", user));
//        	
//        	return input;
//        	
//        }catch(Exception e) {
//        	return e.getMessage();
//        }
        
	}
}
