package aws.arealapp.dynamo.area;

import java.util.Map;

import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.GetItemSpec;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;

import aws.arealapp.dynamo.model.AreaParams;
import aws.arealapp.dynamo.model.Marker;
import aws.arealapp.dynamo.util.DUtil;
import aws.arealapp.dynamo.util.DatabaseOperations;

public class GetArea implements RequestHandler<String, Object> {

	@Override
	public Object handleRequest(String id, Context context) {
		
		DatabaseOperations databaseObj = new DatabaseOperations();
		
		return databaseObj.getObj(id, "Areas", new AreaParams());
		
	}

}
