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
 * 客户端给服务端发送信息
 * 服务将信息输出到控制台上
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
		Thread th1=new Thread(ct,"客户机1");
		Thread th2=new Thread(ct,"客户登2");
		th1.start();
		th2.start();
		
		
		
		
		
		
		
		
		
		/*Socket sk=null;
		OutputStream op=null;
		try {
			//1.创建一个Socket接口
			sk = new Socket(InetAddress.getByName("localhost"),8989);
			//2.getOutputStream
			op = sk.getOutputStream();
			//3.流的的输出操作
			op.write("我是客户机，请多关照".getBytes());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//4.关闭流和socket
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
	//多个线程
	
	
	
	@Test
	public void server(){
		//
		ServerSocket ssk=null;
		Socket sk=null;
		InputStream is=null;
		try {
			//1. 创建一个服务端的SSk
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
	//1. 公有操作对象
	private Socket sk;
	public ClientThread(Socket sk){
		this.sk=sk;
	}
	public synchronized void run() {
		OutputStream os=null;
		try {
			os=sk.getOutputStream();
			os.write("我是客户机".getBytes());
			
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