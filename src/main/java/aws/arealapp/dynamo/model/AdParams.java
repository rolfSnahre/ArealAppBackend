package aws.arealapp.dynamo.model;

import java.util.HashMap;
import java.util.Map;

import Interfaces.Params;
import Interfaces.ParamsWithSK;

public class AdParams implements ParamsWithSK {
	
	public static final String pk = "adId";
	
	public static final String sk = "date";
	
	
	public static final String[] paramTypes = {"String", "Number", "Boolean", "Map"};

	public static final String[] reqParams = {"category", "place", "contact", "email", "number", "description"};

	public static final String[] stringParams  = 
		{"category", "place", "contact", "email", "number", "description"};
	
	public static final String[] numParams = {};
	
	public static final String[] boolParams = {};
	
	public static final String[] mapParams = {"user"};
	
	public static Map<String, String[]> getParamsMap(){
		Map<String, String[]> paramMap = new HashMap<String, String[]>();
		
		paramMap.put(paramTypes[0], stringParams);
		paramMap.put(paramTypes[1], numParams);
		paramMap.put(paramTypes[2], boolParams);
		paramMap.put(paramTypes[3], mapParams);
		
		return paramMap;
	}


	@Override
	public String[] getNumberParams() {
		
		return numParams;
	}

	@Override
	public String[] getBooleanParams() {
		// TODO Auto-generated method stub
		return boolParams;
	}

	@Override
	public String[] getMapParams() {
		// TODO Auto-generated method stub
		return mapParams;
	}


	@Override
	public String getPk() {
		// TODO Auto-generated method stub
		return pk;
	}
	
	public String getSk() {
		return sk;
	}


	@Override
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