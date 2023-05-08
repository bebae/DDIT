package kr.or.ddit.basic.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TcpFileServer {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(7777);
        System.out.println("서버가 준비되었습니다.");

        Socket socket = server.accept();
        System.out.println("클라이언트와 연결되었습니다.");

        // 파일명 수신
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        String fileName = dis.readUTF();

        InputStream is = socket.getInputStream();
        BufferedInputStream bis = new BufferedInputStream(is);

        // 경로에 디렉토리가 없다면 생성
        Path dirPath = Paths.get("d:/d_other/uploadFiles/");
        if (!Files.exists(dirPath)) {
            Files.createDirectories(dirPath);
        }

        // 소켓으로 읽어 파일 생성
        File file = new File("d:/d_other/uploadFiles/" + fileName);
        OutputStream os = Files.newOutputStream(file.toPath());
        BufferedOutputStream bos = new BufferedOutputStream(os);

        byte[] buf = new byte[1024];
        int len;
        while((len = bis.read(buf)) != -1) {
            bos.write(buf, 0, len);
        }

        System.out.println("파일 수신이 완료되었습니다.");
        bis.close();
        socket.close();
        server.close();
    }
}
