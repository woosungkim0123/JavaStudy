package com.javalec.ex2;

import java.util.Scanner;

public class Operator {
	public static void main(String[] args) {
		
		int i = 10;
		int j = 3;
		int h = 5;
		
		System.out.println(i + j); 
		System.out.println(i - j);
		System.out.println(i * j);
		System.out.println(i / j);
		System.out.println(i & j);

		i++;
		System.out.println(i);
		j--;
		System.out.println(j);
		
		System.out.println(i == j);
		System.out.println(i != j);
		System.out.println(i > j);
		System.out.println(i < j);
		
		System.out.println("�Ѵٸ��� : " + (i > j && i < h));
		System.out.println("�ϳ������� : " + (i > j || i < h));
		
		int result = h != 5 ? 1 : 2;
		System.out.println(result);
		
		i += 100;
		
		System.out.println(i);
		
		
		Scanner kim = new Scanner(System.in);
		int in = kim.nextInt();
		
		System.out.println(in % 3);
		
		 
	
		
		
		
		
	}
}
