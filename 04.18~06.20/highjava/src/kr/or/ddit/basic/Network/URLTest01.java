package kr.or.ddit.basic.Network;

import java.net.MalformedURLException;
import java.net.URL;

public class URLTest01 {
    public static void main(String[] args) throws MalformedURLException {
        // URL 클래스 ==> 인터넷에 존재하는 서버들의 자원에 접근할 수 있는 주소를 다루는 클래스
        // URL 주소 형식 : 프로토콜://호스트명:포트번호/경로명/파일명?쿼리스트림#참조

        URL url = new URL("http://ddit.or.kr/index.html?ttt=123#header");
        System.out.println("Protocol : " + url.getProtocol());
        System.out.println("Host : " + url.getHost());
        System.out.println("Port : " + url.getPort());
        System.out.println("File : " + url.getFile());
        System.out.println("Path : " + url.getPath());
        System.out.println("Query : " + url.getQuery());
        System.out.println("Ref : " + url.getRef());
        System.out.println();
    }
}