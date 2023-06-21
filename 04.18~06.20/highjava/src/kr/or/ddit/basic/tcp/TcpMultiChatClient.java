package kr.or.ddit.basic.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TcpMultiChatClient {
    public static void main(String[] args) {
        new TcpMultiChatClient().clientStart();
    }

    /**
     *  클라이언트의 시작 메소드
     */
    private void clientStart() {
        Socket socket = null;
        try {
            socket = new Socket("localhost", 7777);
//            socket = new Socket("192.168.142.4", 7777);
            System.out.println("서버에 연결되었습니다.");

            ClientSender sender = new ClientSender(socket);
            ClientReceiver receiver = new ClientReceiver(socket);

            sender.start();
            receiver.start();

        } catch (Exception ignored) {}
    }

    /**
     *  메세지 전용 스레드
     */
    static class ClientSender extends Thread {
        private final Socket socket;
        private DataInputStream dis;
        private DataOutputStream dos;
        private String name;
        private final Scanner scan;


        public ClientSender(Socket socket) {
            this.socket = socket;
            scan = new Scanner(System.in);
            try {
                dis = new DataInputStream(socket.getInputStream());     // 수신용
                dos = new DataOutputStream(socket.getOutputStream());   // 송신용

                // 클라이언트 용 프로그램은 처음 실행하면 서버에 접속 후
                // '대화명'을 입력 받아 전송하고 서버에서 중복체크 여부를 받는다.
                String name = "";
                String feedback = "";
                while (true) {
                    System.out.print("대화명 입력 >> ");
                    name = scan.nextLine();
                    dos.writeUTF(name); // 대화명 전송
                    feedback = dis.readUTF(); // 대화명 중복 여부 응답 받음
                    System.out.println(feedback);
                    if ("대화명 중복". equals(feedback)) {
                        System.out.println(name+"은 대화명이 중복됩니다.");
                        System.out.println("다른 대화명을 입력하세요.");
                    } else {
                        this.name = name;
                        System.out.println(name+" 대화명으로 대화방에 입장했습니다.");
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } // 생성자 끝

        @Override
        public void run() {
            try {
                while (dos != null) {
                    // 키보드로 입력한 정보를 서버로 보냄
                    dos.writeUTF("["+name + "] : " + scan.nextLine());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *  메세지 수신용 스레드
     */
    static class ClientReceiver extends Thread {
        private final Socket socket;
        private DataInputStream dis;

        public ClientReceiver(Socket socket) {
            this.socket = socket;
            try {
                dis = new DataInputStream(socket.getInputStream());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {
                while (dis != null) {
                    System.out.println(dis.readUTF());
                }
            } catch (Exception ignored) {}
        }
    }
}











