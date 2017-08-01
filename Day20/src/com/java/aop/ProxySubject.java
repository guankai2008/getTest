package com.java.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxySubject implements InvocationHandler{
	
	private Object obj;
	public void setRealObject(Object obj){
		this.obj=obj;
	}
	@Override
	
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		StaticCode.staticMethod1();
		Object returnValue=method.invoke(obj, args);
		StaticCode.staticMethod2();
		return returnValue;
	}
	
}
