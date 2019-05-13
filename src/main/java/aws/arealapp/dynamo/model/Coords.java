package aws.arealapp.dynamo.model;

public class Coords {
	double latitude;
	double longditude;
	
	public Coords() {
		latitude = 60;
		longditude = 5;
	}

	public Coords(double latitude, double longditude) {
		super();
		this.latitude = latitude;
		this.longditude = longditude;
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
	
	
}
