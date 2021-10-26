package com.javalec.ex;

public class MainClass {
	public static void main(String[] args) {
		ManClass mc = new ManClass();
		new ManClass(15, 160, 50, "010-7111-1111");
		mc.getAge();
		mc.setAge(16);
		double d = mc.calculateBMI();
	}
}
