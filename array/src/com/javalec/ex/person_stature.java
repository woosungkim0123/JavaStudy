package com.javalec.ex;

import java.util.Scanner;

public class person_stature {
	public static void main(String[] args) {
		
		String[] iArrName = {"����", "ö��", "�浿", "����", "����"};
		int[] iArr = new int[5];
		int totalHeight = 0;
		int maxH = 0;
		int maxHIndex = 0;
		int minH = 0;
		int minHIndex = 0;
		
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < iArr.length; i++) {
			System.out.println(iArrName[i] + "Ű�� �Է� �ϼ���. : ");
			iArr[i] = scanner.nextInt();
			totalHeight = totalHeight + iArr[i];
		}
		
		System.out.println("�л����� ��� ������ " + totalHeight/iArrName.length);
		
		for (int i = 0; i < iArr.length; i++) {
			
			if(iArr[i] > maxH) {
				maxH = iArr[i];
				maxHIndex = i;
			}
		}
		
		System.out.println("���� ū �л��� " + iArrName[maxHIndex]  + "�Դϴ�");
		
		minH = maxH;
		
		for (int i = 0; i < iArr.length; i++) {
			
			if(iArr[i] < minH) {
				minH = iArr[i];
				minHIndex = i;
			}
		}
		
		System.out.println("���� ���� �л��� " + iArrName[minHIndex]  + "�Դϴ�");
		
		
		
 	}
}
