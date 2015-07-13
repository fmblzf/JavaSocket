/**
 * Project Name:ImmioSocket
 * File Name:ObjectServer.java
 * Package Name:cn.immio.com
 * Date:2015年7月9日
 * Copyright (c) 2015, zhaofeng@ushayden.com All Rights Reserved.
 *
 */

package cn.immio.com.obj;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ClassName:ObjectServer ().<br/>
 * Date: 2015年7月9日 <br/>
 * 
 * @author zhaofeng
 * @version
 * @see
 */
public class ObjectServer {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		try {
			ServerSocket server = new ServerSocket(12345);

			System.out.println("****服务器已经启动，等待客户端连接...****");
			Socket socket = server.accept();
			
			// 输入流
			InputStream is = socket.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);
			Person oisPerson = (Person) ois.readObject();
			System.out.println("服务器端查到的人员信息："+oisPerson.toString());
			oisPerson.setId(3);

			// 输出流
			OutputStream os = socket.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);
			oos.writeObject(oisPerson);
			oos.flush();
			
			socket.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ClassNotFoundException："+e.getMessage());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("IOException："+e.getMessage());
			
		}
	}

}
