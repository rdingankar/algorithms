//package com.asu.SQ;
//
//import java.util.LinkedList;
//
//public abstract class Animal{
//	private int count;
//	private String name;
//	
//	public Animal( String n){
//		name = n;
//	}
//	
//	public void setCounter( int c){
//		count = c;
//	}
//	
//	public int getCounter(){
//		return count;
//	}
//	
//}
//
//public class Cat extends Animal{
//	public Cat( String n){
//		super(n);
//	}
//}
//
//public class Dog extends Animal{
//	public Dog( String n ){
//		super(n);
//	}
//
//	public boolean isOlderThan(Cat c) {
//		return this.getCounter() < c.getCounter();
//	}
//}
//
//
//	
//public class AnimalQ{
//	LinkedList<Dog> d;
//	LinkedList<Cat> c;
//	int cnt;
//	public static void main(String[] args) {
//		
//	}
//	public Animal dQCat(){
//		return c.remove();
//	}
//	
//	public Animal dQDog(){
//		return d.remove();
//	}
//	
//	public void enQ( Animal a){
//		cnt++;
//		a.setCounter(cnt);
//		if( a instanceof Cat)
//			c.add((Cat)a);
//		else
//			d.add((Dog)a);
//			
//	}
//	
//	public Animal dQAny(){
//		if( d.peek().isOlderThan(c.peek()) )
//			return d.remove();
//		else 
//			return c.remove();
//		
//	}	
//}
	
//}





//
