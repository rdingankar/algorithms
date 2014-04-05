package com.asu.hash;

public class Cell<K, V> {
	private K key;
	private V value;
	public Cell(K k, V v) {
		key = k;
		value = v;
	}
	
	public boolean equivalent(K k){
		
		return (key == k);
		
	}
	
	public V getValue(){
		return value;
	}

}
