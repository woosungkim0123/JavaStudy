package com.javalec.if_ex;

import java.util.Scanner;

public class Switch {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int i = scn.nextInt();
		int result = i % 2;
		
		switch (result) {
		case 0:
			System.out.println("¦��");
			break;
		case 1:
			System.out.println("Ȧ��");
			break;
			
		default:
			System.out.println("�𸣰ڴ�");
			break;
		}
	}
}
