package com.asu.algo;

public class TrinaryTree {
	public int data;
	public TrinaryTree left;
	public TrinaryTree middle;
	public TrinaryTree right;
	
	public TrinaryTree(int d) {
		data = d;
		left = null;
		right = null;
		middle = null;
	}
	public TrinaryTree(){
		data = 0;
		left = null;
		right = null;
		middle = null;
	}

	
	public static TrinaryTree delete(TrinaryTree root, int d){
		
//		--------	Case 1: the root itself has to be deleted.-------------
			if(root.data == d){
//				Case 1.1 : If there are more than one TrinaryTrees with the value to be deleted
				TrinaryTree temp = root;
				if(root.middle != null){
					
					while(temp.middle.middle != null)
						temp = temp.middle;
					temp.middle = null;
					
					return root;
				}
//				Case 1.2 if root has only left child
				else if(root.right == null)
					return root.left;
//				Case 1.3 if root has only right child
				else if(root.left == null)
					return root.right;
				else {
//				Case 1.4 : root has both left and right
				
//				get the smallest TrinaryTree from right subtree of the TrinaryTree to be deleted
					TrinaryTree replacement = getLeftmost(root.right);
//				replace the TrinaryTree to be deleted with this TrinaryTree
					replacement.left = root.left;
					replacement.right = root.right;
						return replacement;
				}
			}
		//---------------------------------------------------------

			
//			get the TrinaryTree to be deleted and its parent
			TrinaryTree parent = getParent(root, d);
//			if TrinaryTree not found
			if(parent ==null)
				return root;
			TrinaryTree toDelete = parent.right;
			boolean isLeftchild = false;
			
			if( parent.left.data == d)
			{
				isLeftchild = true;
				toDelete = parent.left;
			}
			
//			Case 2 : If there are more than one TrinaryTrees with the value to be deleted
			
			if(toDelete.middle != null){
				while(toDelete.middle.middle != null)
					toDelete = toDelete.middle;
				toDelete.middle = null;
						
			}
				
//			Case 3 : If left is null , join right subtree inplace of TrinaryTree to be deleted
			else if(toDelete.left == null){
				if(isLeftchild)
					parent.left = toDelete.right;
				else
					parent.right = toDelete.right;
			}
//			Case 4 : If right is null , join left subtree inplace of TrinaryTree to be deleted
			else if(toDelete.right == null){
				if(isLeftchild)
					parent.left = toDelete.left;
				else
					parent.right = toDelete.left;
			}
					
//			Case 5 : has both left and right
			else{				
//			get the smallest TrinaryTree from right subtree of the TrinaryTree to be deleted
				TrinaryTree replacement = getLeftmost(toDelete.right);
//			replace the TrinaryTree to be deleted with this TrinaryTree
				replacement.left = toDelete.left;
				replacement.right = toDelete.right;
				if(isLeftchild)
					parent.left = replacement;
				else
					parent.right = replacement;
			}
			
			return root;	
		}

	public static TrinaryTree insert(TrinaryTree root, int d){
//			tree is empty
			if(root == null)
				return new TrinaryTree(d);

			TrinaryTree runner = root;
			TrinaryTree parent = runner;
			while(runner != null){
				parent = runner;
//				tree already contains TrinaryTree
				if(runner.data == d){
					while(runner.middle != null)
						runner = runner.middle;
					runner.middle = new TrinaryTree(d);
					return root;
				}
				else if(d < runner.data)
					runner = runner.left;
				else if(d > runner.data)
					runner = runner.right;
			}
			if(d >parent.data)
				parent.right = new TrinaryTree(d);
			else
				parent.left = new TrinaryTree(d);
			
			return root;	
		}
		
	private static TrinaryTree getParent(TrinaryTree root, int d) {
//			TrinaryTree not found
			if(root.left == null || root.right == null)
				return null;
			if(d == root.left.data || d == root.right.data)
				return root;
			else if(d < root.data)
				return getParent(root.left, d);
			else
				return getParent(root.right, d);
		}

	private static TrinaryTree getLeftmost(TrinaryTree n) {
			while(n.left != null)
				n = n.left;
			return n;
		}
	
	public static void main(String args[]){
		
		TrinaryTree t = null;
		t = insert(t, 5);
		t = insert(t, 4);
		t = insert(t, 5);
		t = insert(t, 5);
		t = insert(t, 7);
		t = insert(t, 2);
		t = insert(t, 2);
		System.out.println("Tree before deletion");
		print(t);
		
		t = delete(t,5);
		
		System.out.println("Tree after deletion");
		print(t);
	}
	private static void print(TrinaryTree t) {
//		Inorder tree traversal
		if(t == null)
			return;
		System.out.println("<-" + t.data + "->");
		print(t.middle);
		print(t.left);
		print(t.right);
				
	}
}
