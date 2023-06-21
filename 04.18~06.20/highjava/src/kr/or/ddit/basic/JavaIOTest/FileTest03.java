package kr.or.ddit.basic.JavaIOTest;

import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Objects;

public class FileTest03 {
    public static void main(String[] args) {
        FileTest03 test = new FileTest03();
        File file = new File("d:");
        test.displayFileList(file);

    }

    /**
     *  디렉토리 정보를 가진 file 객체를 받아 해당 리렉토리에 모든 파일,디렉토릭 출력
     * @param dir File
     */
    public void displayFileList(File dir) {
        if(!dir.isDirectory()) {
            System.out.println("디렉토리(폴더)만 가능합니다");
            return;
        }
        System.out.println("[" + dir.getAbsolutePath() + "] 디렉토리 내용");

        File[] files = dir.listFiles();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH:mm");

        // 가져온 파일과 디렉토리 목록 만큼 반본
        for(File file : Objects.requireNonNull(files)) {
            String fileName = file.getName();
            String attr = "";   // 파일 속성
            String size = "";   // 파일 크기
            String date = sdf.format(new Date(file.lastModified()));

            if (!dir.isDirectory()) {
                attr = "<DIR>";
            } else {
                size = String.valueOf(file.length());
                attr = file.canRead() ? "R" : "";
                attr += file.canWrite() ? "W" : "";
                attr += file.isHidden() ? "H" : "";
            }
            System.out.printf("%12s %10s %10s %s\n", date, attr, size, fileName);

        }

    }
}
