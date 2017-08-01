package com.java.net;

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
 * 客户机发一个图片给服务器，
 * 服务器收到后，回复已经收到
 */
public class TestTcp3_1 {
	@Test
	public void client(){
		//1.创建socket套接字
		Socket sk=null;
		//2.指定发送的文件
		FileInputStream fis=null;
		//3.创建网络发送流
		OutputStream os=null;
		//6. 接收服务端的回执
				//6.1创建网络输出流
		InputStream is=null;
		try {
			sk = new Socket(InetAddress.getByName("127.0.0.1"),9994);
			fis = new FileInputStream(new File("F:/1.png"));
			os = sk.getOutputStream();
			//4.将要发送的文件读取到数组，在通过网络发送流送出去
			byte[]b=new byte[10];
			int len;
			while((len=fis.read(b))!=-1){
				os.write(b);
			}
			//5.发送完毕关闭socket的发送线程
			sk.shutdownOutput();// 文件发送完成
			is = sk.getInputStream();
			byte[]b1=new byte[10];
			int len1 ;
			StringBuffer sb=new StringBuffer();
			while((len1=is.read(b1))!=-1){
				sb.append(new String(b1,0,len1));
			}
			System.out.println(sb.toString());
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
			//关闭流和socket
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
			if(fis!=null){
				try {
					fis.close();
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
		}	
		
	}
	@Test
	public void server(){
		//1.创建一个服务的监听端口
		ServerSocket ssk=null;
		//2.通过此端口创建一个套节字
		Socket sk=null;
		//3.将发来的字符数组转换为string打印到控制台
		InputStream is=null;
		//4.指定文件的保存地点
		FileOutputStream fos=null;
		//5.发送回执给客户端。
				//5.1创建网络输出流
		OutputStream os=null;
		try {
			ssk = new ServerSocket(9994);
			sk = ssk.accept();
			is = sk.getInputStream();
			byte[]b=new byte[10];
			int len;
			fos = new FileOutputStream(new File("D:/2.jpg"));
			while((len=is.read(b))!=-1){
				fos.write(b, 0, len);
			}
			String str="文件保存完成";
			System.out.println(str);
			os = sk.getOutputStream();
			os.write(str.getBytes());
			//5.2关闭输出线程。
			sk.shutdownOutput();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//关闭所有都流和socket
			if(os!=null){
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(fos!=null){
				try {
					fos.close();
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
