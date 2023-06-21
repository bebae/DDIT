package kr.or.ddit.basic.JavaIOTest;

import java.io.File;

public class FileTest02 {
    public static void main(String[] args) {
        FileTest02 ft = new FileTest02();

        File f1 = new File("d:/d_other/test.txt");

        System.out.println(f1.getName()+" 파일의 크기 : "+f1.length()+"bytes");
        System.out.println("path : "+f1.getPath());
        System.out.println("absolute path : "+f1.getAbsolutePath());

        // java 프로그램을 실행하면 현재 프로젝트 폴더 위치가 현재위치가 됨
        File f2 = new File(".");
        System.out.println("path : "+f2.getPath());
        System.out.println("absolute path : "+f2.getAbsolutePath());
        System.out.println("===============================================");

        File f3 = new File("d:/d_other/sample.exe");

        ft.FileCheck(f1);
        ft.FileCheck(f2);
        ft.FileCheck(f3);

    }

    public void FileCheck(File f) {
        if(f.isFile()){
            System.out.println(f.getName()+"은 파일입니다.");
        } else if(f.isDirectory()) {
            System.out.println(f.getName()+"은 디렉토리 입니다.");
        } else {
            System.out.println(f.getName()+"은 아무것도 아닌 입니다.");
        }
    }
}
