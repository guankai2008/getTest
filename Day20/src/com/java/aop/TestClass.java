package com.java.aop;

public class TestClass {
	public static void main(String[] args) {
		RealSubject rs=new RealSubject();
		MakeProxy mp=new MakeProxy();
		Object obj=mp.makeProxyObject(rs);
		Subject sbj=(Subject)obj;
		sbj.fly();
		sbj.info();
	}
}
