package com.asu.algo;

public class MaxSum {

	private int a[] = {-1,-2,5,-3,7,8,-2,5,7,1};
	private int b[] = new int[10];
	private int Msum = 0;
	public int j = 0;
	
	public void run(){
		int sum = 0;
		
		for (int i = 0; i < a.length -1; i++) {
			if(a[i+1] > a[i] ){
				sum = sum + a[i];
				if(Msum  < sum + a[i+1]){
					Msum = sum + a[i+1];
					
				}
			}
			else{
				
				sum = 0 ;
			}
		}
		
		System.out.println(Msum);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MaxSum a = new MaxSum();
		a.run();

	}

}
