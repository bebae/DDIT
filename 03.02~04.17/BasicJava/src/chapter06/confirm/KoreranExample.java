package chapter06.confirm;

class Koreaan {
	String nation = "대한민국";
	String name;
	String ssn;
	public Koreaan() {
	}
	public Koreaan(String name) {
		this(null, name, null);
	}
	
	public Koreaan(String name, String ssn) { 
		this(null, name, ssn);
	}
	public Koreaan(String nation, String name, String ssn) {
		this.nation = nation;
		this.name = name;
		this.ssn = ssn;
	}
	
}

public class KoreranExample {
	public static void main(String[] args) {
		Koreaan k1 = new Koreaan();
		System.out.println(k1.nation+" "+k1.name+" "+k1.ssn);
		Koreaan k2 = new Koreaan("김민수", "13");
		System.out.println(k2.nation+" "+k2.name+" "+k2.ssn);
		
	}
}
