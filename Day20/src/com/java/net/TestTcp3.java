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

import org.junit.Test;

public class TestTcp3 {
	@Test
	public void server(){
		ServerSocket ssk=null;
		Socket sk=null;
		InputStream is=null;
		FileOutputStream fos=null;
		OutputStream os=null;
		try {
			ssk = new ServerSocket(9993);
			sk = ssk.accept();
			is = sk.getInputStream();
			fos = new FileOutputStream(new File("D:/text.jpg"));
			byte[]b=new byte[10];
			int len;
			while((len=is.read(b))!=-1){
				fos.write(b, 0, len);
				fos.flush();
			}
			os = sk.getOutputStream();
			os.write("文件已经收到".getBytes());
			sk.shutdownOutput();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	@Test
	public void client(){
		Socket sk=null;
		OutputStream os=null;
		FileInputStream fis=null;
		InputStream is=null;
		try {
			sk = new Socket(InetAddress.getByName("127.0.0.1"), 9993);
			os = sk.getOutputStream();
			fis = new FileInputStream(new File("F:/1.png"));
			int len;
			byte[]b=new byte[20];
			while((len=fis.read(b))!=-1){
				os.write(b);
			}
			sk.shutdownOutput();
			is = sk.getInputStream();
			byte[]b1=new byte[10];
			int len1;
			StringBuffer sb=new StringBuffer();
			while((len1=is.read(b1))!=-1){
				sb.append(new String(b1,0,len1));
			}
			System.out.println(sb.toString());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
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
}
