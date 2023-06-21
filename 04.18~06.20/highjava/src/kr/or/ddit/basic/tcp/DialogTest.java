package kr.or.ddit.basic.tcp;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;

/**
 *  SWING 으로 파일 열기, 저장 창 연습
 */
public class DialogTest {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();

        // 선택할 파일의 확장자 설정
        FileNameExtensionFilter txt = new FileNameExtensionFilter("Text File(*.txt)", "txt");
        FileNameExtensionFilter pdf = new FileNameExtensionFilter("PDF File(*.pdf)", "pdf");
        FileNameExtensionFilter img = new FileNameExtensionFilter("IMG File", "jpg","png","gif");
        FileNameExtensionFilter doc = new FileNameExtensionFilter("DOC File", "doc","docx");

        fileChooser.addChoosableFileFilter(txt);
        fileChooser.addChoosableFileFilter(pdf);
        fileChooser.addChoosableFileFilter(img);
        fileChooser.addChoosableFileFilter(doc);

        fileChooser.setFileFilter(img); // 확장자 목록 중 기본 확장자

        fileChooser.setAcceptAllFileFilterUsed(true);

        // 창 열기
        int result = fileChooser.showOpenDialog(new Panel());   // 열기용 창

        if (result == JFileChooser.APPROVE_OPTION) {
            System.out.println("File : " + fileChooser.getSelectedFile());
        }


    }
}
