package com.asu.arrays;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import javax.swing.text.html.MinimalHTMLWriter;


public class Array {
	

	public static void main( String[] args){
		boolean[] b = new boolean[2];
		System.out.println(b[0]);

		int arr[] = {10,-133,22,32,-77,61,-24,45,41,-33};
//		int arr[] = {198,342,333,499,145,721,119,131,123,145,444};
		Array a = new Array(arr);
		
		char[] array = new char[10];
		StringBuffer str = new StringBuffer();
		str = str.append('f');
		str.append(false);
		System.out.println(str);	
		_changeString(str);
		System.out.println(str);
		String str2 = "ravi";
//	-----------------------------------------------------------------------------------------------	
		_stockProfit(arr);
		fibo(7);
		int maxSum = a.MaxSum();
		maxSum = a.MaxDSum();
		char ch = firstNonRep(str2);
		int number = binraySearch( arr, 1);
		boolean val = hasUniqueChars("aabcd");
		reverse(array);
		kSorted();
		maxDiff();
		System.out.println(arr);
		int arrm[] = {49,5,7,23,444,23,1,12};
		System.out.println("hhh" + getMax(arrm, 0,7));
		calcWater(arrm);
		quickSelect(arrm,0, arrm.length-1,4);
		getPattern("abhsdfshdkjfhskhfkshfhsfjskdfcdedfgh", "hijkabcdeabhsdfshdkjfhskhf");
		getSub0Array(arrm);
		maxNonDup("apoorv satish dawalbhakta");
		System.out.println(" maxNpnCont " + maxNonCont(arrm));

//		-----------------------------------------------------------------------------------------------	
//		for (int i = 0; i < arrm.length; i++) {
//		System.out.println(arrm[i] + "quick");
//	}		
		

		
		
//		System.out.println("maximum sum is " + maxSum);
//		
		
//		System.out.println("maximum sum by DP is " + maxSum);
//		
		String str1 = "ravindra vishwas dingankar";
		StringBuffer sb = new StringBuffer();
		sb.append(str);
		char[] array1 = str1.toCharArray();
		
		str1 = new String(array1);
		Arrays.sort(array);

		
		reverse(array,0,array.length-1);
		stringReverse(array);	
		stringReverse(str1);
		
		char[] pattern = new char[100];
		pattern = "AAACAAAAAC".toCharArray();
		int[] helper = new int[100];
		
		helper = bulidHelper(pattern);
		
		printRec("ravi");

		
	}
	
	public static int getMax( int[] arr,int start ,int end){
		if( start == end)
			return arr[start];
		int mid = (start + end)/2;
		int x = getMax( arr, start, mid);
		int y = getMax( arr, mid +1, end );
		return Math.max(x,y);
	}
	
	public static void printRec( String s){
		if(s.length() == 0)
			return;
		printRec( s.substring(1) );
		System.out.println(s.charAt(0));
	}
	
	public static void maxNonDup(String str ){

		char[] arr = str.toCharArray();
		int length = 0;
		int mLength = 0;
		int start = 0;
		int mStart = 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer> ();

		if( str == null || str.length() == 0)
			return;

		for( int i = 0; i< arr.length ; i++ ){
			if( map.containsKey(arr[i]) ){
				length = i - start;
				if( length > mLength ){
					mLength = length;
					mStart = start;
				}
				start = map.get(arr[i]) + 1;
				map.clear();
				map.put(arr[i], i);
			}
			else{
				map.put(arr[i], i);
			}
		}
		length = arr.length - start;
		if( length > mLength ){
			mLength = length;
			mStart = start;
		}

		System.out.println(str.substring(mStart,mStart + mLength));
	}

	private static void getSub0Array(int[] arrm) {

			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			int sum = arrm[0];
			int start = 0;
			int end = 0;
			int length =0;

			int mStart = 0;
			int mEnd = 0;
			int mLength =0;

			for( int i = 1; i< arrm.length ; i++){
				sum += arrm[i];
				if(sum == 0){
					start = 0;
					end = i;
					length = i + 1;
					if( length > mLength ){
						mStart = start;
						mEnd = end;
						mLength =length;
					}
				}
				
				if(map.containsKey(sum)){
					start = map.get(sum) + 1;
					end = i;
					length = end - start +1;
					if( length > mLength ){
						mStart = start;
						mEnd = end;
						mLength =length;
					}
				}

				else{
					map.put(sum, i);
				}
			}
		for(int i = mStart ; i<= mEnd; i++)
			System.out.println(i + " num " + arrm[i]);
	}




