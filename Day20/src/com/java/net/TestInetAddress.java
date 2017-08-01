package com.java.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.junit.Test;

/*
 * 网络通信的第一个要素，通过IP地址唯一地位，互联网上一台主机。通过端口号来唯一标识一个应用程序.
 *   IP+端口====socket
 *      网络编程===socket变成
 * InetAddress位于java.net包下
 * 1.InetAddress用来代表IP地址，代表一个InetAddress对象就代表一个IP地址
 * 2.如何创建InetAddress的对象，getByName(String host)
 * 3.对象有两个方法，①getHostAddress:获取IP地址②getHostName():获取域名
 * 		
 * 
 */
public class TestInetAddress {
	@Test
	public void test1(){
		try {
			InetAddress ina=InetAddress.getByName("www.baidu.com");
			System.out.println(ina);
			System.out.println(ina.getHostName());
			System.out.println(ina.getHostAddress());
			
			ina=InetAddress.getByName("www.google.com");
			System.out.println(ina.getHostName());
			System.out.println(ina.getHostAddress());
			ina=InetAddress.getLocalHost();
			System.out.println(ina.getHostName());
			System.out.println(ina.getHostAddress());
			System.out.println();
			InetAddress[]inet= InetAddress.getAllByName("www.dodonew.com");
			for(InetAddress i:inet){
				System.out.println(i.getHostAddress());
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
