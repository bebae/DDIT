package Exercise.class06;

public class NewCar {
	double speed;
	String color;
	final static double MAX_SPEED = killoToMile(200);
	
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
		if (this.speed + speed > 0) {
			if (this.speed + speed <= MAX_SPEED) {
				this.speed += speed;
				return true;
			} else {
				this.speed = 0;
				return false;
			}
		} else {
			this.speed = 0;
			return false;
		}
	}
	public static double getMaxSpeed() {
		return MAX_SPEED;
	}
	private static double killoToMile(double speed) {
		speed = speed * 0.62137;
		return speed;
	}
	private static double mileToKilo(double speed) {
		speed = speed / 0.62137;
		return speed;
	}
}
