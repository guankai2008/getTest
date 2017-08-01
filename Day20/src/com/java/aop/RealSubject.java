package com.java.aop;

public class RealSubject implements Subject{

	@Override
	public void fly() {
		System.out.println("I belive,I can fly");
	}

	@Override
	public void info() {
		System.out.println("I am a superman");
	}

}
