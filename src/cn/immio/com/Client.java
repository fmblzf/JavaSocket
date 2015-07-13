/**
 * Project Name:ImmioSocket
 * File Name:Client.java
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
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * ClassName:Client ().<br/>
 * Date:     2015��7��8��  <br/>
 * @author   zhaofeng
 * @version  
 * @see 	 
 */
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		requestServer("client���ӳɹ���");
	}
	
	private static void requestServer(String message){
		try {
			Socket socket = new Socket("localhost", 9999);
			//��������˷�����Ϣ
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			pw.write(message);
			pw.write("\r\n");
			pw.write("end");
			pw.write("\r\n");
			pw.flush();
			socket.isOutputShutdown();
			
			//���շ������˵ķ�����Ϣ
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			
			String serverMsg = "";
			while(!socket.isClosed()){
				String str = br.readLine();
				if(str == null || "end".equals(str)){
					break;
				}
				serverMsg += str;
			}
			System.out.println(serverMsg);	
			socket.isInputShutdown();
			
			pw.close();
			is.close();
			isr.close();
			br.close();
			socket.close();
			
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}

}