	private static void getPattern(String str1, String str2) {
		char[] s1 = str1.toCharArray();
		char[] s2 = str2.toCharArray();
		int j = s2.length-1;

		for(int i = s1.length-1; i>= 0; i--){
			if(s1[i] == s2[j])
				j--;
			else
				j = s2.length -1;
		}
		
		for(int i = j+1; i < s2.length ; i++){
			System.out.print(s2[i]);
		}
	}




	private static void quickSelect(int[] arrm,int start,int end, int k) {
		int p = partition(arrm,start,end,k);
		if(p > k)
			quickSelect(arrm,start,p,k);
		else if(p < k)
			quickSelect(arrm,p+1,end,k);
		else if (p == k)
			return;
	}




	private static int partition(int[] arrm, int i, int j, int k) {
		// TODO Auto-generated method stub
		int pivot = arrm[(i + j)/2];

		while(i <= j){
			while(arrm[i] < pivot)
				i++;
			while(arrm[j] > pivot )
				j--;
			if(i <= j){
				int tmp = arrm[i];
                arrm[i] = arrm[j];
                arrm[j] = tmp;
                i++;
                j--;
			}
		}
		return i - 1;
	}




	private static void calcWater(int[] arrm) {
		if(arrm == null)
			return;
		int length = arrm.length;
		if(length == 0)
			return;
		int water=0;
		int maxI  = 0;
		
		while(maxI < length){
			int i;
			int start = arrm[maxI];
			int startI = maxI;
			
			int max = Integer.MIN_VALUE;
//			for one
			for(i = startI+1; i<length && arrm[i] < start; i++){
				if(arrm[i] > arrm[i-1] && arrm[i] > max){
					max = arrm[i];
					maxI = i;
				}
			}
			int height;
			if( i< length && arrm[i] >= start){
				height = start;
				maxI = i;
			}
			else if(max != Integer.MIN_VALUE){
				height = arrm[maxI];
			}
			else
				break;
				
			
			for(int j = startI +1 ; j < maxI ; j++)
				water+= ( height - arrm[j]);
						
		}
		
		for(int i = 0; i< length ; i++)
			System.out.println(" ajaja " + arrm[i]);
		System.out.println("water = " + water);
	}


	public static int[] sarr = new int[10];

	public Array(int[] arr) {
		super();
		this.arr = arr;
	}
	
	public Array() {
		System.out.println("Empty Constructor");
	}


	private static int arr[];

	public int[] getArr() {
		return arr;
	}
	

	public void setArr(int arr[]) {
		this.arr = arr;
	}
	
	
	
	public static void kSorted(){
		int [] arr = {1,3,5,2,4,7,6,11};
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(3);
		
		
		for(int i = 0; i <=2; i++){
			pq.add(arr[i]);
		}
		
		for(int i = 3, j = 0; j < arr.length-1; i++,j++){
			
			if(i < arr.length-1){
				arr[j] = pq.remove();
				pq.add(arr[i]);
			}
			else{
				arr[j] = pq.remove();
			}
			
		}
	
		for(int i : arr){
			System.out.println(i);
		}
	}
	
	
	public String compress( String str){

		int size = str.length();
		int compressedSize = getCompressedSize(str);
		
		if( compressedSize >= size)
			return str;
		
		StringBuffer sb = new StringBuffer();
		int count = 1;
		char current = 0;
		char prev = 0;
		
		for( int i =0; i< str.length(); i++){
			current = str.charAt(i);
			if(current == prev){
				count++;
			}
			else{
				sb.append(current);
				sb.append(count);
				count = 1;
				prev = current;
			}
		}
		
		sb.append(current);
		sb.append(count);
		
		return sb.toString();

	}

public int getCompressedSize(String str){
		
		char prev = str.charAt(0);
		char current;
		int count =1;
		int size =0;
		for(int i=1; i< str.length(); i++){
			current = str.charAt(i);
			if( current == prev)
				count++;
			else{
				size = size + 1 + String.valueOf(count).length();
				count = 1;
				prev = current;
			}
					
		}
		size = size + 1 + String.valueOf(count).length();
		return size;

	}

private static int[] bulidHelper(char[] pattern) {
		int[] helper = new int[100];
		
		helper[0] = 0;
		int len = 0;
		int i =1;
		while( i< pattern.length){
			if(pattern[i] == pattern[len]){
				len++;
				helper[i] = len;
				i++;
			}
			else{  //pattern[i] != pattern[len]
				if(len != 0){ // This is tricky. Consider the example AAACAAAA and i = 7.
					len = helper[len-1];
				}
				else{
					helper[i] = 0;
					i++;
				}
			}
		}
		
		return helper;
	}

private static void stringReverse(String str) {
		str = reverse(str);
//		String word;
//		StringTokenizer sentence = new StringTokenizer(str);
//		StringBuffer sb = new StringBuffer();
//		while(sentence.hasMoreTokens()){
//			word = reverse(sentence.nextToken());
//			sb.append(word+ " ");
//			
//		}
//		
//		System.out.println(sb);
		String[] words = str.split(".");
		
		for(int i =0; i< words.length ; i++){
			str = reverse(words[i]);
			System.out.print(str+ " ");
		}
		
	}

public void setZero( int[][] arr){

	boolean row[] = new boolean[arr.length];
	boolean col[] = new boolean[arr[0].length]; 
	for( int i =0 ; i < arr.length; i++){
		for( int j = 0; j< arr[0].length ; j++){
			if(arr[i][j] == 0){
				row[i] = true;
				col[j] = true;
			}
		
		}
	}	
	for( int i =0 ; i < arr.length; i++){
		for( int j = 0; j< arr[0].length ; j++){
			if(row[i] || col[j])
				arr[i][j] = 0;
		}

	}
}

public static void stringReverse(char[] array){
	reverse(array,0,array.length-1);
	int start =0;
	for(int i=0;i<array.length; i++){
		if(array[i] == ' '){
			reverse(array,start,i-1);
			start = i+1;
		}
	}
	String str;
//	reverse(array,start,array.length-1);
}



