package com.asu.linkedlist;
public class Node{ 
		Node next;
		int data;
		
		public Node(int data){
			this.data = data;
			this.next = null;
		}	
		
		public Node(){
			this.next = null;
		}
		

		public void append( int d){
			Node end = new Node(d);
			
			Node n = this;
			while(n.next != null){
				n = n.next;
			}
			n.next = end;
		}
		
		public Node delete( int d){
			Node n = this;
			
			if( n.data == d)							// data is at head itself
				return n.next;
			else{
				
				while(n.next != null){
					if(n.next.data == d){
						n.next = n.next.next;
						return n;						//no need to run while loop
					}
					else
						n = n.next;
				}
				return n;								// data not found
			}
			
		}
	}	