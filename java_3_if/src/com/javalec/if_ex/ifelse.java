package com.javalec.if_ex;

public class ifelse {
	public static void main(String[] args) {
		/*
		int i = 10;
		int j = 20;
		
		if(i > j) {
			System.out.println("i는 j보다" + (i - j) + "만큼 더 큽니다.");
		} else {
			System.out.println("i는 j보다 " + (j - i) + "만큼 더 큽니다.");
		}
		*/
		int daeguLunchPrice = 5000;
		
		if(daeguLunchPrice >= 9000) {
			System.out.println("너무비싼데");
		} else if(daeguLunchPrice >=7000) {
			System.out.println("조금비쌈");
		} else if(daeguLunchPrice >= 5000) {
			System.out.println("적당하네");
		} else {
			System.out.println("싸네");
		}
		
		
		
	}
}
