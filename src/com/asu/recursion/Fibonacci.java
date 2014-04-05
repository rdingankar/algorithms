package com.asu.recursion;

import java.util.PriorityQueue;

public class Fibonacci {
	
	static int fib[] = new int[100];
	
	public static void main(String[] args) {
		int number = 10;
		
		int  result = fibo(number);
		
		iterativeFibo(number);
		
//		for(int i =0; i<fib.length; i++)
//			System.out.print(fib[i] + " ");		
	}

	
	
	private static void iterativeFibo(int number) {
		int[] arr = new int[number];
		
		int a = arr[0] = 0;
		int b = arr[1] = 1;
		
		for(int i = 2; i< number; i++){
			arr[i] = a + b;
			a = b;
			b = arr[i];
		}
		
		
		for(int i =0; i<arr.length; i++)
			System.out.print(arr[i] + " ");	
		
	}



	private static int fibo(int number) {
		if( number == 0)
			return 0;
		if(number == 1)
			return 1;
		if(fib[number] != 0)
			return fib[number];
		fib[number] = fibo(number - 1) + fibo(number - 2);
		
		return fib[number];
	}
}
