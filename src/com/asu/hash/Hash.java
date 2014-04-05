package com.asu.hash;

import java.util.LinkedList;

public class Hash <K,V>{
	private LinkedList<Cell<K,V>>[] items;						// 1
	
	public Hash(){
		items = (LinkedList<Cell<K,V>>[]) new LinkedList[10];	//2
	}
	
	public int hashFunction(K key){								//3
		return key.toString().length() % items.length;	
	}
	
	public void put(K key, V value){
		Cell<K,V> current = new Cell<K,V>(key,value);
		int x = hashFunction(key);
		
		if( items[x] == null)
			items[x]= new LinkedList<Cell<K,V>>();
		
		LinkedList<Cell<K,V>> ll = items[x];

		for(Cell<K,V> c : ll ){
			if(c.equivalent(key))
				ll.remove(c);
				break;
		}		
		ll.add(current);		
	}
	
	public V get(K key){
		int x = hashFunction(key);
		
		if( items[x] == null)
			return null;
		LinkedList<Cell<K,V>> ll = items[x];
		
		for(Cell<K,V> c : ll){
			if( c.equivalent(key))
				return c.getValue();
		}
		
		return null;
	}
	
	
}
