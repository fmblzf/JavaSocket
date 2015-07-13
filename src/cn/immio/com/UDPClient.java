/**
 * Project Name:ImmioSocket
 * File Name:UDPClient.java
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
import java.net.UnknownHostException;

/**
 * ClassName:UDPClient ().<br/>
 * Date:     2015��7��8��  <br/>
 * @author   zhaofeng
 * @version  
 * @see 	 
 */
public class UDPClient {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/*
		 * ������Ϣ����������
		 */
		//1.������ַ���˿ںţ��Լ�����
		InetAddress address = InetAddress.getByName("localhost");
		int port = 9999;
		byte[] buf = "UDPClient���ӳɹ�����".getBytes();
		//2.�������ݱ�
		DatagramPacket dpt = new DatagramPacket(buf, buf.length, address, port);
		//3.����UDP socket
		DatagramSocket socket = new DatagramSocket();
		//4.���Ϳͻ�����Ϣ
		socket.send(dpt);
		
		/*
		 * ���շ������˷��ص�����Ϣ
		 */
		//1.�����������ݱ������ڽ��շ������˵���Ӧ���� 
		byte[] data  = new byte[1024];
		DatagramPacket packet = new DatagramPacket(data, data.length);
		//2.���շ������˵���Ӧ��Ϣ
		socket.receive(packet);
		//3.��ȡ����
		String str = new String(data, 0, packet.getLength());
		System.out.println("���յ��������˵���Ϣ��"+str);
		//4.�ر���Դ
		socket.close();
		
	}

}

