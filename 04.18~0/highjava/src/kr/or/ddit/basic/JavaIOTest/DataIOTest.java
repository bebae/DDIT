package kr.or.ddit.basic.JavaIOTest;

import java.io.*;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DataIOTest {
    public static void main(String[] args) throws Exception {
        FileOutputStream fout = new FileOutputStream("D:/D_Other/test.txt");

        DataOutputStream dout = new DataOutputStream(fout);
        
        dout.writeInt(200);
        dout.writeFloat(123.45f);
        dout.writeBoolean(true);
        dout.writeUTF("ABCDabcd");

        System.out.println("출력 끝");

        dout.close();
        fout.close();

        //==========================================================

        // 출력 자료 읽어 오기
        DataInputStream din = new DataInputStream(Files.newInputStream(Paths.get("D:/D_Other/test.txt")));

        // 데이터 자료형을 맞춰서 읽어야한다
        System.out.println("int : " + din.readInt());
        System.out.println("float : " + din.readFloat());
        System.out.println("boolean : " + din.readBoolean());
        System.out.println("String : " + din.readUTF());

        din.close();

        //==========================================================

    }
}
