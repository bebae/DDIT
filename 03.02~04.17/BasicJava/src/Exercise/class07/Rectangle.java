package Exercise.class07;

public class Rectangle extends Shape {
	private double width;
	private double height;
	
	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	@Override
	public double perimeter() {
		return (width + height) * 2;
	}
	@Override
	public double area() {
		return width * height;
	}

	@Override
	public String toString() {
		return String.format("도형의 종류: %s, 둘레: %scm, 넓이: %scm²", "사각형", perimeter(), area());
	}
}
