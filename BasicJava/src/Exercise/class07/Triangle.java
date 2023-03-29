package Exercise.class07;

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
		return side * side * (Math.sqrt(3)/4);
	}

	@Override
	public String toString() {
		return String.format("도형의 종류: %s, 둘레: %scm, 넓이: %scm²", "삼각형", perimeter(), area());
	}
	
}
