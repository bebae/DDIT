package kr.or.ddit.basic.tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer02 {
    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(7777);

        System.out.println("서버가 준비 중입니다.");

        Socket socket = server.accept(); // 접속 대기
        Sender sender = new Sender(socket);
        Receiver receiver = new Receiver(socket);


        sender.start();
        receiver.start();

    }
}
