package com.java.exer;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import org.junit.Test;
/*
 * 客户端向服务端发送一个文本，服务端将文本转换为大写返回给客户端
 */
public class TestTCP {
	@Test
	public void client(){
		//1.创建一个Sockeet
		Socket socket=null;
		OutputStream os=null;
		FileInputStream fis=null;
		InputStream is=null;
		FileOutputStream fos=null;
		try {
			socket = new Socket(InetAddress.getByName("127.0.0.1"), 9991);
			os = socket.getOutputStream();
			fis = new FileInputStream(new File("test.log"));
			byte[]b=new byte[10];
			int len;
			while((len=fis.read(b))!=-1){
				os.write(b);
			}
			socket.shutdownOutput();
			is = socket.getInputStream();
			fos = new FileOutputStream(new File("test2.log"));
			//StringBuffer sb=new StringBuffer();
			byte[]b1=new byte[20];
			int len2;
			while((len2=is.read(b1))!=-1){
				fos.write(b1, 0, len2);
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(fos!=null){
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(fis!=null){
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(is!=null){
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(os!=null){
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(socket!=null){
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
		
		
		
		
		
	}
	@Test
	public void server(){
		ServerSocket ssk=null;
		Socket sk=null;
		InputStream is=null;
		OutputStream os=null;
		try {
			ssk = new ServerSocket(9991);
			sk = ssk.accept();
			is = sk.getInputStream();
			byte[]b=new byte[10];
			int len;
			StringBuffer sb=new StringBuffer();
			while((len=is.read(b))!=-1){
				String str=new String(b,0,len);
				sb.append(str);
			}
			String str=sb.toString().toUpperCase();
			System.out.println(str);
			os = sk.getOutputStream();
			os.write(str.getBytes());
			sk.shutdownOutput();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(os!=null){
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(is!=null){
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(sk!=null){
				try {
					sk.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(ssk!=null){
				try {
					ssk.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		
		
	}
	
}
