package kr.or.ddit.basic.JavaIOTest;

import java.io.*;

public class BufferedIOTest01 {
    public static void main(String[] args) throws Exception {

        FileOutputStream fout = new FileOutputStream("d:/D_Other/bufferTest.txt");

        BufferedOutputStream bout = new BufferedOutputStream(fout,5);
        
        for(int i = '1'; i <= '9'; i++){
            bout.write(i);
        }
        bout.flush();
        bout.close();
        System.out.println("작업 끝");

        FileReader fr = new FileReader("d:/D_Other/bufferTest.txt");
        int c;
        while ((c = fr.read()) != -1) {
            System.out.print((char) c);
        }
        fr.close();
    }
}
