/**
 * Project Name:ImmioSocket
 * File Name:UDPServer.java
 * Package Name:cn.immio.com
 * Date:2015��7��8��
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
 * Date: 2015��7��8�� <br/>
 * 
 * @author zhaofeng
 * @version
 * @see
 */
public class UDPServer {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/*
		 * ���տͻ��˵���Ϣ
		 */
		// 1.����DatagramSocket
		DatagramSocket socket = new DatagramSocket(9999);
		System.out.println("*****�������Ѿ��������ȴ��ͻ��˷�������...*******");
		int count = 0 ;
		while (true) {//ѭ������
			count ++ ;
			// 2.�������ݱ�
			byte[] buf = new byte[1024];
			DatagramPacket dpt = new DatagramPacket(buf, buf.length);
			// 3.���տͻ��˵���Ϣ,��Ϣ����
			socket.receive(dpt);
			// 4.��ȡ��ȡ�Ŀͻ�����Ϣ
			String str = new String(dpt.getData(), 0, dpt.getLength(),"utf-8");
			System.out.println("��"+count+"���ͻ����ʷ���������ȡ�������ǣ�" + str);
			
			//�������пͻ��˷�����Ϣ�������̲߳����д���
			UDPServerThread mThread = new UDPServerThread(socket, dpt);
			//mThread.setPriority(4);// �����߳����ȼ�
			mThread.start();

		}

		/*
		 * ��Ӧ�ͻ���
		 */
		// 1.��ȡ�ͻ��˵ĵ�ַ���˿ڣ����÷��͵���Ϣ
		// InetAddress address = dpt.getAddress();
		// int port = dpt.getPort();
		// byte[] data = "��ӭ���ӷ�����������".getBytes();
		// // 2.�������ݱ�
		// DatagramPacket dp = new DatagramPacket(data, data.length, address,
		// port);
		// // 3.������Ϣ���ͻ���
		// socket.send(dp);
		// //4.�ر���Դ
		// socket.close();

	}

}
