package com.javalec; 

public class objectEx {
	public static void main(String[] args) {
		int sum = 0;
		int result = 0;
		
		for (int i = 0; i <= 10; i++) {
			sum = sum + i;
		}
		
		System.out.println("���� " + sum + "�Դϴ�");
		
		result = sum % 2;
		
		if(result == 0) {
			System.out.println("¦���Դϴ�");
		} else {
			System.out.println("Ȧ���Դϴ�");
		}
		
	}
}
