package Exercise.class06;

public class Circle {
	double radius;
	double x;
	double y;
	
	public Circle(){}
	
	double getArea() {
		double area = 0.0;
		
		area = radius*radius*Math.PI;
		
		return area;
	}
	double getRadius() {
		return radius;
	}
	void setRadius(double radius) {
		if (radius < 0) {
			this.radius = 0;
		} else {
			this.radius = radius;
		}
	}
	double getX() {
		return x;
	}
	void setX(double x) {
		this.x = x;
	}
	double getY() {
		return y;
	}
	void setY(double y) {
		this.y = y;
	}
}
