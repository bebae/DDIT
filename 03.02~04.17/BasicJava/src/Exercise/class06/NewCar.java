package Exercise.class06;

public class NewCar {
	private double speed;
	private String color;
	private final static double MAX_SPEED = killoToMile(200);
	
	public NewCar() {
	}
	public NewCar(String color) {
		this.color = color;
	}
	
	public double getSpeed() {
		return mileToKilo(speed);
	}
	public void setSpeed(double speed) {
		this.speed = killoToMile(speed);
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public boolean speedUp(double speed) {
		speed = killoToMile(speed);
		if (this.speed + speed > 0 && this.speed+speed <= MAX_SPEED) {
			this.speed += speed;
				return true;
			} 
		return false;
	}
	public static double getMaxSpeed() {
		return mileToKilo(MAX_SPEED);
	}
	private static double killoToMile(double distance) {
		distance /= 1.6;
		return distance;
	}
	private static double mileToKilo(double distance) {
		distance *= 1.6;
		return distance;
	}
}
