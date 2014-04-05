package com.asu.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode mid;
    
    TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.mid = null;
    }
}


public class TriTreeImpl {

  
    private static TreeNode root = null;

  
    public TreeNode insert(TreeNode root, int data) {
        if(root == null) {
            root = new TreeNode(data);
            return root;
        }
        else if(data < root.data) {
            root.left = insert(root.left, data);
        }
        else if(data > root.data) {
            root.right = insert(root.right, data);
        }
        else if(data == root.data) {
            root.mid = insert(root.mid, data);
        }
        return root;
    }
  
  
    public void printTree(TreeNode root) {
        if(root == null)
            return;
      
        printTree(root.left);
        System.out.println(root.data + "    ");
        printTree(root.mid);
        printTree(root.right);
    }
  
    private TreeNode findMin(TreeNode root) {
        while(root.left != null)
            root = root.left;
       return root;
    }
 
  
    public TreeNode delete(TreeNode root, int data) {
        if(root == null)
            return null;
        else if(data < root.data)
            root.left = delete(root.left, data);
        else if(data > root.data)
            root.right = delete(root.right, data);
        else {
            if(root.left == null && root.mid == null && root.right == null) {
                return null;
            }
            
            if(root.mid != null) {
                root.mid.left = root.left;
                root.mid.right = root.right;
                return root.mid;
            }
            
            else if(root.right == null) {
                return root.left;
            }
            
            else if(root.left == null) {
                return root.right;
            }
            else {
                root.data = findMin(root.right).data;
                delete(root.right, root.data);
            }
        }
        return root;
    }
  
      private void processInput(String[] args) {
        for(int i=0; i < args.length; i++) {
            root = insert(root, Integer.parseInt(args[i]));

        }
    }
      
    public static void main(String[] args) {
        // take inputs from command line argument
        TriTreeImpl obj = new TriTreeImpl();
        obj.processInput(args);
        System.out.println("The tree elements are as follows: ");
        obj.printTree(root);
        System.out.println("Enter an elemnt to delete: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int key;
        try {
            key = Integer.parseInt(br.readLine());
            obj.delete(root, key);
            System.out.println("Tree after deletion is - ");
            obj.printTree(root);
        } catch (NumberFormatException e) {
            System.out.println("Error in deletion - " + e);
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error in deletion - " + e);
            e.printStackTrace();
        }
    }


  

}
