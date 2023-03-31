package chapter09.exam02;

public class SoundableExample {
    public static void main(String[] args) {

        Soundable s = new Soundable() {
            @Override
            public String sound() {
                return "어흥";
            }
        };

        s = () -> "어흥";
        System.out.println(s.sound());
    }
}
