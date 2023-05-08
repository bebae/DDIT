package kr.or.ddit.basic.tcp;

import java.io.DataInputStream;
import java.net.Socket;

/**
 * 이 클래스는 소켓에서 메시지를 받아서 화면에 출력하는 역할을 담당하는 스레드
 */
public class Receiver extends Thread {
    private Socket socket;
    private DataInputStream dis;

    public Receiver(Socket socket) {
        this.socket = socket;

        try {
            dis = new DataInputStream(this.socket.getInputStream());
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while(dis != null) {
            try {
                System.out.println(dis.readUTF());
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}
