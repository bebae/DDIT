package kr.or.ddit.basic.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

/**
 *  UDP 방식 : 비연결 지향 / 신뢰성이 없음 / 데이터 순서를 보장하지 않음 / TCP 보다 속도 빠름
 *  - DatagramSocket : 데이터의 송수신과 관련된 작업을 수행한다. (우체부)
 *  - DatagramPacket : 주고 받는 데이터와 관련된 작업을 수행한다. (소포, 편지)
 *      ==> 수신용 생성자와 송신용 생성자를 따로 제공한다.
 *      TCP : 스트리객체를 이용해 송수신한다.
 *      UDP : 데이터그램을 이용해 송수신한다.
 */
public class UdpServer {
    public static void main(String[] args) {
        try {
            // 통신용 소켓 생성
            DatagramSocket socket = new DatagramSocket(8888);
            
            System.out.println("서버 실행 중");

            while (true) {
                // 클라이언트 메세지 받기
                byte[] buffer = new byte[521];

                // 수신용 패킷 객체  필요한 매개 변수(바이트, 바이트 길이)
                DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
                
                socket.receive(dp);     // 데이터 올 때까지 대기중

                // 수신 받은 패킷으로 상대방의 IP와 Port 번호를 알 수 있다.
                InetAddress clientIp = dp.getAddress();
                int port = dp.getPort();

                System.out.println("clientIp : "+ clientIp + "port : " + port+"\n");

                // 클라이언트가 보낸 메세지 출력
                String msg = new String(dp.getData(), 0, dp.getLength(), StandardCharsets.UTF_8);

                if("/end".equals(msg)) break;

                System.out.println("client가 보낸 메시지 : " + msg);

                // 송신할 메시지를 byte 형 배열로 변환
                byte[] sendData = msg.getBytes(StandardCharsets.UTF_8);

                // 송신용 패킷 객체 생성
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientIp, port);

                // 데이터 송신하기
                socket.send(sendPacket);

                System.out.println("송신 완료!\n");

            }

            System.out.println("통신 끝!");
            socket.close();

        } catch (Exception ignored) {}
    }
}
