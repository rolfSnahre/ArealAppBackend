package aws.arealapp.dynamo.marker;

import java.util.Map;

import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.GetItemSpec;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import aws.arealapp.dynamo.util.DUtil;

public class GetMarkerData implements RequestHandler<String, Object> {
	 
	@Override
	public Object handleRequest(String id, Context context) {
		
        Table table = DUtil.getTable("Markers");
       
        GetItemSpec spec = new GetItemSpec().withPrimaryKey("key", id);
        
        try {
            Item outcome = table.getItem(spec);
            
            if(outcome == null) {
            	return "could not find marker";
            }else {
            	Map<String, Object> m = outcome.asMap();
            	 
            	return m.get("markerData");
            }
            
        }
        catch (Exception e) {
        	e.printStackTrace();
            return e.getMessage();
        }
        
	} 
}
