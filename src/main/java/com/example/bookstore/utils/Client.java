package com.example.bookstore.utils;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public String getClient(String str) throws IOException {
        InetAddress addr = InetAddress.getByName(null);//本机地址对象。
        System.out.println("addr = " + addr);
        //通过创建通信套接字，连接服务器，
        Socket socket = new Socket(addr, Server_Socket.PORT);
        try {
            System.out.println("socket = " + socket.toString());
            //用到了装饰器模式，每封装一层，功能强大一点
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            socket.getInputStream()));//最小单位是字节
            //用到了装饰器模式，每封装一层，功能强大一点
            PrintWriter out = new PrintWriter(new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream())), true);
            //用到了装饰器模式，每封装一层，功能强大一点
                String userinput = str;
                out.println(userinput+"输入");
                //获取服务器传输过来的内容
                String strs = in.readLine();//阻塞调用
                System.out.println(strs);
                out.println("END");
        } finally {
            System.out.println("closing...");
            //socket.close();
        }
        return str;
    }
}
