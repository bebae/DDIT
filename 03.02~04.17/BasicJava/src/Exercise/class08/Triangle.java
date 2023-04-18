package Exercise.class08;

public class Triangle extends Shape {
	private double side;

	public Triangle(double side) {
		this.side = side;
	}

	@Override
	public double perimeter() {
		return side * 3;
	}
	@Override
	public double area() {
		return side * side * (Math.sqrt(3)/4.0);
	}

	@Override
	public String toString() {
		return String.format("도형의 종류: %s, 둘레: %.2fcm, 넓이: %.2fcm²", "삼각형", perimeter(), area());
	}
	
}
