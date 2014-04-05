package com.asu.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

//http://www.geeksforgeeks.org/remove-all-nodes-which-lie-on-a-path-having-sum-less-than-k/
//wrong code
public class Prune {

	static int count =0;
    static Node head = null;
    static Node tail = null;
	public static void main(String[] args) {
		 int k = 145;
		 
		    Node root = new Node(4);
		    root.left = new Node(2);
		    root.right = new Node(6);
		    root.left.left = new Node(1);
		    root.left.right = new Node(3);
		    root.right.left = new Node(5);
		    root.right.right = new Node(7);
//		    root.left.left.left = new Node(8);
//		    root.left.left.right = new Node(9);
//		    root.left.right.left = new Node(12);
//		    root.right.right.left = new Node(10);
//		    root.right.right.left.right = new Node(11);
//		    root.left.left.right.left = new Node(13);
//		    root.left.left.right.right = new Node(14);
//		    root.left.left.right.right.left = new Node(15);
		 
//		    System.out.println("Tree before truncation"); 
//		    print(root);
		 
//		    Node newRoot = pruneTree(root, 45); 
//		    ------------------------------------------------------------------------------------
		    Node newRoot = deleteSumPath(root, 0 ,9);
		    addGreater(root);
		    leftViewUtil(root,1,0);
		    getCousins(root,4);
//		    longestPath
//		    getFreq
		    printSpiral(root);
		    int[] path = new int[10];
//		    printAllpaths(root, path ,0);

//		    toList1(root);
//		    http://cslibrary.stanford.edu/109/TreeListRecursion.html
		    Node header = toList2(root);
		    System.out.println(header.data);
//		    while(header!= null){
//		    	System.out.println(header.data);
//		    	header = header.right;
//		    }
//		    ----------------------------------------------------------
//		    print(root);
		    
		 

	}
private static Node toList2(Node root) {
	
		if(root == null)
			return null;
		Node leftList = toList2(root.left);
		Node rightList = toList2(root.right);
		
		root.left = root;
		root.right = root;
		
		leftList = append(leftList,root);
		leftList = append(leftList,rightList);
		
		return leftList;
		
	}
	private static Node append(Node leftList, Node rightList) {
		
		if(leftList == null)
			return rightList;
		if(rightList == null)
			return leftList;
		
		Node leftTail = leftList.left;
		Node rightTail = rightList.left;
		
		leftTail.right = rightList;
		rightList.left = leftTail;
		leftList.left = rightTail;
		rightTail.right = leftList;

	return leftList;
}
	//inorder + static variable	
	private static void toList1(Node root) {
		if(root == null)
			return;
		toList1(root.left);
		if(head == null){
			head = root;
			tail = root;
		}
		else{
			tail.right = root;
			root.left = tail;
			tail = tail.right;
		}
		toList1(root.right);
		
	}

	public static void printAllpaths( Node n, int[] path,int length ){
		if( n == null){
			print(path, length);
			System.out.println();
			return;
		}
		path[length] = n.data;
		printAllpaths( n.left, path,length + 1 );
		printAllpaths( n.right, path,length + 1 );
	}

	public static void print( int[] path, int length ){
		for( int i = 0; i< length; i++)
			System.out.print( path[i] );
	}
	
	public static void printSpiral( Node n){
		Stack<Node> p = new Stack<Node> ();
		LinkedList<Node> c = new LinkedList<Node> ();
		int lvl =0;
		
		
		c.push(n);

		while( !c.isEmpty() ){
			lvl ++;
			p.clear();
			while( !c.isEmpty() ){
				p.add(c.pop() );
			}
	
			// print p;
	
			if( lvl % 2 == 0){
			
				for( Node l : p){
					System.out.println( l.data );
					if(l.left != null)
						c.push( l.left);
					if(l.right != null)
						c.push( l.right);
				}	
			}
	
			else{
				for( Node l : p){
					System.out.println( l.data );
					if(l.right != null)
						c.push( l.right);
					if(l.left != null)
						c.push( l.left);
				}	
			}
		}
		
	}
	
	private static void getCousins(Node root, int f) {
		ArrayList<Node> current = new ArrayList<Node>();
		ArrayList<Node> parent= new ArrayList<Node>();
		
		current.add(root);

		while(current != null){
			boolean flag = false;
			parent.clear();
			parent.addAll(current);
			current.clear();
			for(Node n : parent) {
				if( n.left.data == f || n.right.data == f)
					flag = true;
				if(n.left != null)
					current.add(n.left);
				if(n.right != null)
					current.add(n.right);
			}
			if(flag)
				break;
		
		
		}

		for( Node n : parent){
			if(n.left != null && n.left.data != f && n.right.data != f)
				System.out.println(n.left.data);
			if(n.right != null && n.left.data != f && n.right.data != f)
				System.out.println(n.right.data);

		}
		
	}

