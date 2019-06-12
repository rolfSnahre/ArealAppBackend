package aws.arealapp.dynamo.model;

import java.util.HashMap;
import java.util.Map;

import Interfaces.Params;

public class MarkersParams implements Params {
public static final String pk = "markerId";
	
	public static final String[] paramTypes = {"String", "Number", "Boolean", "Map"};
	
	public static final String[] reqParams = {"coordinates"};

	public static final String[] stringParams  = 
		{"pinColor"};
	
	public static final String[] numParams = {};
	
	public static final String[] boolParams = {};
	
	public static final String[] mapParams = {"coordinates", "markerData"};
	
	public static Map<String, String[]> getParamsMap(){
		Map<String, String[]> paramMap = new HashMap<String, String[]>();
		
		paramMap.put(paramTypes[0], stringParams);
		paramMap.put(paramTypes[1], numParams);
		paramMap.put(paramTypes[2], boolParams);
		paramMap.put(paramTypes[3], mapParams);
		
		return paramMap;
	}

	public String[] getNumberParams() {
		
		return numParams;
	}

	public String[] getBooleanParams() {
		return boolParams;
	}

	public String[] getMapParams() {
		// TODO Auto-generated method stub
		return mapParams;
	}


	public String getPk() {
		// TODO Auto-generated method stub
		return pk;
	}


	public String[] getStringParams() {
		// TODO Auto-generated method stub
		return stringParams;
	}

	@Override
	public String[] getReqParams() {
		// TODO Auto-generated method stub
		return reqParams;
	}
	
}
