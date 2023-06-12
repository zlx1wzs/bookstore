package com.example.bookstore.utils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_Socket {
	public static final int PORT = 8083;

	public static void main(String[] args) throws IOException {
		//�������׽��֣������Ǽ����ͻ�������
		ServerSocket s = new ServerSocket(PORT);
		System.out.println("Started: " + s);
		try {
			while(true){
			//����ͨ�ŵ��׽���
			Socket socket = s.accept();//�����ͻ��������������û������������һֱ����

			try {
				System.out.println("Connection accepted: " + socket);

				//װ����ģʽ
				BufferedReader in = new BufferedReader( //�����壬�ṩͨ�ŵ�Ч��
						new InputStreamReader( //�ַ���
						socket.getInputStream())); //�ֽ���  ���������롣���������룬���Կͻ��ˡ�

				PrintWriter out = new PrintWriter(new BufferedWriter(
						new OutputStreamWriter(socket.getOutputStream())), true);
				while (true) {
					String str = in.readLine();//��������
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