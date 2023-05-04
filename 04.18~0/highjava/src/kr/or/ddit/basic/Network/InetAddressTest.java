package kr.or.ddit.basic.Network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
    public static void main(String[] args) throws UnknownHostException {

        // www.naver.com의 IP 정보 가져오기
        InetAddress  ip = InetAddress.getByName("www.naver.com");
        System.out.println("HostName : " + ip.getHostName());
        System.out.println("HostAddress : " + ip.getHostAddress());
        System.out.println("toString() : " + ip.toString());
        System.out.println();

        // 자신의 컴퓨터의 IP 정보 가져오기
        InetAddress localIP = InetAddress.getLocalHost();
        System.out.println("local HostName : " + localIP.getHostName());
        System.out.println("local HostAddress : " + localIP.getHostAddress());
        System.out.println();

        InetAddress[] naverIPs = InetAddress.getAllByName("www.naver.com");
        for(InetAddress naverIP : naverIPs) {
            System.out.println(naverIP.toString());
        }

    }
}
