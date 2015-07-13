/**
 * Project Name:ImmioSocket
 * File Name:Server.java
 * Package Name:cn.immio.com
 * Date:2015��7��8��
 * Copyright (c) 2015, zhaofeng@ushayden.com All Rights Reserved.
 *
 */

package cn.immio.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ClassName:Server ().<br/>
 * Date: 2015��7��8�� <br/>
 * 
 * @author zhaofeng
 * @version
 * @see
 */
public class Server {

	public static void main(String[] args) {
		beginListener();
	}
	static int count = 0;
	private static void beginListener() {
		ServerSocket server = null;
		try {
			System.out.println("*****�����������������ȴ��ͻ�������...*****");
			server = new ServerSocket(12345);
		} catch (IOException e1) {
			
		}
		while (true) {
			try {
				Socket socket = server.accept();
				ServerThread mThread = new ServerThread(socket);
				mThread.start();
				count ++ ;
				System.out.println("��"+count+"���ͻ����ʷ�������");
			} catch (IOException e) {
				//
			}
		}
	}

}
