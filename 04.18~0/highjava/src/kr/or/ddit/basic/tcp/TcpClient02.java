package kr.or.ddit.basic.tcp;

import java.net.Socket;

public class TcpClient02 {
    public static void main(String[] args) {

        try {
//            Socket socket = new Socket("localhost", 7777);
            Socket socket = new Socket("192.168.142.23", 7777);
            Sender sender = new Sender(socket);
            Receiver receiver = new Receiver(socket);

            sender.start();
            receiver.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
