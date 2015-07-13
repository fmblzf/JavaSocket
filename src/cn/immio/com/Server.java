/**
 * Project Name:ImmioSocket
 * File Name:Server.java
 * Package Name:cn.immio.com
 * Date:2015年7月8日
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
 * Date: 2015年7月8日 <br/>
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
			System.out.println("*****启动服务器监听，等待客户端连接...*****");
			server = new ServerSocket(12345);
		} catch (IOException e1) {
			
		}
		while (true) {
			try {
				Socket socket = server.accept();
				ServerThread mThread = new ServerThread(socket);
				mThread.start();
				count ++ ;
				System.out.println("第"+count+"个客户访问服务器！");
			} catch (IOException e) {
				//
			}
		}
	}

}
