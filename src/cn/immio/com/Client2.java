/**
 * Project Name:ImmioSocket
 * File Name:Client2.java
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
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * ClassName:Client2 ().<br/>
 * Date:     2015年7月8日  <br/>
 * @author   zhaofeng
 * @version  
 * @see 	 
 */
public class Client2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		requestServer("client2连接成功！");
	}
	
	private static void requestServer(String message){
		try {
			Socket socket = new Socket("127.0.0.1", 9999);
			
			//输入流处理
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			pw.write(message);
			pw.write("\r\n");
			pw.write("end");
			pw.write("\r\n");
			pw.flush();
			
			String serverMsg = "";
			
			while(!socket.isClosed()){
				String str = br.readLine();
				if(str == null || "end".equals(str)){
					break;
				}
				serverMsg += str;
			}
			System.out.println(serverMsg);	
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}


}

