package aws.arealapp.dynamo.marker;

import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import aws.arealapp.dynamo.model.MarkersParams;
import aws.arealapp.dynamo.util.DatabaseOperations;

public class UpdateMarker implements RequestHandler<Map<String, Object>, Object> {

	public Object handleRequest(Map<String, Object> input, Context context) {
			
			DatabaseOperations databaseOp = new DatabaseOperations();
			
			MarkersParams mParams = new MarkersParams();
			String pk = (String) input.get(mParams.getPk());
			
			return databaseOp.addObj(pk, input, "Markers", new MarkersParams());
	}
}