	private static void reverse(char[] array, int first, int last) {
		if(first == last)
			return;
		
		char temp = array[first];
		array[first] = array[last];
		array[ last] = temp;
		
		if((last-first) <=2 )
			return;
		
		reverse(array,first +1, last-1);		
	}

	private static void reverse( char[] array ){
		char temp;
		if( array.length == 0 )
			return;
		for(int i = 0; i<array.length/2 ; i++){
			temp = array[i];
			array[i] = array[(array.length-1) - i];
			array[(array.length-1) - i] = temp;
		}	
	}
	
	public static String reverse(String str) {
	    if ((null == str) || (str.length()  <= 1)) {
	        return str;
	    }
	    
	    if(str.length() == 2)
	    	return str.charAt(1) + "" + str.charAt(0);
	    
	    return str.charAt(str.length()-1) + reverse(str.substring(1, str.length()-1)) + str.charAt(0);//substring(start, end-1)
	}

	public static boolean hasUniqueChars( String str ){

//		if( str.length() > 256 )
//			return false;
//		int checker =0;
//		for( int i =0; i< str. length() ; i ++ ){
//			int val = str.charAt(i) - 'a';
//			if((checker & (1<< val)) > 0)
//				return false;
//			checker |= (1<<val);		
//		}
//		return true;
		
		if( str.length() > 256 )
			return false;
		boolean[] checker = new boolean[256];
		for( int i =0; i< str. length() ; i ++ ){
			if( checker[str.charAt(i)] == true )
				return false;
			checker[str.charAt(i)] = true;	
		}
		return true;
	}
	
	private static int fibo (int number){
//		if( number == 0){
//			sarr[0] = 0;
//			return 0;
//		}
//		if( number == 1){
//			sarr[1] = 1;
//			return 1;
//		}
//		if( sarr[number] != 0)
//			return sarr[number];
//		else{
//			sarr[number] = fibo(number-1) + fibo(number -2);
//			return sarr[number];
//		}
		
		int a =1;
		int b = 0;
		int temp;
		for( int i=0; i< number; i++ ){
			temp = a;
			a = a + b;
			b = temp;
			System.out.println(" " + temp);
		}
		return 0;
	}
	
	private static void _changeString(StringBuffer str) {
		str.append(10);
	}

	private static void _stockProfit(int[] arr) {
		int minElement = Integer.MAX_VALUE;
		int maxDiff = 0;		
		for (int i = 0; i < arr.length; i++) {
						
			if( maxDiff < arr[i] - minElement )
				maxDiff = arr[i] - minElement;
			if(minElement > arr[i])
				minElement = arr[i];
		}
		
		System.out.println("Min element is " + minElement + " The diff is " + maxDiff);
		
//		Multiple buy sell
		
		 // solution vector
	    int[] sol = new int[arr.length];
	    
	 
	    // Traverse through given price array
	    int i = 0;
	    int count = 0;
		while (i < arr.length-1)
	    {
	        // Find Local Minima. Note that the limit is (n-2) as we are
	        // comparing present element to the next element. 
	        while ((i < arr.length-1) && (arr[i] >= arr[i+1]))
	            i++;
	 
	        // If we reached the end, break as no further solution possible
	        if (i == arr.length-1)
	            break;
	 
	        // Store the index of minima
	        sol[count] = arr[i];
	        i++;
	        count++;
	 
	        // Find Local Maxima.  Note that the limit is (n-1) as we are
	        // comparing to previous element
	        while ((i < arr.length) && (arr[i] >= arr[i-1]))
	            i++;
	 
	        // Store the index of maxima
	        sol[count] = arr[i-1];
	 
	        // Increment count of buy/sell pairs
	        count++;
	    }
//		198,342,333,499,145,721,119,131,123,145,444
	    // print solution
	    if (count == 0)
	        System.out.println("There is no day when buying the stock will make profit\n");
	    else
	    {
	       for (int i1 = 0; i1 < count; i1++)
	    	   System.out.println("Buy and sell " + sol[i1]);
	    }
	 
	    return;
		
	}

