package kr.or.ddit.basic.tcp;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TcpFileClient {
    public static void main(String[] args) throws IOException {
        TcpFileClient client = new TcpFileClient();

        // 파일 객체 생성
//        File file = new File("d:/D_Other/펭귄.jpg");
        File file = client.ShowDialog("OPEN");

        if(file == null) {
            System.out.println("전송할 파일이 선택되지 않았습니다.");
            return;
        }

        Socket socket = new Socket("localhost", 7777);
        System.out.println("서버에 연결되었습니다.");

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

    /**
     * Dialog 창을 열고 선택한 파일을 반환하는 메소드
     * @param option Save, Open
     * @return
     */
    private File ShowDialog(String option) {
        JFileChooser fileChooser = new JFileChooser();

        // 선택할 파일의 확장자 설정
        FileNameExtensionFilter img = new FileNameExtensionFilter("IMG File", "jpg","png","gif");

        fileChooser.addChoosableFileFilter(img);

        fileChooser.setFileFilter(img); // 확장자 목록 중 기본 확장자

        fileChooser.setAcceptAllFileFilterUsed(true);

        // Dialog 창 기본 경로 설정
        fileChooser.setCurrentDirectory(new File("d:/D_Other"));

        int result = -1;
        // 창 열기
        if("SAVE".equalsIgnoreCase(option)){
            result = fileChooser.showSaveDialog(new Panel());   // 저장용 창
        } else if("OPEN".equalsIgnoreCase(option)) {
            result = fileChooser.showOpenDialog(new Panel());   // 열기용 창
        }

        if (result == JFileChooser.APPROVE_OPTION) {
            System.out.println("File : " + fileChooser.getSelectedFile());
            return fileChooser.getSelectedFile();
        }

        return null;
    }
}
