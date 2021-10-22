package com.javalec;

import java.util.Scanner;

public class objectEx2 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		
		objectEx2 guGudan = new objectEx2();
		guGudan.gugudan(input);
		
	}
	
	public void gugudan(int i) {
		for(int j=1;  j<10; j++) {
			System.out.println(i * j);
		}
	}

}
