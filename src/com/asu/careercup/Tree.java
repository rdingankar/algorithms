package com.asu.careercup;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

//http://www.geeksforgeeks.org/remove-all-nodes-which-lie-on-a-path-having-sum-less-than-k/
//wrong code
public class Tree {

	static int count =0;
	public static void main(String[] args) {
		 int k = 145;
		    Node root = new Node(1);
		    root.left = new Node(2);
		    root.right = new Node(6);
		    root.left.left = new Node(16);
		    root.left.right = new Node(3);
//		    root.right.left = new Node(5);
//		    root.right.right = new Node(7);
//		    root.right.right.right = new Node(9);
//		    root.right.left.right = new Node(10);
//		    root.left.left.left = new Node(8);
//		    root.left.left.right = new Node(19);
//		    root.left.right.left = new Node(12);
//		    root.right.right.left = new Node(100);
//		    root.right.right.left.right = new Node(11);
//		    root.left.left.right.left = new Node(13);
//		    root.left.left.right.right = new Node(14);
//		    root.left.left.right.right.left = new Node(15);
		    
		    Node bRoot = null;
		    
		    bRoot = _addBST(bRoot,3);
		    bRoot = _addBST(bRoot,2);
		    bRoot = _addBST(bRoot,5);
		 
//		    System.out.println("Tree"); 
//		    print(bRoot);
		    System.out.println(" Tree is Balanced " + _isBalanced(bRoot));
		    System.out.println("Leaves are at same level" + _isSameLevel(bRoot, 0));


//		    -------------------------------------------------------------------------------------------------
		    System.out.println(" Tree is BST " + _isBST(bRoot,Integer.MIN_VALUE,Integer.MAX_VALUE));		    
		    nonrecMirror(root);
		    mirror(root);
		    printBFS(root);
		    _printLevels(root);
		    int value = _isBalancedOpt(bRoot);
		    Node n = commonAnc(root,new Node(16),new Node(2));	
		    int[] arr = {1,2,6};
//		    -------------------------------------------------------------------------------------------------
	    
		    
		   
//		    System.out.println("Tree after mirror"); 
		    print(root);
//		    System.out.println("Tree after mirror");
//		    System.out.println();
//		    print(root);

		    
		    int a=19;
		    int b = 100;
		    int c = lCA(root, 16,3);	    

//		    

		    System.out.println(n.data);
		    

//		    
//		    print(bRoot);
		    
	}
	
	Node inorderSucc( Node n){

		if( n == null)
			return null;
			
		if( n.right != null){
			n = n.right;
			while(n.left != null){
			n = n.left;
			}
			
			return n;
		}
		
		while( n.parent != null && n != n.parent.left)
			n = n.parent;
		
		return n.parent;
	}

	
	static Node commonAnc( Node root, Node p, Node q){
		if(root == null)  // no node found
			return null;
			
		if(root.data == p.data && root.data == q.data) // both p and q are same
			return root;
			
		Node left = commonAnc(root.left, p, q);
		
		
		Node right = commonAnc(root.right, p,q);
			
		if(root.data == p.data || root.data == q.data)
			return root;
		
		else if(left != null && right != null)
			return root;
			
		else 
			return left == null? right: left;			// return non null Node
	}
	

	private static void _printLevels(Node root) {
	LinkedList<Node> q = new LinkedList<>();
		
		int inCurrentLevel = 1;
		int inNextLevel = 0;
		q.add(root);
		
		while(!q.isEmpty()){
			Node temp;
			temp = q.remove();
			inCurrentLevel --;
			
			System.out.println(temp.data);
			if(temp.left != null){
				q.add(temp.left);
				inNextLevel++;
			}
				
			if(temp.right != null){
				q.add(temp.right);
				inNextLevel++;
			}
			
			if(inCurrentLevel == 0){
				System.out.println();
				inCurrentLevel = inNextLevel;
				inNextLevel =0;
			}
		}		
	}


	private static boolean _isSameLevel(Node root, int level) {// here single child condition not handled // diff from complete tree
				
		if(root == null)
			return true;
		if(root.left == null && root.right == null){
			if(count == 0){
				count = level;
				return true;
			}
			else
				return (count == level);
		}

		return (_isSameLevel(root.left, level + 1)  && _isSameLevel(root.right, level + 1));
	}


