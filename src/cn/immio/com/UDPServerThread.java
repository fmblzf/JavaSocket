/**
 * Project Name:ImmioSocket
 * File Name:UDPServerThread.java
 * Package Name:cn.immio.com
 * Date:2015年7月9日
 * Copyright (c) 2015, zhaofeng@ushayden.com All Rights Reserved.
 *
 */

package cn.immio.com;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * ClassName:UDPServerThread ().<br/>
 * Date: 2015年7月9日 <br/>
 * 
 * @author zhaofeng
 * @version
 * @see
 */
public class UDPServerThread extends Thread {

	private DatagramSocket socket;
	private DatagramPacket dpt;

	public UDPServerThread(DatagramSocket socket,DatagramPacket dpt) {
		this.socket = socket;
		this.dpt = dpt;
	}

	@Override
	public void run() {
		/*
		 * 响应客户端
		 */
		// 1.获取客户端的地址，端口，设置发送的消息
		InetAddress address = dpt.getAddress();
		int port = dpt.getPort();
		byte[] data = null;
		try {
			data = "欢迎连接服务器！！！".getBytes("utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		}
		data = byteMerger(data,dpt.getData());
		// 2.创建数据报
		DatagramPacket dp = new DatagramPacket(data, data.length, address, port);
		try {
			// 3.发送消息给客户端
			socket.send(dp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}
	
	public static byte[] byteMerger(byte[] byte_1, byte[] byte_2){  
        byte[] byte_3 = new byte[byte_1.length+byte_2.length];  
        System.arraycopy(byte_1, 0, byte_3, 0, byte_1.length);  
        System.arraycopy(byte_2, 0, byte_3, byte_1.length, byte_2.length);  
        return byte_3;  
    }  
}
