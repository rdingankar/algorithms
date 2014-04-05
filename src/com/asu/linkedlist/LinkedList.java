package com.asu.linkedlist;

import java.util.HashMap;
import java.util.Stack;

public class LinkedList {
	static int i=0;
	LinkedList(){
		
	}
	
	public static Node createLinkedList(int arr[]){
		
		Node head = new Node(arr[0]);
		
		Node element = new Node();
		element = head;
		
		for (int i = 1; i < arr.length; i++) {
			
			Node newElement = new Node(arr[i]);
			element.next = newElement;
			element = element.next;
		}
		return head;
	}
	
	public static void printList(Node element){
		Node tmpElement = element;
		while(tmpElement!=null){
			System.out.print(tmpElement.data+" -- ");
			tmpElement = tmpElement.next;
		}
		System.out.print("End");
		System.out.println("");
		System.out.println("");
	}
	
	public static void main(String args[]){
		
		int[] arr = {9,9};
		Node head = createLinkedList(arr);	
		
		int[] arr2 = {9,9};
		Node head2 = createLinkedList(arr2);	
		

//		printList(head3);
//		--------------------------------------------------------------------------------------------
		
		Node head3 = add(head,head2);
		Node head4 = addR(head,head2,0);
		removeDup(head);
		head = mergeSort(head);
		Node n = kLast(head,3);
		System.out.println("LL is palindrome: " + isPali(head));
		Node n1 = loopStart(head);
		
//		---------------------------------------------------------------------------------------------
		
		System.out.println(n.data);

		
	}
	
	private static Node addR(Node head1, Node head2, int carry) {
		if(head1 == null && head2 == null && carry ==0)
			return null;
		Node head3 = new Node();
		if( head1 != null)
			head3.data += head1.data;
		
		if( head2 != null)
			head3.data += head2.data;
		
		if( carry != 0)
			head3.data += carry;
		
		if(head3.data >= 10){
			head3.data %= 10;
			carry = 1;
		}
		else
			carry = 0;
		
		head3.next = addR(head1 == null? null:head1.next,head2 == null? null:head2.next,carry);
			
		return head3;
	}

	private static Node add(Node head1, Node head2) {
		Node sum = new Node();
		Node head3 = sum;
		int carry = 0;
		while(head1!= null && head2!= null){
			head3.data = head1.data + head2.data + carry;
			if(head3.data > 9)
				carry = 1;
			else
				carry= 0;
			head3.data = head3.data % 10;
			
			head1 = head1.next;
			head2 = head2.next;
			head3.next = new Node();
			head3 = head3.next;
		}
		
		while(head1 != null){
			head3.data = head1.data+carry;
			if(head3.data > 9)
				carry = 1;
			else
				carry= 0;
			head3.data = head3.data % 10;
			
			head1 = head1.next;
			head3.next = new Node();
			head3 = head3.next;
		}
		
		while(head2 != null){
			head3.data = head2.data+carry;
			if(head3.data > 9)
				carry = 1;
			else
				carry= 0;
			head3.data = head3.data % 10;
			
			head2 = head2.next;
			head3.next = new Node();
			head3 = head3.next;
		}
		
		if( carry == 1){
			head3.data = 1;
		}
		
		
		return sum;
		
	}

	public static Node loopStart(Node head){
		Node fast = head;
		Node slow = head;
		
		
		
		while(fast != null & fast.next != null  && fast != slow){
			fast = fast.next.next;
			slow = slow.next;
		}
		
		if(fast == null || fast.next == null)
			return null;
			
		while(fast != slow){
			slow = slow.next;
			head = head.next;
		}
		return slow;

	}
	
	public static boolean isPali(Node head){

		Stack<Integer> s = new Stack();
		Node fast = head;
		Node slow = head;
		
		while(fast != null && fast.next != null){
			s.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}
		if(fast!= null)
			slow = slow.next;
			
		while(slow != null ){
			if(slow.data != s.pop())
				return false;
			slow = slow.next;
			}
		return true;
	}
	
	private static Node kLast(Node head,int k) {//recursive
		if(head == null)
			return null;
		Node n = kLast(head.next,k);
		i+=1;
		if(i == k)
			return head;
		
		return n;
	}

	public static void removeDup(Node head){
		HashMap map = new HashMap();

		map.put(head.data,true);
		while(head.next!= null){
			if(map.containsKey(head.next.data))
				head.next = head.next.next;
			else{
				map.put(head.data,true);
				head =head.next;		//	wont check consecutive duplicates if written common for if and else
			}
		}
		}

	private static Node mergeSort(Node head) {
		
		if(head == null)
			return null;
		if(head.next == null)
			return head;
		
		Node slow = head;
		Node fast = head;
		
		while(fast.next!= null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		
		Node middle = slow.next;
		slow.next = null;
		
		head = mergeSort(head);
		middle = mergeSort(middle);
		head = merge(head,middle);
		return head;
		
	}

	private static Node merge(Node head, Node middle) {
		Node runner = new Node();
		Node newHead = new Node();
		
		if(head.data < middle.data){
			runner = head;
			head = head.next;
		}
		else{
			runner = middle;
			middle = middle.next;
		}
		
		newHead = runner;
		while(head!= null && middle != null){
			if(head.data < middle.data){
				runner.next = head;
				head = head.next;
			}
			else{
				runner.next = middle;
				middle = middle.next;
			}
			runner = runner.next;
		}
		
		if(head!= null)
			runner.next = head;
		else if( middle!= null)
			runner.next = middle;
		
		return newHead;
		
	}
	
	public Node recMerge(Node n1, Node n2){
		if( n1 == null)
			return n2;
		if(n2 == null)
			return n1;
		if(n1.data < n2.data){
			n1.next = recMerge(n1.next, n2);
			return n1;
		}
		else{
			n2.next = recMerge(n2.next, n1);
			return n2;	
		}
		
		
	}
}
