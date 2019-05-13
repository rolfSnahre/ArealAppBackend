package aws.arealapp.dynamo;

import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.GetItemSpec;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;

import aws.arealapp.dynamo.model.*;

public class GetMarker implements RequestHandler<Coords, Object> {
	 
	@Override
	public Object handleRequest(Coords input, Context context) {
		
        Table table = DUtil.getTable();

        double lat = input.getLatitude();
        double lon = input.getLongditude();
       
        GetItemSpec spec = new GetItemSpec().withPrimaryKey("latitude", lat, "longditude", lon);
        Gson gson = new Gson();

        
        try {
            Item outcome = table.getItem(spec);
            
            if(outcome == null) {
            	return "could not find marker";
            }else {
            	Marker m = DUtil.markerFromItem(outcome);

                return m;
            }
            
        }
        catch (Exception e) {
        	e.printStackTrace();
            return e.getMessage();
        }
        
	} 
}
