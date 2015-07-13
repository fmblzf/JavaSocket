/**
 * Project Name:ImmioSocket
 * File Name:ServerThread.java
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
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * ClassName:ServerThread ().<br/>
 * Date: 2015年7月8日 <br/>
 * 
 * @author zhaofeng
 * @version
 * @see
 */
public class ServerThread extends Thread {

	private Socket socket;

	public ServerThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		InputStream is = null;
		InputStreamReader irs = null;
		BufferedReader br = null;
		OutputStream os = null;
		PrintWriter pw = null;
		try {
			//输入流
			is = socket.getInputStream();
			irs = new InputStreamReader(is,"utf-8");
			br = new BufferedReader(irs);
			String acceptString = "";
			while(!socket.isClosed()){
				String str = br.readLine();
				if(str == null || "".equals(str) || "end".equals(str)){
					break;
				}
				acceptString += str;
			}
			System.out.println(acceptString);
			//输出流
			os = socket.getOutputStream();
			pw = new PrintWriter(new OutputStreamWriter(os,"utf-8"));
			pw.write("服务器端返回的消息："+UtilTools.formatString(acceptString));
			pw.flush();
		} catch (Exception e) {
			
		}finally{
			try {
				if(is != null)
					is.close();
				if(irs != null)
					irs.close();
				if(br!=null)
					br.close();
				if(os != null)
					os.close();
				if(pw !=null)
					pw.close();
				if(socket != null)
					socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
		}

	}
}
