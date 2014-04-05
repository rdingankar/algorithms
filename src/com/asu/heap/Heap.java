package com.asu.heap;
//maxheap
////		http://www.youtube.com/watch?v=6NB0GHY11Iw
public class Heap {
	public int[] heap = new int[100];
	public int[] cache = new int[100];
	int i;
	public void add(int n){
		for(i = 1; heap[i]!= 0; i++);
		
		heap[i] = n;
		
		while(i/2 > 0 && heap[i/2] < heap[i]){
			swap(i/2,i);
			i = i/2;
		}		
		
	}
	
	public void delete(){
		for(i = 1; heap[i]!= 0; i++);
		heap[1] = heap[i-1];
		i=1;
		while(heap[2*i] > heap[i] || heap[2*i + 1] > heap[i]){
			if(heap[2*i] > heap[2*i + 1])
				swap(2*i, i);
			else
				swap(2*i + 1, i);
		}
	}
	
	public void print(){
		for(i = 0; i< heap.length &&  heap[i]!= 0 ; i++)
			System.out.println(" " + heap[i]);
		
	}
	private void swap(int j, int k) {
		int temp;
		temp = heap[j];
		heap[j] = heap[k];
		heap[k] = temp;
		
	}
	public static void main(String[] args) {
		
		int [] array = { 12,33,11,65,44,14,17,102,22,9,999,6};
		Heap h = new Heap();
		h.heap = array;
//		h.heapsort();
//		h.createHeap(h.heap.length);
		h.kHeapSort(2);
//		int max = h.getMax();
//		System.out.println("maximum is " + max);
		h.print();
		
	}

	private int getMax() {
		createHeap(heap.length);
		int max = heap[0];
		heap[0] = heap[heap.length-1];
		heapify(0,heap.length-2);
			
		return max;
	}

	private void kHeapSort(int k) {
		createHeap(k + 1);
		
		
	}


	private void heapsort() {
		createHeap(heap.length);
		for(int size = heap.length - 1 ; size > 0 ; size-- ){
			swap(0,size);
			heapify(0,size-1);
		}
	}

	private void createHeap(int size) {
		for(double i = Math.ceil((size-2)/2); i>=0;i--){
			heapify((int) i, size -1);
		}
		
	}

	private void heapify(int i, int last) {
		int greatest = i;
		int left = (i<<1) +1;
		int right = (i+1)<<1;
		if(left <= last && heap[left] > heap[greatest])
			greatest = left;
		if (right <= last && heap[right] > heap[greatest])
			greatest = right;
		
		if(greatest!= i){
			swap(greatest,i);
			heapify(greatest, last);			
		}
		
	}


}
