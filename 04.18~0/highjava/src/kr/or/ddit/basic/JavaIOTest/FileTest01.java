package kr.or.ddit.basic.JavaIOTest;

import java.io.File;

public class FileTest01 {
    public static void main(String[] args) {
        File file1 = new File("d:/d_other/test.txt");
        File file0 = new File("d:\\d_other\\test.txt");

        FileTest01 test = new FileTest01();
        test.FilePrint(file1);
        test.FilePrint(file0);

        File file2 = new File("d:/d_other");
        test.FilePrint(file2);

        // ==> file2 디렉토리 안에 있는 "test.txt" 파일 정보를 갖는 파일 객체가 생성된다.
        File file3 = new File(file2,"test.txt");
        test.FilePrint(file3);

        File file4 = new File("d:/d_other/","test.txt");
        test.FilePrint(file4);

        // 디렉토리 만들기
        // mkdir 반환값 boolean 타입
        // exists() 메소드 ==> 해당 경로에 파일이나 디렉토리가 있다면 boolean 반환
        File file5 = new File("d:/d_other/test-dir");
        if (!file5.exists()){
            if (file5.mkdir()) {
                System.out.println(file5.getName()+" mkdir 성공!");
            } else {
                System.out.println(file5.getName()+" mkdir 실패!");
            }
        } else {
            System.out.println(file5.getName()+"은 이미 존재합니다.");
        }





    }

    /**
     * 파일 객체를 주면 파일 관련된 정보를 출력합니다.
     * @param file File
     */
    public void FilePrint(File file){
        System.out.println("파일명              : "+file.getName());
        System.out.println("파일 여부           : "+file.isFile());
        System.out.println("디렉토리(폴더) 여부 : "+file.isDirectory());
        System.out.println("path : "+file.getPath());
        System.out.println("=====================================");
    }
}
