package com.javalec.if_ex;

import java.util.Scanner;

public class scoreEx {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("���������� �Է��ϼ���");
		int kor = scanner.nextInt();
		System.out.print("���������� �Է��ϼ���");
		int eng = scanner.nextInt();
		System.out.print("���������� �Է��ϼ���");
		int met = scanner.nextInt();
		
		double ave = (kor + eng + met) / 3;
		
		System.out.println("��������� " + ave + "�Դϴ�");
		
		if (kor > ave) {
			System.out.println("��պ��� ����");
		} else if (kor < ave) {
			System.out.println("��պ��� ����");
		} else {
			System.out.println("���");
		}
		if (eng > ave) {
			System.out.println("��պ��� ����");
		} else if (eng < ave) {
			System.out.println("��պ��� ����");
		} else {
			System.out.println("���");
		}
		if (met > ave) {
			System.out.println("��պ��� ����");
		} else if (met < ave) {
			System.out.println("��պ��� ����");
		} else {
			System.out.println("���");
		}
		
	}
	
	
}
