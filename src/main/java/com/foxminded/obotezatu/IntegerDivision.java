package com.foxminded.obotezatu;

import java.util.Scanner;

public class IntegerDivision {

	public static void main(String[] args) {
		
		long dividend;
		long divider; 
		try (Scanner scanner = new Scanner(System.in)){
			System.out.println("Input dividend: ");
			dividend = scanner.nextLong();
			System.out.println("Input divider: ");
			divider = scanner.nextLong();
			if (divider == 0) {
				throw new ArithmeticException ("The divider cannot be 0!");
			}
		}
		System.out.println("----------------------------------");
		Division division = new Division();
		DivisionFormatter formatter = new DivisionFormatter();	
		System.out.println(formatter.format(division.divide(dividend, divider)));
		//ErrorFormat.divisionFormatterFormat();
	}
}
