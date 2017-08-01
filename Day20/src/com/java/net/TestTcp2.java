package com.java.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;


import org.junit.Test;

/*
 * �ͻ��˸�����˷���Ϣ��
 * ����˽�����Ϣ��ӡ������̨�ϣ�ͬʱ�������յ���Ϣ�ķ���
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
			os.write("���ǿͻ���1������".getBytes());
			//shutdown(),��ʾ�ĸ��߷������Ѿ��������
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
			os.write("��Ϣ�Ѿ��յ�".getBytes());
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
