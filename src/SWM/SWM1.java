package SWM;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SWM1 {
	public static void main(String args[]) { 
	    Scanner sc = new Scanner(System.in);
	    
	    char[] char_ar = sc.nextLine().toCharArray();
	    
	    HashMap<Character, Node> map = new HashMap<>();
	    
	    for(int i=0 ; i<char_ar.length ; i++) {
	    	char now = char_ar[i];
	    	map.put(now, new Node(now));	
	    }
	    	    
	    int n = sc.nextInt();
	    
	    for(int i=0 ; i<n ; i++) {
	    	String[] st = sc.nextLine().split(" ");
	    	char parent = st[0].charAt(0);
	    	char child = st[1].charAt(0);
	    	
	    	Node cnode = map.get(child);
	    	Node pnode = map.get(parent);
	    	
	    	cnode.parent = parent;
	    	pnode.children.add(child);
	    }
	    
	    for(Character key : map.keySet()) {
			if(map.get(key).children.size()==0) {
				
			}
		}
	    
	  }
	
	static class Node{
		char parent;
		ArrayList<Character> children = new ArrayList<>();
		char value;
		
		Node(char value){
			this.value = value;
		}
	}
}
