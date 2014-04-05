package com.asu.algo;
//1 3 1 2 5 1 1 4 1 2 3 1


//Write a function that takes integers m, n, and a 2-dimensional array of strings of size mn like this:
//
//[a, b 
//1, 2 
//*, +]
//
//and prints the cartesian product:
//a1*
//a1+
//a2*
//a2+
//...
//b2*
//b2+
//
//public static ArrayList<String> printProd( char[][] mat, ArrayList<String> res, m,n ){
//
//    
//    if( m==-1){
//    ArrayList<String> sub = new ArrayList<String>();
//        sub.add(new String);
//        return sub;
//    }
//    
//    ArrayList<String> sub = new ArrayList<String>();
//    sub = printProd(mat, res, m-1,n);
//    
//     ArrayList<String> more= new ArrayList<String>();
//    for(int i=0; i<n ; i++){
//        ArrayList<String> cur = insert(mat[m][i], sub);
//        more.addAll(cur);
//    }
//    
//    sub.addAll(more);
//    return sub;
//    
//}
//
//ArrayList<String> insert(char c,ArrayList<String> sub){
//
//for(int i =0; i< sub.length; i++){
//    ArrayList<String> comb = new ArrayList<String>();
//    String s = sub.get(i);
//    for( int j=0; j< s.length; j++){
//        String set = getStr(s,c,j);
//        comb.add(set);
//    }
//    
//    return comb;
//}
//String getStr(String s, char c, int j){
//    String s1 = s.substring(0,j);
//    String s2 = s.substring(j+1,s.length);
//    return s1 + c + s2;
//    
//
//
//}
//
//}


import java.io.*;
public class Solution {
    public static void main(String args[] ) throws Exception {
    	
    	Calculate();
    }

	private static void Calculate() throws Exception {
		int arr[]= new int[500];
		
        boolean sol = false;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] numbers = line.split(" ");
           
        
        for (int i = 0; i < numbers.length; i++) 
        	arr[i] = Integer.parseInt(numbers[i]);
        search: {
        for (int i = numbers.length/2 ; i > 0; i--) {
			for (int j1 = 0; j1 + 2*i  <= numbers.length; j1++) {
				for (int j2 = j1 + i; j2 <= numbers.length - i ; j2++) {
					sol = checkMass(arr,j1,j2,i);
					if(sol == true){
						System.out.println("first " + j1 + "second " + j2 + "length" + i);
						break search;
					}
				}
			}
        }
		}
        if(sol == false)
        	System.out.println(" cant form staff");

	}

	private static boolean checkMass(int[] arr, int j1, int j2, int i) {
		float wSum = 0;
		float rSum = 0;
		float length = i;
		int first = j1;
		int second = j2;
		for (int j = 1; j <= 2*i; j++) {
			if(j<=i){
				wSum += arr[first]*j;
				rSum += arr[first];
				first++;
			}
			else{
				wSum += arr[second]*j;
				rSum += arr[second];
				second++;
			}
				
		}
		
		if(wSum/rSum == length + 0.5 )
			return true;
//		art 2
		
		wSum = 0;
		rSum = 0;
		length = i;
		first = j1 + i-1;
		second = j2;
		
		for (int j = 1; j <= 2*i; j++) {
			if(j<=i){
				wSum += arr[first]*j;
				rSum += arr[first];
				first--;
			}
			else{
				wSum += arr[second]*j;
				rSum += arr[second];
				second++;
			}
				
		}
		
		if(wSum/rSum == i + 0.5 )
			return true;
		
//		part3
		
		wSum = 0;
		rSum = 0;
		length = i;
		first = j1;
		second = j2 + i -1;
		
		for (int j = 1; j <= 2*i; j++) {
			if(j<=i){
				wSum += arr[first]*j;
				rSum += arr[first];
				first++;
			}
			else{
				wSum += arr[second]*j;
				rSum += arr[second];
				second--;
			}
				
		}
		
		if(wSum/rSum == i + 0.5 )
			return true;
//	4th
		
		wSum = 0;
		rSum = 0;
		length = i;
		first = j1 + i -1;
		second = j2 + i -1;
		
		for (int j = 1; j <= 2*i; j++) {
			if(j<=i){
				wSum += arr[first]*j;
				rSum += arr[first];
				first--;
			}
			else{
				wSum += arr[second]*j;
				rSum += arr[second];
				second--;
			}
				
		}
		
		if(wSum/rSum == i + 0.5 )
			return true;
		
		
		return false;
	}
}
