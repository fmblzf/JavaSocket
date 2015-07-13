/**
 * Project Name:ImmioSocket
 * File Name:UDPServer.java
 * Package Name:cn.immio.com
 * Date:2015年7月8日
 * Copyright (c) 2015, zhaofeng@ushayden.com All Rights Reserved.
 *
 */

package cn.immio.com;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * ClassName:UDPServer ().<br/>
 * Date: 2015年7月8日 <br/>
 * 
 * @author zhaofeng
 * @version
 * @see
 */
public class UDPServer {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/*
		 * 接收客户端的信息
		 */
		// 1.创建DatagramSocket
		DatagramSocket socket = new DatagramSocket(9999);
		System.out.println("*****服务器已经启动，等待客户端发送数据...*******");
		int count = 0 ;
		while (true) {//循环监听
			count ++ ;
			// 2.创建数据报
			byte[] buf = new byte[1024];
			DatagramPacket dpt = new DatagramPacket(buf, buf.length);
			// 3.接收客户端的消息,消息阻塞
			socket.receive(dpt);
			// 4.读取获取的客户端信息
			String str = new String(dpt.getData(), 0, dpt.getLength(),"utf-8");
			System.out.println("第"+count+"个客户访问服务器，获取的数据是：" + str);
			
			//监听到有客户端发送消息，启动线程并进行处理
			UDPServerThread mThread = new UDPServerThread(socket, dpt);
			//mThread.setPriority(4);// 设置线程优先级
			mThread.start();

		}

		/*
		 * 响应客户端
		 */
		// 1.获取客户端的地址，端口，设置发送的消息
		// InetAddress address = dpt.getAddress();
		// int port = dpt.getPort();
		// byte[] data = "欢迎连接服务器！！！".getBytes();
		// // 2.创建数据报
		// DatagramPacket dp = new DatagramPacket(data, data.length, address,
		// port);
		// // 3.发送消息给客户端
		// socket.send(dp);
		// //4.关闭资源
		// socket.close();

	}

}
