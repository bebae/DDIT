package kr.or.ddit.basic.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class UdpClient {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        try {
            // 수신 받은 데이터가 저장될 byte 형 배열
            byte[] msg = new byte[521];

            // 소캣 객체 생성
            DatagramSocket socket = new DatagramSocket();

            // 접속할 곳의 주소 정보 생성
            InetAddress  address = InetAddress.getByName("127.0.0.1");

            while (true) {
                // 전송할 메시지를 입력 받는다.
                System.out.print("보낼 메시지 입력 >>> ");
                String str = scan.nextLine();

                // 전송용 패킷 객체 생성
                DatagramPacket outPacket =
                        new DatagramPacket(str.getBytes(StandardCharsets.UTF_8), str.getBytes(StandardCharsets.UTF_8).length, address, 8888);

                // 전송
                socket.send(outPacket);

                if ("/end".equals(str)) {       // 작업 종료 여부 확인
                    break;
                }

                // 수신용 패킷 객체 생성
                DatagramPacket inPacket = new DatagramPacket(msg, msg.length);

                // 데이터 수신
                socket.receive(inPacket);

                System.out.println("\n서버의 응답 메시지 : "
                        + new String(msg, 0, inPacket.getLength(), StandardCharsets.UTF_8));

            }   // while 문 종료

            System.out.println("통신 끝!");
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
