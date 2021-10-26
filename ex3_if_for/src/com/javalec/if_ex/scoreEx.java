package com.javalec.if_ex;

import java.util.Scanner;

public class scoreEx {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("국어점수를 입력하세요");
		int kor = scanner.nextInt();
		System.out.print("영어점수를 입력하세요");
		int eng = scanner.nextInt();
		System.out.print("수학점수를 입력하세요");
		int met = scanner.nextInt();
		
		double ave = (kor + eng + met) / 3;
		
		System.out.println("평균점수는 " + ave + "입니다");
		
		if (kor > ave) {
			System.out.println("평균보다 높음");
		} else if (kor < ave) {
			System.out.println("평균보단 낮음");
		} else {
			System.out.println("평균");
		}
		if (eng > ave) {
			System.out.println("평균보다 높음");
		} else if (eng < ave) {
			System.out.println("평균보단 낮음");
		} else {
			System.out.println("평균");
		}
		if (met > ave) {
			System.out.println("평균보다 높음");
		} else if (met < ave) {
			System.out.println("평균보단 낮음");
		} else {
			System.out.println("평균");
		}
		
	}
	
	
}