	private static int _isBalancedOpt(Node bRoot) {// DFS
		// TODO Auto-generated method stub
		int height;
		int heightDiff;
		int lheight;
		int rheight;
		
		if( bRoot == null)
			return 0;
	
		lheight = _isBalancedOpt(bRoot.left);
		if(lheight == -1)
			return -1;
		rheight = _isBalancedOpt(bRoot.right);
		if(rheight == -1)
			return -1;
		heightDiff = lheight - rheight;
		
		if(Math.abs(heightDiff) <=1)
			return Math.max(lheight, rheight) + 1;
		else
			return -1;

	}


	private static boolean _isBalanced(Node root) {
		if(root == null)
			return true;
		else
			return( _isBalanced(root.left) && _isBalanced(root.right) && ( Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1 ));
//		return false
	}


	private static int getHeight(Node root) {
		if(root == null)
			return 0;
		else
			return( Math.max(getHeight(root.left), getHeight(root.right)) + 1);
	}


	private static boolean _isBST(Node root, int minValue, int maxValue) {
		
		if ( root == null )
			return true;
		if( root.data <= minValue  || root.data > maxValue)
			return false;
		else
			return ( _isBST(root.left, minValue, root.data) && _isBST(root.right, root.data, maxValue));
		
	}
	
	Node commonAncestor( Node root, Node p , Node q){
		
		if( root == null)
			return null;
		else if(root == p && root == q)
			return root;
		
		Node x = commonAncestor(root.left, p, q);
		if( x != null && x!= p && x!= q)		// found ancestor so no need to look again
			return x;
		
		Node y = commonAncestor(root.left, p, q);
		if( y != null && y!= p && y!= q)
			return y;
		
		if( x != null && y != null)
			return root;
		else if(root == p ||root == q)
			return root;
		else if(x!= null)
			return x;
		else
			return y;
		
	}


	private static Node _addBST(Node bRoot, int data) {
				
		if(bRoot == null){
			Node temp = new Node();
			temp.data = data;
			return temp;
		}
		
		if(data <= bRoot.data)
			bRoot.left = _addBST(bRoot.left,data);
		else
			bRoot.right = _addBST(bRoot.right,data);
		
		return bRoot;
	}

	private static int lCA(Node root, int a, int b) {
		
		Node temp= root;
		int result=0;
		if(temp == null)
			return 0;
		if(temp.data == a || temp.data == b)
			return ( 1 + lCA(temp.left,a,b) + lCA(temp.right,a,b) ); // recursive calls needed as one node can be child of other
		else
			result = lCA(temp.left,a,b) + lCA(temp.right,a,b);


		if(result == 2)
			return temp.data;
		
		return result;
		
		
	}



	private static void printBFS(Node root) {
		LinkedList<Node> q = new LinkedList<>();
		
		int newLevel = 0;
		root.level = 1;
		q.add(root);
		
		while(!q.isEmpty()){
			Node temp;
			temp = q.remove();
			
			if(newLevel != temp.level){
				System.out.println();
				newLevel ++;
				
				
			}
		
			System.out.println(temp.data);
			if(temp.left != null){
				temp.left.level = temp.level +1;
				q.add(temp.left);
			}
			if(temp.right != null){
				temp.right.level = temp.level +1;
				q.add(temp.right);
			}
		}
		
	}


	private static void nonrecMirror(Node root) {
		Stack<Node> s = new Stack<Node>();
		
		while(root != null){
			s.push(root);
			root = root.left;
		}
		
		while(!s.isEmpty()){
			root = s.pop();
			
			Node temp;
			temp = root.left;
			root.left = root.right;
			root.right = temp;
			
			root = root.left;			//for inorder traversal this would be root = root.right
			while(root != null){
				s.push(root);
				root = root.left;
			}
			
		}
			
		
	}


	private static void mirror(Node root) {//inorder wont work
		
		if(root == null)
			return;
		
		Node temp;
		temp = root.left;
		root.left = root.right;
		root.right = temp;	
		mirror(root.left);
		mirror(root.right);	
		
		
	}



	private static void print(Node root) {
		
		if(root == null)
			return;
		
		System.out.println("<--" + root.data + "-->");
		print(root.left);	
		print(root.right);
		
	}

}
