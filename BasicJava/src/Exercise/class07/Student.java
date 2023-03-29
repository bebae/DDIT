package Exercise.class07;

public class Student extends Human {
	String major;

	public Student(String name, int age, String major) {
		super(name, age);
		this.major = major;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	@Override
	public String toString() {
		return String.format("이름: %s, 나이: %s, 전공: %s", getName(), getAge(), major);
	}
	
	
}
