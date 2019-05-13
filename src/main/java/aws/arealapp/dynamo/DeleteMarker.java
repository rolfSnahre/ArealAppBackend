package aws.arealapp.dynamo;

import com.amazonaws.services.dynamodbv2.document.DeleteItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.DeleteItemSpec;
import com.amazonaws.services.dynamodbv2.document.spec.GetItemSpec;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;

import aws.arealapp.dynamo.model.*;

public class DeleteMarker implements RequestHandler<Coords, Object> {
	 
	@Override
	public Object handleRequest(Coords input, Context context) {
		
        Table table = DUtil.getTable();

        double lat = input.getLatitude();
        double lon = input.getLongditude();
       
        DeleteItemSpec spec = new DeleteItemSpec().
        		withPrimaryKey("latitude", lat, "longditude", lon);
        
        try {
            DeleteItemOutcome outcome = table.deleteItem(spec);

            return outcome;
            
        }
        catch (Exception e) {
        	e.printStackTrace();
            return e.getMessage();
        }
        
	} 
}
