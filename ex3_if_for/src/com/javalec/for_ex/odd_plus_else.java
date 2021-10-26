package com.javalec.for_ex;

public class odd_plus_else {
	public static void main(String[] args) {
		int even = 0;
		int odd = 0;
		
		for(int i = 0; i < 11; i++) {
			
			if(i % 2 == 0) {
				even = even + i;
			} else {
				odd = odd + i;
			}
			
			
		}
		
		System.out.println("Â¦¼öÀÇ ÇÕ : " + even);
		System.out.println("È¦¼öÀÇ ÇÕ : " + odd);
	}
}
