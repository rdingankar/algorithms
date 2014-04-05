package com.asu.SQ;

import java.util.Stack;

public class Stk {
	
	public static Stack<Integer> sort(Stack<Integer> s){

		Stack<Integer> r = new Stack();
		int temp;
		
		while(!s.isEmpty()){
		temp = s.pop();
			while( !r.isEmpty() && r.peek() > temp ){
				s.push(r.pop());
			}
			r.push(temp);
		}
		return r;
		
	}

}
