package Exercise.class08;

public abstract class Shape implements Comparable<Shape> {
    private double num;

    public Shape(){
    }

    public Shape(Double num){
        this.num = num;
    }
    public abstract double perimeter();
    public abstract double area();

    public Double getNum() {
        return num;
    }

    @Override
    public int compareTo(Shape other) {
        return Double.compare(this.area(), other.area());
    }
/*  //내림차순 정렬
    public int compareTo(Shape other) {
        return Double.compare(other.area(), this.area());
    }*/

}