	private static int binraySearch(int[] arr, int i) {
		
		int last = arr.length - 1;
		int first = 0;
		int middle = 0;
		
		while(first < last){
			
			if(arr[first] > arr[last])
				return 0;
			
			middle = (first + last)/2;
			
			if(arr[middle] == i)
				return i;
			else if(arr[middle] < i )
				first = middle + 1;
			else if(arr[middle] > i )
				last = middle -1;
		}
		
		return 0;
	}

	public static char firstNonRep(String str){
		
		Hashtable<Character, Integer> charHash = new Hashtable<Character, Integer>();
		
		for (int i = 0; i < str.length(); i++) {
			
			char ch = str.charAt(i);
			
			Integer count = (Integer) charHash.get(ch);
			
			
			if(count == null)
				charHash.put(ch,1);
			else
				charHash.put(ch,count + 1);
			
			
		}
		
		for (int i = 0; i < str.length(); i++) {
			int count;
			char ch = str.charAt(i);
			count = (int) charHash.get(ch);
			if (count == 1)
				return ch;
		}
		return 0;
		
	
		
	}
	
	public static int maxDiff(){
		int [] arr = {10,10,3,100,7,8,1,9,10,10,100};
		
		int min = arr[0];
		int globalMax = 0;
		
		for( int i =0; i< arr.length; i++ ){
			int localMax = arr[i] - min;
			if(localMax > globalMax){
				globalMax = localMax;
			}
			
			if( arr[i] < min )
				min = arr[i];
			
		}
		System.out.println(globalMax);
		return globalMax;
	}

	private int MaxDSum() {
		int globalmax = 0;
		int localmax = 0;
		int start = 0;
		int end = 0;
		
		for (int i = 0; i < arr.length; i++) {
			localmax = Math.max(localmax + arr[i], 0);
			globalmax = Math.max(globalmax, localmax);
					
		}
		
		return globalmax;
	}

	private int MaxSum() {
		int max = 0;
		int localmax = 0;
		int start = 0;
		int end = 0;
		int temp = 0;
		
		for (int i = 0; i < arr.length; i++) {
			localmax = localmax + arr[i];
			
			if( localmax < 0){
				localmax =0;
				temp = i + 1;//
			}
			else if (localmax > max){
				max = localmax;
				start = temp;//
				end = i;//
			}
			
		}
		
		System.out.println("start at " + start + " and ending at " + end);
		return max;
	}
	
	public static int maxNonCont( int[] arr){
		int prevSum = arr[0];
		int prev2Sum = 0;
		int sum = 0;
		
		for( int i =1; i< arr.length; i++ ){
			sum = Math.max( prevSum, prev2Sum + arr[i] );
			prev2Sum = prevSum;
			prevSum = sum;
			
		}

		return sum;	
	}
	
	public static void printPairs( int[] arr, int k ){

		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		
		for( int i = 0; i< arr.length ; i++){
		
			if( map.containsKey(k - arr[i]))
				System.out.println(arr[i] + " " + (k - arr[i]) );			
			map.put(arr[i], true);			
		}
		
		for(Integer i : map.keySet())
			System.out.println(i);

	}
	
	public static void printSecond( int[] arr, int k ){
	char [] ar = {'f','g','h','i','g','f','a','b','c','b','a','i','g'};
	
	
	HashMap<Character	, Boolean> lhm = new HashMap<Character, Boolean>();
	
	for(Character c : ar){
		if(!lhm.containsKey(c)){
			lhm.put(c, true);
		}
		else{
			lhm.put(c, false);
		}
				
		
	}
	
	for(Character c : lhm.keySet()){
		if(lhm.get(c)){
			System.out.println(c);
			break;
		}
	}
}
	
	

}
