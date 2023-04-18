package Exercise.class06;

public class Car {
	private double speed;
	private String color;
	private final static double MAX_SPEED = 200;
	
	public Car() {
	}
	public Car(String color) {
		this.color = color;
	}
	
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public boolean speedUp(double speed) {
		if (this.speed + speed > 0 && this.speed+speed <= MAX_SPEED) {
			this.speed += speed;
				return true;
			} 
		return false;
	}
	public static double getMaxSpeed() {
		return MAX_SPEED;
	}
}
