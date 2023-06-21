package kr.or.ddit.basic.tcp;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer01 {
    public static void main(String[] args) throws Exception {
        // TCP 소켓 통신을 위한 ServerSocket 객체를 생성한다.
        ServerSocket server = new ServerSocket(7777);

        System.out.println("TCP 접속을 기다립니다.");

        Socket socket = server.accept(); // 클라이언트 연결 요청이 올 때까지 기다린다.

        // accept()메소드 이후 내용은 클라이언트와 연결이 완료되어야만 실행된다.
        System.out.println("Client 연결됨  : " + socket.getInetAddress()+"\n");

        System.out.println("접속한 상대방의 정보 ");
        System.out.println("IP Address : " + socket.getInetAddress());
        System.out.println("Port : " + socket.getPort());
        System.out.println("=====================================");

        System.out.println("Server 의 정보");
        System.out.println("Server IP Address : " + socket.getLocalAddress());
        System.out.println("Server Port : " + socket.getLocalPort());
        System.out.println("=====================================");

        // client 에게 메세지 보내기
        OutputStream out = socket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(out);
        dos.writeUTF("Hello Client");
        System.out.println("메세지를 보냈습니다.\n");

        dos.close();
        out.close();
        socket.close();
    }
}
