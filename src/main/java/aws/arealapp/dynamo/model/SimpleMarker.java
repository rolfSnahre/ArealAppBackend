package aws.arealapp.dynamo.model;

import java.util.Map;

public class SimpleMarker{
	
	double latitude;
	double longditude;
	String pinColour;
	
	public SimpleMarker(double latitude, double longditude, 
			String pinColour) {
		super();
		this.latitude = latitude;
		this.longditude = longditude;
		this.pinColour = pinColour;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongditude() {
		return longditude;
	}

	public void setLongditude(double longditude) {
		this.longditude = longditude;
	}

	public String getPinColour() {
		return pinColour;
	}

	public void setPinColour(String pinColour) {
		this.pinColour = pinColour;
	}


	
	
}
