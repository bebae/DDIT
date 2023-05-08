package kr.or.ddit.basic.tcp;

import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TcpFileClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 7777);
        System.out.println("서버에 연결되었습니다.");

        // 파일 객체 생성
        File file = new File("d:/D_Other/펭귄.jpg");
        // 파일명 추출하여 전송
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        dos.writeUTF(file.getName());

        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());

        // 파일 읽고 소켓으로 출력
        InputStream  is = Files.newInputStream(file.toPath());
        BufferedInputStream bis = new BufferedInputStream(is);

        byte[] temp = new byte[1024];
        int len;
        while((len = bis.read(temp)) != -1){
            bos.write(temp, 0, len);
        }
        bos.flush();
        System.out.println("파일 전송이 완료되었습니다.");

        bis.close();
        bos.close();
        socket.close();
    }
}
