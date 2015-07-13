/**
 * Project Name:ImmioSocket
 * File Name:UDPClient.java
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
import java.net.UnknownHostException;

/**
 * ClassName:UDPClient ().<br/>
 * Date:     2015年7月8日  <br/>
 * @author   zhaofeng
 * @version  
 * @see 	 
 */
public class UDPClient {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/*
		 * 发送信息给服务器端
		 */
		//1.创建地址，端口号，以及数据
		InetAddress address = InetAddress.getByName("localhost");
		int port = 9999;
		byte[] buf = "UDPClient连接成功！！".getBytes();
		//2.床架数据报
		DatagramPacket dpt = new DatagramPacket(buf, buf.length, address, port);
		//3.创建UDP socket
		DatagramSocket socket = new DatagramSocket();
		//4.发送客户端消息
		socket.send(dpt);
		
		/*
		 * 接收服务器端返回到额信息
		 */
		//1.创建创建数据报，用于接收服务器端的响应数据 
		byte[] data  = new byte[1024];
		DatagramPacket packet = new DatagramPacket(data, data.length);
		//2.接收服务器端的响应消息
		socket.receive(packet);
		//3.读取数据
		String str = new String(data, 0, packet.getLength());
		System.out.println("接收到服务器端的消息："+str);
		//4.关闭资源
		socket.close();
		
	}

}

