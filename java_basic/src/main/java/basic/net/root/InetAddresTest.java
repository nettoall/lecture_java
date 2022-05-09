package basic.net.root;

import java.net.InetAddress;

public class InetAddresTest {
    public static void main(String[] args) throws Exception {
        InetAddress inetAddress = InetAddress.getLocalHost();
        // ip 주소
        System.out.println(inetAddress.getHostAddress());
        // 호스트명
        System.out.println(inetAddress.getHostName());
        // 호스트명
        System.out.println(inetAddress.getCanonicalHostName());

        byte[] rawIp = inetAddress.getAddress();

        for(byte b:rawIp) {
            System.out.print(b);
        }

        InetAddress test1 = InetAddress.getByName("www.naver.com");



    }
}
