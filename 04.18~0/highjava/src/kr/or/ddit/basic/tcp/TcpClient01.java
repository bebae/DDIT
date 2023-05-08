package kr.or.ddit.basic.tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class TcpClient01 {
    public static void main(String[] args) throws IOException {

        System.out.println("server 연결 합니다...\n");
        Socket socket = new Socket("127.0.0.1", 7777);

        System.out.println("server 에 연결되었습니다.\n");

        // server 의 메세지 받기
        InputStream is = socket.getInputStream();
        DataInputStream dis = new DataInputStream(is);

        System.out.println("server 에서 온 메세지 : "+ dis.readUTF());
        System.out.println("\n연결을 종료합니다");

        dis.close();
        is.close();
        socket.close();
    }
}
