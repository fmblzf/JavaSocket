/**
 * Project Name:ImmioSocket
 * File Name:UDPServerThread.java
 * Package Name:cn.immio.com
 * Date:2015��7��9��
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
 * Date: 2015��7��9�� <br/>
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
		 * ��Ӧ�ͻ���
		 */
		// 1.��ȡ�ͻ��˵ĵ�ַ���˿ڣ����÷��͵���Ϣ
		InetAddress address = dpt.getAddress();
		int port = dpt.getPort();
		byte[] data = null;
		try {
			data = "��ӭ���ӷ�����������".getBytes("utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		}
		data = byteMerger(data,dpt.getData());
		// 2.�������ݱ�
		DatagramPacket dp = new DatagramPacket(data, data.length, address, port);
		try {
			// 3.������Ϣ���ͻ���
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
