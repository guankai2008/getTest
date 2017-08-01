package com.java.aop;

import java.lang.reflect.Proxy;

public  class MakeProxy {
	ProxySubject ps=new ProxySubject();
	public Object makeProxyObject(Object obj){
		ps.setRealObject(obj);
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), ps);		
	}
}
