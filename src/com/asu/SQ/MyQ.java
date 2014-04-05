package com.asu.SQ;

import java.util.Stack;

public class MyQ<Integer>{
	private Stack<Integer> oldS;
	private Stack<Integer> newS;

	
	public MyQ(){
		oldS = new Stack<Integer>();
		newS = new Stack<Integer>();
	}
	
	public void push(Integer i){
		newS.push(i);
	}
	
	public void shiftS(){
		while(!oldS.isEmpty())
			newS.push(oldS.pop());
	}
	
	public Integer pop(){
		if(newS.isEmpty())
			shiftS();
			
		return newS.pop();
	}
	
	public Integer peek(){
		if(newS.isEmpty())
			shiftS();
			
		return newS.peek();
	}
	

}
