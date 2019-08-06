package com.edith.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

/**
 * @ProjectName: socket
 * @ClassName: EdithServerSocket
 * @Description: Socket 服务端
 * @Author: Edith
 * @Date: 2019/8/5 21:36
 * @Version: 1.0
 */
public class EdithServerSocket extends Thread{
    private ServerSocket ss ;
    public EdithServerSocket(int port) throws IOException{
        ss = new ServerSocket(port);
        ss.setSoTimeout(10000);
    }
    @Override
    public void run() {
        while (true){
            System.out.println("端口名："+ ss.getLocalPort() +"ip地址："+ ss.getInetAddress());
            try {
                Socket sc = ss.accept();
                System.out.println("客户端IP："+ sc.getInetAddress() + "客户端端口："+ sc.getPort());
                DataInputStream in = new DataInputStream(sc.getInputStream());
                System.out.println("客户端说："+ in.readUTF());
                DataOutputStream out = new DataOutputStream(sc.getOutputStream());
                out.writeUTF("客户端你好，已经收到你的信息！");
                out.close();
                in.close();
                sc.close();
            }  catch (SocketTimeoutException e){
                e.printStackTrace();
                break;
            }  catch(IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }

        public static void main(String[] args){
            try {

                EdithServerSocket es = new EdithServerSocket(8890);
                es.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}
