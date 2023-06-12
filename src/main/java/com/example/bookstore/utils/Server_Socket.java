package com.example.bookstore.utils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_Socket {
	public static final int PORT = 8083;

	public static void main(String[] args) throws IOException {
		//服务器套接字，作用是监听客户的请求
		ServerSocket s = new ServerSocket(PORT);
		System.out.println("Started: " + s);
		try {
			while(true){
			//用来通信的套接字
			Socket socket = s.accept();//监听客户的连接请求，如果没有请求到来，会一直阻塞

			try {
				System.out.println("Connection accepted: " + socket);

				//装饰器模式
				BufferedReader in = new BufferedReader( //带缓冲，提供通信的效率
						new InputStreamReader( //字符流
						socket.getInputStream())); //字节流  从网络输入。从网卡输入，来自客户端。

				PrintWriter out = new PrintWriter(new BufferedWriter(
						new OutputStreamWriter(socket.getOutputStream())), true);
				while (true) {
					String str = in.readLine();//阻塞调用
					if (str.equals("END"))
						break;
					System.out.println("Echoing: " + str);
					out.println(str + str + " haha");
				}
			} finally {
				System.out.println("closing...");
				//socket.close();
			}}
		} finally {
			s.close();
		}
	}
}