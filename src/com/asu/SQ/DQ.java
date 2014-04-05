package com.asu.SQ;

public class DQ{
	public int start;
	public int end;
	int[] arr;
	int size;
	
	
	public DQ(int s){
		size = s;
		int[] arr = new int[size];
	}
	
	public int removeF(){
		int v = arr[start];
		start = (start +1) % size;
		return v;
	}
	
	public int removeL(){
		int v = arr[end];
		end = (end  - 1) % size;
		return v;
	}
	
	public void addF(int el){
		start = (start - 1) % size;
		arr[start] = el;
	}
	
	public void addL(int el){
		end = (end + 1) % size;
	}
	
	int getEl( int index){
		index = (index + start ) % size;
		return arr[index];
	}
}
