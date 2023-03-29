package Exercise.class06;

public class Plane {
	private String manufacturer;
	private String model;
	private int maxNumberOfPassengers;
	private static int numberOfPlanes;
	
	public Plane() {
		numberOfPlanes++;
	}
	public Plane(String manufacturer, String model, int maxNumberOfPassengers) {
		this.manufacturer = manufacturer;
		this.model = model;
		if (maxNumberOfPassengers < 0) {
			this.maxNumberOfPassengers = 0;
		}
		this.maxNumberOfPassengers = maxNumberOfPassengers;
		numberOfPlanes++;
	}
	
	public String getManufacturer() {
		return this.manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getModel() {
		return this.model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getMaxNumberOfPassengers() {
		return this.maxNumberOfPassengers;
	}
	public void setMaxNumberOfPassengers(int maxNumberOfPassengers) {
		if (maxNumberOfPassengers > 0) {
			this.maxNumberOfPassengers = maxNumberOfPassengers;
		}
	}
	static int getNumberOfPlanes() {
		return numberOfPlanes;
	}
}














