package com.asu.linkedlist;
import java.io.*;
import java.util.*;

class Node1 {
    int data;
    Node1 next;
  
    Node1(int data) {
        this.data = data;
        this.next = null;
    }
}

public class TestLL {
    
    private static Node1 head = null;
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int data = -1;
      
      
        System.out.println("Enter -1 to stop adding Node1s to linked list");
        data = Integer.parseInt(br.readLine());
        do {
            addNode1(data);
            data = Integer.parseInt(br.readLine());  
        } while(data != -1);
      
        System.out.println("Finished creating linked list");
        System.out.println("Original linked list :");
        printLL(head);
        
        head = mergeSort(head);
        System.out.println("Merge sort output:: ");
        printLL(head);
        
       /* sortedInsert(head);
        System.out.println("\nAfter sorted insert: ");
        printLL(head);
        
       //System.out.println("\nPalindrome: " + checkPalindrome(head));
        
        /*System.out.println("\nAfter reverse");
        printLL(reverse(head));
        System.out.println("\nEnter k: ");
        int k = Integer.parseInt(br.readLine());
        Node1 newHead = kThToLast(head, k);
        System.out.println("\nRequired list is as follows : ");
        printLL(newHead);
        removeDups(head);
        System.out.println("\nNew linked list :");
        printLL(head);*/
        /*Node1 head1 = new Node1(4);
        head1.next = new Node1(4);
        
        Node1 head2 = new Node1(2);
        head2.next = new Node1(3);
        System.out.println("hahahah");
        Node1 newHead = merge(head1, head2);
        printLL(newHead);*/
        
    }
    
    public static Node1 mergeSort(Node1 head) {
        int length = getLength(head);
        if(length == 1) {
            return head;
        }
        Node1 middle = getMiddle(head, length);
        Node1 current = head;
        while(current != middle) {
            current = current.next;
        }
        Node1 temp = current.next;
        current.next = null;
        head = mergeSort(head);
        temp = mergeSort(temp);
        head = merge(head, temp);
        return head;
    }
    
    private static Node1 merge(Node1 head, Node1 middle) {
        Node1 ptr1 = head;
        Node1 ptr2 = middle;
        Node1 newHead = null;
        Node1 tail = null;
        while(ptr1 != null && ptr2 != null) {
            if(ptr1.data > ptr2.data) {
                if(newHead == null) {
                    newHead = ptr2;
                    tail = newHead;
                    ptr2 = ptr2.next;
                } else {
                    tail.next = ptr2;
                    tail = tail.next;
                    ptr2 = ptr2.next;
                }
            } else {
                if(newHead == null) {
                    newHead = ptr1;
                    tail = newHead;
                    ptr1 = ptr1.next;
                } else {
                    tail.next = ptr1;
                    tail = tail.next;
                    ptr1 = ptr1.next;
                }
            }
        }
        if(ptr1 == null) {
            while(ptr2 != null) {
                tail.next = ptr2;
                tail = tail.next;
                ptr2 = ptr2.next;
            }
        }
        if(ptr2 == null) {
            while(ptr1 != null) {
                tail.next = ptr1;
                tail = tail.next;
                ptr1 = ptr1.next;
            }
        }
        return newHead;
        
    }
    
    private static Node1 getMiddle(Node1 head, int length) {
        int times = 0, counter = 1;
        Node1 current = head;
        if(length%2 == 0) {
            // even Node1s
            times = length/2;
        } else {
            // oddd Node1s
            times = length/2 + 1;
        }
        while(counter < times) {
            current = current.next;
            counter++;
        }
        return current;
    }
    
    private static int getLength(Node1 head) {
        Node1 current = head;
        int len = 0;
        while(current != null) {
            len++;
            current = current.next;
        }
        return len;
    }
    public static void sortedInsert(Node1 head) {
        Node1 current = head;
        while(current != null) {
            if(current.next.data < current.data) {
                break;
            }
            current = current.next;
        }
        Node1 newHead = current.next;
        current.next = null;
        current = newHead;
        while(current != null) {
            Node1 temp = current.next;
            insert(head, current);
            current = temp;
            
        }
    }
    
    private static void insert(Node1 head, Node1 newHead) {
        Node1 current = head;
        while(current != null && current.next != null) {
            if(newHead.data >= current.data && newHead.data < current.next.data) {
                // insert a Node1 between current and current.next
                Node1 temp = current.next;
                current.next = newHead;
                newHead.next = temp;
            }
            current = current.next;
        }
    }
    
    public static boolean checkPalindrome(Node1 head) {
        Node1 revHead = reverse(head);
        boolean flag = true;
        for(Node1 curr = head, curr2 = revHead; curr != null && curr2 != null && flag == true; curr = curr.next, curr2 = curr2.next) {
            if(curr.data == curr2.data) {
                flag = true;
            } 
            else flag = false;
        }
        return flag;
    }
    
    public static Node1 reverse(Node1 head) {
        Node1 temp = head;
        Node1 temp1 = temp.next;
        Node1 temp2 = null;
        while(temp1 != null) {
            temp.next = temp2;
            temp2 = temp;
            temp = temp1;
            temp1 = temp.next;    
        }
        temp.next = temp2;
        return temp;
    }
    
    
    public static void addNode1(int data) {
        Node1 newNode1 = new Node1(data);
        Node1 current = head;
        
        if(head == null) {
            head = new Node1(data);
            return;
        }
      
        while(current.next != null) {
            current = current.next;
        }
        current.next = newNode1;
    }

    public static Node1 deleteFromLL(Node1 head, int data) {
        Node1 current = head;
        if(head.data == data) {
            return head.next;
        }
        else {
            while(current.next != null) {
                if(current.next.data == data) {
                    current.next = current.next.next;
                }
                current = current.next;
            }
        }
        return head;
    }
  
  
    public static Node1 kThToLast(Node1 head, int k) {
        Node1 temp = head, current = head;
        int count = 0;
        while(count <= k) {
            temp = temp.next;
            count++;
        }
        while(temp != null) {
            temp = temp.next;
            current = current.next;
        }
        return current;
    }
   
    public static void printLL(Node1 head) {
        Node1 current = head;
        while(current != null) {
            System.out.print("   " + current.data);
            current = current.next;
        }
    }
  
    public static void removeDups(Node1 head) {
        Hashtable table = new Hashtable();
        Node1 temp = null;
        while(head != null) {
            if(table.containsKey(head.data)) {
                temp.next = head.next;
            }
            else {
                table.put(head.data, true);
                temp = head;
            }
            head = head.next;
        }
    }
}
