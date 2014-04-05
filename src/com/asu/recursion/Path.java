package com.asu.recursion;

import java.awt.Point;
import java.lang.Character.Subset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Path {
	
	public static int count =0;
	public static int[] map = {-1};

	public static void main(String[] args) {
//		
		LinkedList<Integer> ll = new LinkedList<>();
		ArrayList <Point> path = new ArrayList<>();
		HashMap<Point,Boolean> map = new HashMap<>();

//		System.out.println(success);
		System.out.println(path);
		Integer a = 2123;
		
		System.out.println();
		int[] ar = {-1,-1,-1,-1,-1,-1,-1,-1};
		String str = "abc";
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(3);
		list.add(2);
		list.add(1);
		
		ArrayList<ArrayList<Integer>> sets1 = new ArrayList<ArrayList<Integer>>();
		
//		----------------------------------------------------------------------------------------
		System.out.println("total coin combinations " + _Coins(10));
		System.out.println("total step combinations " + step(4,ar));
		boolean success =getPath(3,3,path, map);	
		ArrayList<String> sets = _getPerm(str);
		sets1 = getSubsets(list, 0);
//		-------------------------------------------------------------------------------------
		
		for (String string : sets) {
			System.out.println("String : " + string );
		}

		

		System.out.println(sets1);		
		
	}
	

	public static int step(int i,int [] ar){
//		if(i>0)
//			step(i-1);
//		if(i>1)
//			step(i-2);
//		if(i > 2)
//			step(i-3);
//		if(i < 0)
//			return 0;
//		if(i == 0)
//			count+=1;
//		return count;

		if(i<0)
			return 0;
		else if(i == 0)
			return 1;
		else if(ar[i] != -1){
			System.out.println(ar[i]);
			return ar[i];
		}
		else{
			ar[i] = step(i-1,ar) + step(i-2,ar) + step(i-3,ar);
			return ar[i];
		}
	}

	private static int _Coins(int i) {
		if(i>= 25)
			return _Coins(i - 25);
		if(i>= 10)
			return _Coins(i - 10);
		if(i>= 5)
			_Coins(i-5);
		if(i>=1)
			_Coins(i-1);
		if(i== 0)
			count+= 1;
		if(i<0)
			return 0;
		
		return count;	
		
	}

	public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index){
		
		ArrayList<ArrayList<Integer>> finalSubset;
		
		if( index == set.size()){
			finalSubset = new ArrayList<ArrayList<Integer>>();
			finalSubset.add(new ArrayList<Integer>());
		}
		else{
			finalSubset = getSubsets(set, index + 1);
			ArrayList<ArrayList<Integer>> newSubset = new ArrayList<ArrayList<Integer>>();
			for (ArrayList<Integer> subset : finalSubset) {
				ArrayList<Integer> indexSubset = new ArrayList<Integer>();
				indexSubset.addAll(subset);
				indexSubset.add(set.get(index));
				newSubset.add(indexSubset);
			}
			finalSubset.addAll(newSubset);	
		}
		
		return finalSubset;
		
	}
	
	private static ArrayList<String> _getPerm(String str) {
		
		if(str == null)
			return null;
		
		ArrayList<String> permutations = new ArrayList<String>();
		if(str.length() == 0){
			permutations.add("");
			return permutations;
		}
		
		char first = str.charAt(0);
		String remainder = str.substring(1);
		ArrayList<String> words = _getPerm(remainder);
		
		for (String word : words) {
			for (int i = 0; i <= word.length(); i++) {
				
				String s = getnewWord(first,i,word);
				permutations.add(s);
			}
		}
		

		

////	failed attempt...correct soln :- http://www.geeksforgeeks.org/lexicographic-permutations-of-string/	 or http://ideone.com/HrNtbZ
//		for (int i = 0; i < str.length(); i++) {
//			char first = str.charAt(i);
//			String start = null;
//			String end = null;
//			if(i == 0)
//				start = "";
//			else
//				start = str.substring(0, i-1);
//			if(i==str.length())
//				end = "";
//			else
//				end = str.substring(i+1);
//
//			
//			ArrayList<String> words = _getPerm(start + end);
//			for (String word : words) {
//				permutations.add(first + word);
//			}
//			
//		}
		
		return permutations;
	}
	
	ArrayList<String> getPerm( String str , HashMap<Integer,ArrayList<Character>> map){
		if( str == null )
			return null;
		
		ArrayList<String> permutations = new ArrayList<String>();
		
		if(str.length() == 0){
			permutations.add("");
			return permutations;
		}
		
		char first = str.charAt(0);
		String remainder = str.substring(1);
		
		ArrayList<String> words = getPerm(remainder, map );
		
		for( String word : words){
		
			for(int i = 0 ; i < map.get(String.valueOf(first)).size(); i++ ){
				char firstchar = map.get(String.valueOf(first)).get(i);
				String addWord = firstchar + word;
				permutations.add(addWord);
			}
		}
		
		return permutations;

	}

	private static String getnewWord(char first, int i, String str) {
		// TODO Auto-generated method stub
		String start = str.substring(0, i);
		String end = str.substring(i);
		return start + first + end;
	}

	private static boolean getPath(int x, int y, ArrayList<Point> path, HashMap<Point,Boolean> map) {
		Point p = new Point(x,y);
//		path.add(p);
		if(map.containsKey(p))
			return map.get(p);
		
		if(x==0 && y == 0)
			return true;
		boolean success = false;
		
		if(x > 0 )
			success = getPath(x-1, y, path, map);
		if(!success && y > 0)
			success = getPath(x, y-1, path, map);
		if(success)
			path.add(p);
		map.put(p,success);
		
		return success;
	
		
	}

}
