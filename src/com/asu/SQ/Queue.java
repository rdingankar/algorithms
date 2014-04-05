package com.asu.SQ;

import java.util.Iterator;
import java.util.LinkedList;

public class Queue {

	public static void main(String[] args) {
		LinkedList<Integer> queue = new LinkedList();
		queue.add(10);
		queue.add(8);
		queue.add(11);
//		queue.remove();
		System.out.println(queue);
		print(queue);

	}

	private static void print(LinkedList<Integer> queue) {
		Iterator it = queue.iterator();
		while(it.hasNext())
			System.out.println(it.next());
		
	}

}
