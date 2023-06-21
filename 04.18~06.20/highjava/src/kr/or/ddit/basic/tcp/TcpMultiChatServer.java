package kr.or.ddit.basic.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *  Map 을 이용해서 접속한 클라이언트 정보 관리 
 */
public class TcpMultiChatServer {
    // Map 을 이용해 접속한 클라이언트 관리
    // Key 값 : 접속한 사람의 '대화명', value 값 : 접속한 클라이언트의 Socket 객체
    private final Map<String, Socket> clientMap;

    /**
     *  생성자
     */
    public TcpMultiChatServer() {
        clientMap = Collections.synchronizedMap(new HashMap<>());
    }
    public static void main(String[] args) {
        new TcpMultiChatServer().serverStart();
    }

    /**
     *  서버의 시작 메소드
     */
    private void serverStart() {
        ServerSocket server = null;
        Socket socket = null;
        try {
            server = new ServerSocket(7777);
            System.out.println("서버가 시작되었습니다.");

            while (true) {
                socket = server.accept();
                System.out.println("["+socket.getInetAddress()
                        +" : "+socket.getPort()+"]에서 접속했습니다.\n");

                ServerReceiver serverThread = new ServerReceiver(socket);
                serverThread.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *  clientMap 에 저장된 전체 사용자에게 메시지를 전송하는 메소드
     */
    private void sendToAll(String msg) {
        // clientMap Data Number 만큼 반복
        for (String name : clientMap.keySet()) {
            try {
                // key 값과 같이 있는 Socket 을 이용하여 출력 스트림 객체 생성
                DataOutputStream dos = new DataOutputStream(clientMap.get(name).getOutputStream());
                dos.writeUTF(msg);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *  Server -> Client 에게 MSG 전송하는 Thread 를 Inner Class 로 작성한다.
     *  ==> Inner Class 인 이유는 : Outer Class 맴버들을 자유롭게 사용하기 위해서
     */
    class ServerReceiver extends Thread {
        private final Socket socket;
        private DataInputStream dis;
        private DataOutputStream dos;

        /**
         *  생성자
         */
        public ServerReceiver(Socket socket) {
            this.socket = socket;
            try {
                dis = new DataInputStream(this.socket.getInputStream());
                dos = new DataOutputStream(this.socket.getOutputStream());
            } catch (Exception ignored) {}
        }

        @Override
        public void run() {
            String name="";    // 대화명이 저장될 변수 선언
            try {
                // 클라이언트가 연결 성공 시 첫번째 데이터를 '대화명'으로 서버로 전송
                // 서버에서 '대화명'을 받아 중복여부 판정 후 결과를 클라이언트에게 전송
                while (true) {
                    name = dis.readUTF();       // 클라이언트가 보낸 '대화명'
                    if (clientMap.containsKey(name)) {
                        dos.writeUTF("대화명 중복");
                    } else {
                        dos.writeUTF("대화명 YES!");
                        break;
                    }
                }   // while 문 종료

                // 접속한 사람의 '대화명'을 이용해 접속해 있던 사용자에게 전송
                sendToAll("["+name+"]님이 대화방에 입장했습니다.");

                // '대화명'과 접속한 Socket 객체를 Map 에 추가
                clientMap.put(name, socket);

                System.out.println("현재 접속자 수 : "+clientMap.size()+"명\n");

                // 한명의 클라이언트가 보낸 메시지를 전체 클라이언트에게 보낸다.
                while (dis != null) {
                    sendToAll(dis.readUTF());
                }

            } catch (Exception ignored){
            } finally {
                sendToAll("["+name+"]님이 접속을 종료했습니다.");

                System.out.println("["+socket.getInetAddress()
                        + " : "+socket.getPort()+"]에서 접속을 종료했습니다.");
                System.out.println("현재 접속자 수 : "+clientMap.size()+"명\n");

                // 클라이언트가 종료되면 Map 에서 해당 클라이언트를 삭제한다.
                if (!name.equals("")) {
                    clientMap.remove(name);
                }
            }
        }
    }
}














