/**
 * Project Name:ImmioSocket
 * File Name:FileServer.java
 * Package Name:cn.immio.com.file
 * Date:2015年7月9日
 * Copyright (c) 2015, zhaofeng@ushayden.com All Rights Reserved.
 *
 */

package cn.immio.com.file;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.zip.ZipInputStream;

/**
 * ClassName:FileServer ().<br/>
 * Date: 2015年7月9日 <br/>
 * 
 * @author zhaofeng
 * @version
 * @see
 */
public class FileServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String filePath = "G:" + File.separator + "Program Files"
					+ File.separator + "work" + File.separator + "plugin"
					+ File.separator + "ImmioSocket" + File.separator + "doc"
					+ File.separator + "ceshi.rar";
			// String filePath =
			// File.separator+"doc"+File.separator+"ceshi.txt";
			ServerSocket server = new ServerSocket(8888);

			System.out.println("****服务器已经启动，等待客户端连接...****");
			while (true) {
				Socket socket = server.accept();

				File file = new File(filePath);
				if (!file.exists()) {
					file.createNewFile();
				}

				FileOutputStream fos = new FileOutputStream(file);
				
				ZipInputStream dis = new ZipInputStream(
						socket.getInputStream());

				byte[] bytes = new byte[1024 * 12];
				int len = 0;
				while ((len = dis.read(bytes, 0, bytes.length)) > 0) {
					fos.write(bytes, 0, bytes.length);
					fos.flush();
				}
				System.out.println("输出文件成功！");
				socket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();

		}

	}

}
