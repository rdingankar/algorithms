package com.asu.linkedlist;

public class ReverseLinkedList {
	
	
	public static void main(String[] args) {
		
		 Node element = new Node(1);
		
		 Node element1 = new Node(2);
		 
		 Node element2 = new Node(3);
		 Node element3 = new Node(4);
		 Node element4 = new Node(5);
		 
		 Node element5 = new Node(6);
		 
		 Node element6 = new Node(7);
		 
		 Node element7 = new Node(8);
		 Node element8 = new Node(9);
		 Node element9 = new Node(10);
		 
		 Node element10 = new Node(11);
//		 Node element2 = new Node();
		 
		 element.next= element1;
		 element1.next = element2;
		 element2.next= element3;
		 element3.next = element4;
		 element4.next= element5;
		 
		 element5.next= element6;
		 element6.next = element7;
		 element7.next= element8;
		 element8.next = element9;
		 element9.next= element10;
//		 element5.next = element2;
		
		 printList(element);
		 
//		 Node elementr = reverse(element);
		 //Normal Printing of List
//		 printList(elementr);
		 
		 Node reverse = reverseK(element,3);
		 
//		 Node reverse = recursiveLL(element);
		 printList(reverse);
	}
//	http://stackoverflow.com/questions/354875/reversing-a-linked-list-in-java-recursively
	public static Node recursiveLL( Node head ){
		if( head == null)
			return null;
		
		if(head.next == null)
			return head;
		
//		Node next = head.next;
//		
//		head.next = null;
//		Node newHead = recursiveLL(next);
//		next.next = head;
//		return newHead;
		
		Node newHead = recursiveLL(head.next);
		head.next.next = head;
		head.next = null;
		
		return newHead;
		
	}
	
	public static Node reverseList(Node oldHead){
		
		Node newHead = null;
		Node prevHead = null;
		
//		newHead = null;
//		prevHead = null;
		
		while(oldHead != null){
			
			newHead = oldHead;
			oldHead = oldHead.next;
			newHead.next = prevHead;		
			prevHead = newHead;
			
		}
		return newHead;
	}
	
public static Node reverseK(Node head, int k){
		
		Node oldHead = head;
		Node prevHead = null;
		Node newHead = null;
		
		int i = 0;
		
		while(oldHead != null && i < k){
			newHead = oldHead;
			oldHead = oldHead.next;
			newHead.next = prevHead;
			prevHead = newHead;
			i++;
		}
		
		if( oldHead!= null)// check
			head.next = reverseK(oldHead, k);
		
		return newHead;
		
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

}
