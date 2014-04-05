package com.asu.codility;


//you can also use imports, for example:
//import java.math.*;
import java.util.Arrays;
class Solution {
 public int solution(int[] A) {
     if( A == null)
         return 0;
     if( A.length < 3)
         return 0;
     Arrays.sort(A);
     
     if( A[0]*A[1]*A[2] >= A[A.length - 1]*A[A.length - 2]*A[A.length - 3])
         return A[0]*A[1]*A[2];
     else
        return A[A.length - 1]*A[A.length - 2]*A[A.length - 3]; 
 }
}