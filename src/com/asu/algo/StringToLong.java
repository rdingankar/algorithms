package com.asu.algo;

import java.util.Scanner;

public class StringToLong {
	
	public static long stringToLong(String str) throws Exception{ 
		
		long number = 0;
		int currentDigit = 0;
		boolean isNeg = false;
		
//		no input given
		if( str.length() == 0)
			throw new Exception("Please Enter some number");
		
//		if the number is negative
		if(str.charAt(0) =='-'){
			isNeg = true;
			str = str.substring(1);
		}
		
		for( int i = 0; i< str.length(); i++){
			
//			get the current digit
			currentDigit = str.charAt(i) - '0';
			
//			current digit is not a valid digit
			if( currentDigit < 0 || currentDigit > 9)
					throw new Exception("Invalid input");

//			if entered number is out of long range
			if( number > (Long.MAX_VALUE - currentDigit ) /10  )
					throw new Exception("Number out of range");
			
//			if digit passes all error conditions keep on calculating the number in long
			number = number*10 + currentDigit;
			
		}
		
//		if a negative number was entered 
		if(isNeg)
			return -number;
		else
			return number;
						
	}

	public static void main(String[] args) {
		System.out.println("Enter a number");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		try {
			long number = stringToLong(str);
			System.out.println("You Entered the following number : " + number);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
