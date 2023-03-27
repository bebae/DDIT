package Exercise.class06;

public class Time {
	int hour;
	int minute;
	int second;
	
	public Time() {
		hour = 0;
		minute = 0;
		second = 0;
	}
	public Time(int hour, int minute, int second) {
		if (hour >= 0 && hour <= 23) {
			this.hour = hour;
		} else {
			this.hour = 0;
		}
		if (minute >= 0 && minute <= 59) {
			this.minute = minute;
		} else {
			this.minute = 0;
		}
		if (second >= 0 && second <= 59) {
			this.second = second;
		} else {
			this.second = 0;
		}
	}
	
	public String toString() {		
		return String.format("%02d:%02d:%02d", hour,minute,second);
	}
	
}
