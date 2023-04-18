package Exercise.class07;

public class Circle extends Shape {
	private double radius;

	public Circle(double radius) {
		this.radius = radius;
	}

	@Override
	public double perimeter() {
		return radius * 2 * Math.PI;
	}
	@Override
	public double area() {
		return radius * radius * Math.PI;
	}

	@Override
	public String toString() {
		return String.format("도형의 종류: %s, 둘레: %scm, 넓이: %scm²", "원", perimeter(), area());
	}

}
