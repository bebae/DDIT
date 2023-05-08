package kr.or.ddit.basic.tcp;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * 이 클래스는 소켓을 통해서 메시지를 보내는 역할을 담당하는 스레드
 */
public class Sender extends Thread {
    private Socket socket;
    private DataOutputStream dos;
    private String name;
    private Scanner scan;


    public Sender(Socket socket) {
        this.socket = socket;
        scan = new Scanner(System.in);
        System.out.print("이름 입력 >> ");
        name = scan.nextLine();
        try {
            dos = new DataOutputStream(socket.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        // 메시지를 Scanner 로 입력 받아 상대방에게 보낸다.
        while(dos != null) {
            try {
                dos.writeUTF(name + " >>> " + scan.nextLine());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
