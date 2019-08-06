package com.edith.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @ProjectName: socket
 * @ClassName: EdithClientSocket
 * @Description: socket 客服端
 * @Author: Edith
 * @Date: 2019/8/5 21:36
 * @Version: 1.0
 */
public class EdithClientSocket {
    public static void main(String[] args){
        try {
            Socket s = new Socket("localhost",8890);
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            out.writeUTF("客户端请求连接服务器。。");
            DataInputStream in = new DataInputStream(s.getInputStream());
            System.out.println("服务器说："+ in.readUTF());
            out.close();
            in.close();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
