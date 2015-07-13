/**
 * Project Name:ImmioSocket
 * File Name:FileClient.java
 * Package Name:cn.immio.com.file
 * Date:2015年7月9日
 * Copyright (c) 2015, zhaofeng@ushayden.com All Rights Reserved.
 *
*/

package cn.immio.com.file;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * ClassName:FileClient ().<br/>
 * Date:     2015年7月9日  <br/>
 * @author   zhaofeng
 * @version  
 * @see 	 
 */
public class FileClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filePath = "G:"+File.separator+"Program Files"+File.separator+"work"+File.separator+"plugin"+File.separator+"ImmioSocket"+File.separator+"doc"+File.separator+"tt.txt";
		
		try {
			Socket socket = new Socket("localhost", 8888);
			
			File file = new File(filePath);
			FileInputStream fis = new FileInputStream(file);
			
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			
			byte[] bytes = new byte[1024*12];
			int len = 0;
			int count = 0;
			while((len = fis.read(bytes,0, bytes.length))>0){
				dos.write(bytes, 0, bytes.length);
				dos.flush();
				count += len;
				System.out.println("上传..."+(count*100/file.length())+"%");
			}
			System.out.println("上传文件成功！");
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

