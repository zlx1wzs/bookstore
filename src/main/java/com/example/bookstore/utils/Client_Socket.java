package com.example.bookstore.utils;


import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client_Socket {
	public static void main(String[] args) throws IOException {
		//�������ĵ�ַ����
		InetAddress addr = InetAddress.getByName(null);//������ַ����
		System.out.println("addr = " + addr);
		//ͨ������ͨ���׽��֣����ӷ�������
		Socket socket = new Socket(addr, Server_Socket.PORT);
		try {
			System.out.println("socket = " + socket.toString());
			//�õ���װ����ģʽ��ÿ��װһ�㣬����ǿ��һ��
			BufferedReader in = new BufferedReader(
					new InputStreamReader(
					socket.getInputStream()));//��С��λ���ֽ�
			//�õ���װ����ģʽ��ÿ��װһ�㣬����ǿ��һ��
			PrintWriter out = new PrintWriter(new BufferedWriter(
					new OutputStreamWriter(socket.getOutputStream())), true);
			//�õ���װ����ģʽ��ÿ��װһ�㣬����ǿ��һ��
			Scanner scan = new Scanner(System.in);
			for (int i = 0; i < 10; i++) {
				String userinput = scan.nextLine();
			
				out.println(userinput+"u");
				//��ȡ�������������������
				String str = in.readLine();//��������
				System.out.println(str);
			}
			out.println("END");
		} finally {
			System.out.println("closing...");
			socket.close();
		}
	}
}