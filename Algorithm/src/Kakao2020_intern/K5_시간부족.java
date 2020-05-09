package Kakao2020_intern;

import java.util.LinkedList;
import java.util.Queue;

public class K5_시간부족 {
	public boolean solution(int n, int[][] path, int[][] order) {
        boolean answer = true;
        
        int[] parent = new int[n];
        
        for(int i=0 ; i<parent.length ; i++) parent[i] = -1;
        
        Queue<Pair> q = new LinkedList<>();
        
        for(int i=0 ; i<n ; i++) {
        	int a = path[i][0];
        	int b = path[i][1];
        	if(a==0) {
        		parent[b] = a;
        	}
        	else if(b==0) {
        		parent[a] = b;
        	}
        	else {
        		if(parent[a]!=-1) {
        			parent[b] = a;
        		}
        		else if(parent[a]!=-1) {
        			parent[a] = b;
        		}
        		else q.add(new Pair(a,b));
        	}
        }
        
        while(!q.isEmpty()) {
        	Pair now = q.poll();
        	int a = now.a;
        	int b = now.b;
        	if(parent[a]!=-1) {
    			parent[b] = a;
    		}
    		else if(parent[a]!=-1) {
    			parent[a] = b;
    		}
    		else q.add(new Pair(a,b));
        }
        
        for(int i=0 ; i<order.length ; i++) {
        	for(int j=i+1 ; j<order.length ; j++) {
        		
        		
        	}
        }
        
        return answer;
    }
	static class Pair{
		int a;
		int b;
		Pair(int a, int b){
			this.a = a;
			this.b = b;
		}
	}
}
