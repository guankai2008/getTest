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
 * �ͻ�����һ��ͼƬ����������
 * �������յ��󣬻ظ��Ѿ��յ�
 */
public class TestTcp3_1 {
	@Test
	public void client(){
		//1.����socket�׽���
		Socket sk=null;
		//2.ָ�����͵��ļ�
		FileInputStream fis=null;
		//3.�������緢����
		OutputStream os=null;
		//6. ���շ���˵Ļ�ִ
				//6.1�������������
		InputStream is=null;
		try {
			sk = new Socket(InetAddress.getByName("127.0.0.1"),9994);
			fis = new FileInputStream(new File("F:/1.png"));
			os = sk.getOutputStream();
			//4.��Ҫ���͵��ļ���ȡ�����飬��ͨ�����緢�����ͳ�ȥ
			byte[]b=new byte[10];
			int len;
			while((len=fis.read(b))!=-1){
				os.write(b);
			}
			//5.������Ϲر�socket�ķ����߳�
			sk.shutdownOutput();// �ļ��������
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
			//�ر�����socket
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
		//1.����һ������ļ����˿�
		ServerSocket ssk=null;
		//2.ͨ���˶˿ڴ���һ���׽���
		Socket sk=null;
		//3.���������ַ�����ת��Ϊstring��ӡ������̨
		InputStream is=null;
		//4.ָ���ļ��ı���ص�
		FileOutputStream fos=null;
		//5.���ͻ�ִ���ͻ��ˡ�
				//5.1�������������
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
			String str="�ļ��������";
			System.out.println(str);
			os = sk.getOutputStream();
			os.write(str.getBytes());
			//5.2�ر�����̡߳�
			sk.shutdownOutput();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//�ر����ж�����socket
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