	ArrayList<LinkedList<Node>>createLvlLL( Node root){
		ArrayList<LinkedList<Node>> result = new ArrayList<LinkedList<Node>>();
		LinkedList<Node> current = new LinkedList<Node>();
		
		if(root!= null)
			current.add(root);
		while(current.size() > 0){
			result.add(current);
			LinkedList<Node> parents = current;
			current = new LinkedList<Node>();
			
			for(Node parent : parents){
				if(parent.left!= null)
					current.add(parent.left);
				if(parent.right != null)
					current.add(parent.right);
			}
		}
		
		return result;
}
	
	
	
	
	boolean contains(Node t1, Node t2){
		if( t2 == null)
			return true;
		if( t1 == null)
			return false;
		if(t1.data == t2.data)
			if(match(t1,t2))
				return true;
		return ( contains(t1.left,t2) || contains(t1.right,t2) );

	}

	boolean match( Node t1, Node t2){
		if(t1 == null && t2 == null)
			return true;
			
		if(t1 == null || t2 == null)
			return false;
			
		if(t1.data != t2.data)
			return false;
			
		return ( match(t1.left,t2.left) && match(t1.right, t2.right) );

	}
	
	static Node createBST( int[] arr, int start, int end){
		Node n = null;
		if(start <= end){
			int middle = ( start + end )/ 2;
			n = new Node(arr[middle]);
			n.left = createBST(arr,start, middle-1);
			n.right = createBST(arr,middle + 1, end );
		}
		return n;
	}
	static void leftViewUtil(Node root, int level, int printed_level)
	{
	    // Base Case
	    if (root==null)
	    	return;
	 
	    // If this is the first node of its level
	    if (printed_level < level)
	    {
	       System.out.println(root.data);
	        printed_level = level;
	    }
	 
	    // Recur for left and right subtrees
	    leftViewUtil(root.left, level+1, printed_level);
	    leftViewUtil(root.right, level+1, printed_level);
	}

	public static Node deleteSumPath(Node root, int sum, int value) {
		
		if(root == null)
			return null;
		
		sum += root.data;
		if(root.left == null && root.right == null){
			if(sum < value)
				return null;
		}
		
		root.left = deleteSumPath(root.left, sum, value);
		root.right = deleteSumPath(root.right, sum, value);
		
		return root;
		
	}
	private static void print(Node root) {
		
		if(root == null)
			return;
		
		
		System.out.println("<--" + root.data + "-->");
		print(root.left);
		print(root.right);
		
	}
	
	private static void addGreater(Node root) {

		if(root == null)
			return;
		
		addGreater(root.right);
		count += root.data;
		root.data = count;
		addGreater(root.left);
			
		
	}
	
	public static void getFreq(Node root){
		HashMap<Integer,Integer> map = new HashMap();
		
		LinkedList<Node> q = new LinkedList();
		q.add(root);
		
		while(!q.isEmpty()){
			
			Node n = q.remove();
			if(map.containsKey(n.data))
				map.put(n.data, map.get(n.data) + 1);
			else
				map.put(n.data, 1);
			
			q.add(n.left);
			q.add(n.right);
		}
	}
	
	public boolean longestPath( Node n, int depth, int level, ArrayList<Node> path){
		if( n == null)
			return false;
		
		if(level == depth-1)
			return true;
		
		boolean success = false;
		if(n.left != null)
			success = longestPath(n.left, depth, level +1, path);
		
		if(! success && n.left != null)
			success = longestPath(n.left, depth, level +1, path);
		
		if(success)
			path.add(n);
		return success;
			
			
	}
	
	
//	private static Node pruneTree(Node root, int k) {
//
//		if(root == null)
//			return null;
//
//		int lpathSum;
//		int rpathSum;
//		int pathSum;
//		
//		count += root.data;
//		lpathSum = count;
//		rpathSum = lpathSum;
//		
//		root.left = pruneTree(root.left, k);
//		root.right = pruneTree(root.right, k);
//		
//		pathSum = max(lpathSum,rpathSum);
//		
//		if(pathSum < k)
//		{
//			root = null;
//		}
//		
//		return root;
//		
//	}
//
//	private static int max(int lpathSum, int rpathSum) {
//
//		if(lpathSum > rpathSum)
//			return lpathSum;
//		else
//			return rpathSum;
//	}
//
//	private static boolean hasTwoChild(Node root) {
//		if(root.left != null  && root.right != null)
//			return true;
//		else
//			return false;	
//	}
//
//	private static boolean hasSingleChild(Node root) {
//		// TODO Auto-generated method stub
//		if((root.left != null  && root.right == null) || (root.left != null  && root.right == null))
//			return true;
//		else
//			return false;		
//	}

}
