package com.java.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.junit.Test;

/*
 * ����ͨ�ŵĵ�һ��Ҫ�أ�ͨ��IP��ַΨһ��λ����������һ̨������ͨ���˿ں���Ψһ��ʶһ��Ӧ�ó���.
 *   IP+�˿�====socket
 *      ������===socket���
 * InetAddressλ��java.net����
 * 1.InetAddress��������IP��ַ������һ��InetAddress����ʹ���һ��IP��ַ
 * 2.��δ���InetAddress�Ķ���getByName(String host)
 * 3.������������������getHostAddress:��ȡIP��ַ��getHostName():��ȡ����
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
