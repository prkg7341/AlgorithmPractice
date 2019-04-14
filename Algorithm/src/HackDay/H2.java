package HackDay;

//you can also use imports, for example:
//import java.util.*;
import java.util.*;
//you can write to stdout for debugging purposes, e.g.
//System.out.println("this is a debug message");

class H2 {
	
	public int solution(Tree T) {
		// write your code in Java SE 8
		int max=0;
		if(T!=null) {
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			pq.add(T.x);
			max = dfs(T,1,pq);
		}
		return max;
	}

	int dfs(Tree T, int n, PriorityQueue<Integer> pq){

		if(T==null) return n;

		if(!pq.contains(T.x)){
			n++;
			pq.add(T.x);
		}

		if(T.l==null && T.r==null){
			return n;
		}

		return Math.max(dfs(T.l,n,pq), dfs(T.r,n,pq));
	}
	
	class Tree{
		int x;
		Tree l;
		Tree r;
	}
}