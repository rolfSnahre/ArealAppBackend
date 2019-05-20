package aws.arealapp.dynamo.model;

public class MarkerData {
	String number, category, contact, email, markerData, sun, soil;
	int size;
	
	public MarkerData(){
		
	}
	
	

	public MarkerData(String category, String contact, 
			String email, String markerData, String sun, 
			String soil, String number, int size) {
		super();
		this.category = category;
		this.contact = contact;
		this.email = email;
		this.markerData = markerData;
		this.sun = sun;
		this.soil = soil;
		this.number = number;
		this.size = size;
	}



	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getmarkerData() {
		return markerData;
	}

	public void setmarkerData(String markerData) {
		this.markerData = markerData;
	}

	public String getSun() {
		return sun;
	}

	public void setSun(String sun) {
		this.sun = sun;
	}

	public String getSoil() {
		return soil;
	}

	public void setSoil(String soil) {
		this.soil = soil;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	
}
