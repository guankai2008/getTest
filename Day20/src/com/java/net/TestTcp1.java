package com.java.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import org.junit.Test;

/*
 * �ͻ��˸�����˷�����Ϣ
 * ������Ϣ���������̨��
 */
public class TestTcp1 {
	@Test
	public void client(){
		ClientThread ct=null;
		try {
			ct = new ClientThread(new Socket("127.0.0.1", 8909));
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread th1=new Thread(ct,"�ͻ���1");
		Thread th2=new Thread(ct,"�ͻ���2");
		th1.start();
		th2.start();
		
		
		
		
		
		
		
		
		
		/*Socket sk=null;
		OutputStream op=null;
		try {
			//1.����һ��Socket�ӿ�
			sk = new Socket(InetAddress.getByName("localhost"),8989);
			//2.getOutputStream
			op = sk.getOutputStream();
			//3.���ĵ��������
			op.write("���ǿͻ�����������".getBytes());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//4.�ر�����socket
			if(op!=null){
				try {
					op.close();
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
		
		*/
	}
	//����߳�
	
	
	
	@Test
	public void server(){
		//
		ServerSocket ssk=null;
		Socket sk=null;
		InputStream is=null;
		try {
			//1. ����һ������˵�SSk
			ssk = new ServerSocket(8909);
			sk = ssk.accept();
			is = sk.getInputStream();
			byte[]b=new byte[10];
			int len;
			while((len=is.read(b))!=-1){
				String str=new String(b,0,len);
				System.out.print(str+Thread.currentThread().getName());
			}
			System.out.println();
			System.out.println(ssk.isBound());
			System.out.println(ssk.isClosed());
			System.out.println(ssk.getLocalPort());
			System.out.println(ssk.getReceiveBufferSize());
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
class ClientThread implements Runnable{
	//1. ���в�������
	private Socket sk;
	public ClientThread(Socket sk){
		this.sk=sk;
	}
	public synchronized void run() {
		OutputStream os=null;
		try {
			os=sk.getOutputStream();
			os.write("���ǿͻ���".getBytes());
			
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