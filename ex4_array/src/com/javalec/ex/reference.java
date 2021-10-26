package com.javalec.ex;

public class reference {
	public static void main(String[] args) {
		int[] iArr1 = {10, 20, 30, 40, 50};
		int[] iArr2 = iArr1;
		
		for (int i = 0; i < iArr1.length; i++) {
			System.out.println(iArr1[i]);
			System.out.println(iArr2[i]);
		}
		
		iArr2[0] = 100;
		iArr2[1] = 200;
		iArr2[2] = 300;
		iArr2[3] = 400;
		iArr2[4] = 500;
		
		for (int i = 0; i < iArr1.length; i++) {
			System.out.println(iArr1[i]);
			System.out.println(iArr2[i]);
		}
		
	}
}
