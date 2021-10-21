package com.javalec.for_ex;

public class multiple_3_Ex {
	public static void main(String[] args) {
		int i = 0;
		int mul = 0;
		
		while (i < 101) {
			
			if((i % 3) == 0) {
				mul = mul + i;
			}
			
			i++;
		}
		System.out.println(mul);
	}
}
