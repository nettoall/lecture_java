package basic.net.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpReceiveExample extends Thread{
    public static void main(String[] args) throws Exception{
        DatagramSocket datagramSocket = new DatagramSocket(5001);

        Thread thread = new Thread(){
            @Override
            public void run(){
                System.out.println("[수신 시작]");
                try{
                    while(true){
                        DatagramPacket datagramPacket = new DatagramPacket(new byte[100],100);
                        datagramSocket.receive(datagramPacket);

                        String data = new String(datagramPacket.getData(),0, datagramPacket.getLength(),"UTF-8");
                        System.out.println("[받은 내용: " + datagramPacket.getSocketAddress() +"]" + data);
                    }

                }catch(Exception e){
                    System.out.println("[수신 종료]");
                }
            }
        };
        thread.start();

        Thread.sleep(10000);
        datagramSocket.close();
    }

}
