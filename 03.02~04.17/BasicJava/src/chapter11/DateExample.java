package chapter11;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateExample {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);

        // 형식을 2023-04-05 수요일로 하고 싶을 때
        // 단점 보안적 문제 발생
        SimpleDateFormat sdf =  new SimpleDateFormat("yyyy년 MM월 dd일 E요일");
        System.out.println(sdf.format(date));

        // 날짜를 Singleton 형식으로 제공
        // 단점 코드가 너무 길어짐
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int date2 = calendar.get(Calendar.DATE);
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        System.out.printf("%04d-%02d-%02d %d\n",year,month+1,day,day);

        // JDK 1.8부터 사용 가능
        System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 E요일\n")));
        System.out.print(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일\nE요일 a\nhh시 mm분 ss초")));
    /*
        "yyyy.MM.dd G 'at' HH:mm:ss z"
        2001.07.04 AD at 12:08:56 PDT
        "EEE, MMM d, ''yy"
        Wed, Jul 4, '01
        "h:mm a"
        12:08 PM
        "hh 'o''clock' a, zzzz"
        12 o'clock PM, Pacific Daylight Time
        "K:mm a, z"
        0:08 PM, PDT
        "yyyyy.MMMMM.dd GGG hh:mm aaa"
        02001.July.04 AD 12:08 PM
        "EEE, d MMM yyyy HH:mm:ss Z"
        Wed, 4 Jul 2001 12:08:56 -0700
        "yyMMddHHmmssZ"
        010704120856-0700
        "yyyy-MM-dd'T'HH:mm:ss.SSSZ"
        2001-07-04T12:08:56.235-0700
        "yyyy-MM-dd'T'HH:mm:ss.SSSXXX
     */
    }
}
