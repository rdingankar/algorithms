package com.asu.careercup;
public class Node{ 
		int data;
		int level;
		Node left;
		Node right;
		Node parent;
		
		public Node(int data){
			this.data = data;
			this.left = null;
			this.right = null;
			this.level = 0;
		}	
		
		public Node(){
			this.data = 0;
			this.left = null;
			this.right = null;
			this.level = 0;
		}
		
}