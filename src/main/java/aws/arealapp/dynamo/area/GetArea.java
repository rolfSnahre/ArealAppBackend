package aws.arealapp.dynamo.area;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import aws.arealapp.dynamo.model.AreaParams;
import aws.arealapp.dynamo.util.DatabaseOperations;

public class GetArea implements RequestHandler<String, Object> {

	@Override
	public Object handleRequest(String id, Context context) {
		
		DatabaseOperations databaseObj = new DatabaseOperations();
		
		try {
			return databaseObj.getObj(id, "Areas", new AreaParams());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.getMessage();
		}
		
	}

}
