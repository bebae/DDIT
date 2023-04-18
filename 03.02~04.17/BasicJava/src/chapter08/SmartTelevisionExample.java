package chapter08;

public class SmartTelevisionExample {
	public static void main(String[] args) {
		SmartTelevision tv = new SmartTelevision();
		
		RemoteControl rc = tv;
		Searchable searchable = tv;
		
		rc.turnOn();
		rc.setVolume(5);
		rc.setVolume(15);
		searchable.search("채널");
		searchable.search("sbs");
		rc.turnOff();
		
	}
}