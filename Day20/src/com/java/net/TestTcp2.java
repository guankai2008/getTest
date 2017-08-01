package com.java.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;


import org.junit.Test;

/*
 * 客户端给服务端发信息，
 * 服务端将新消息打印到服务台上，同时发送已收到信息的反馈
 */
public class TestTcp2 {
	@Test
	public void client1(){
		Socket sk=null;
		OutputStream os=null;
		InputStream is=null;
		try {
			sk = new Socket(InetAddress.getByName("localhost"),8991);
			os = sk.getOutputStream();
			os.write("我是客户端1，您好".getBytes());
			//shutdown(),显示的告诉服务我已经发送完毕
			sk.shutdownOutput();
			is = sk.getInputStream();
			byte[]b=new byte[20];
			int len;
			while((len=is.read(b))!=-1){
				System.out.print(new String(b,0,len));
			}
		}  catch (IOException e) {
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
		ServerSocket ssk=null;
		Socket sk=null;
		InputStream is=null;
		OutputStream os=null;
		try {
			ssk = new ServerSocket(8991);
			sk = ssk.accept();
			is = sk.getInputStream();
			byte[]b=new byte[20];
			int len;
			while((len=is.read(b))!=-1){
				System.out.print(new String(b,0,len));
			}
			os = sk.getOutputStream();
			os.write("信息已经收到".getBytes());
			sk.isOutputShutdown();
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
