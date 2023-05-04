package kr.or.ddit.basic.Network;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

public class URLTest02 {
    public static void main(String[] args) throws IOException {
        // URL Connection 클래스 ==> 애플리케이션과 URL 간의 통신 연결을 위한 클래스
        // 특정 서버의 정보와 파일 내용을 가져와 출력하는 예제

        URL url = new URL("https://www.naver.com/index.html");

        // URL 객체를 이용해서 URLConnection 객체를 구한다.
        URLConnection urlCon = url.openConnection();

        // Header 정보 출력하기
        Map<String, List<String>> headerMap = urlCon.getHeaderFields();

        // 출력하기
        for (String headerKey : headerMap.keySet()) {
            System.out.println(headerKey + " : " + headerMap.get(headerKey));
        }
        System.out.println("=====================================");

        // 연결된 문서의 내용 읽어오기

        // 방법1 ==> URLConnection 의 getInputStream()을 활용하기
//        InputStream in = urlCon.getInputStream();
//        InputStreamReader isr = new InputStreamReader(in, StandardCharsets.UTF_8);
//        BufferedReader br = new BufferedReader(isr);
//
//        // 자료를 읽고 화면에 출력
//        String str;
//
//        while ((str = br.readLine()) != null) {
//            System.out.println(str);
//        }
//        br.close();
//        isr.close();
//        in.close();

        // 방법2 ==> URL 객체의 openStream()메소드 이용하기
        InputStream in2 = url.openStream();
        BufferedReader br2 = new BufferedReader(new InputStreamReader(in2, StandardCharsets.UTF_8));

        // 파일 출력 하기
        BufferedWriter bw = new BufferedWriter(new FileWriter("d:/D_Other/index.html"));

        String str;

        while ((str = br2.readLine()) != null) {
            System.out.println(str);
            bw.write(str+"\n");
        }
        bw.flush();
        bw.close();

        br2.close();
        in2.close();
        System.out.println("\n작 업 완 료");
    }
}
