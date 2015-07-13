/**
 * Project Name:ImmioSocket
 * File Name:ObjectClient.java
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
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * ClassName:ObjectClient ().<br/>
 * Date:     2015年7月9日  <br/>
 * @author   zhaofeng
 * @version  
 * @see 	 
 */
public class ObjectClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Person p = new Person();
			p.setName("admin");
			p.setPassword("123456");
			//连接服务器，创建socket
			Socket socket = new Socket("localhost", 12345);
			
			//输出流
			OutputStream os = socket.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);
			oos.writeObject(p);
			oos.flush();
			
			//输入流
			InputStream is = socket.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);
			Person oisPerson = (Person)ois.readObject();
			System.out.print("客户端验证通过的人员信息"+oisPerson.toString());
			
			
			socket.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("UnknownHostException："+e.getMessage());
			
		}catch (ClassNotFoundException e) {
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

