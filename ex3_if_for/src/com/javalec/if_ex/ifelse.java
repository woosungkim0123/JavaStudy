package com.javalec.if_ex;

public class ifelse {
	public static void main(String[] args) {
		/*
		int i = 10;
		int j = 20;
		
		if(i > j) {
			System.out.println("i�� j����" + (i - j) + "��ŭ �� Ů�ϴ�.");
		} else {
			System.out.println("i�� j���� " + (j - i) + "��ŭ �� Ů�ϴ�.");
		}
		*/
		int daeguLunchPrice = 5000;
		
		if(daeguLunchPrice >= 9000) {
			System.out.println("�ʹ���ѵ�");
		} else if(daeguLunchPrice >=7000) {
			System.out.println("���ݺ��");
		} else if(daeguLunchPrice >= 5000) {
			System.out.println("�����ϳ�");
		} else {
			System.out.println("�γ�");
		}
		
		
		
	}
}
