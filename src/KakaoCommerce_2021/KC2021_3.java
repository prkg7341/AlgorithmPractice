package KakaoCommerce_2021;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class KC2021_3 {	
	public int[] solution(int n, int[] passenger, int[][] train) {
		Node[] graph = new Node[n+1];

		for(int i=1 ; i<=n ; i++) {
			graph[i] = new Node(i, passenger[i-1]);
		}

		for(int i=0 ; i<train.length ; i++) {
			int from = train[i][0];
			int to = train[i][1];

			graph[from].nb.add(to);
			graph[to].nb.add(from);
		}

		Queue<Integer> q = new LinkedList<>();

		q.add(1);
		graph[1].visit = true;

		int num = 0;
		int max = 0;

		while(!q.isEmpty()) {
			Node now = graph[q.poll()];
			for(int index : now.nb) {
				Node node = graph[index];
				if(!node.visit) {
					node.visit = true;
					node.pass += now.pass;
					if(node.pass>max || (node.pass==max && node.val>num)) {
						num = node.val;
						max = node.pass;
					}
					q.add(index);
				}
			}
		}

		return new int[] {num, max};
	}

	static class Node{
		int val;
		int pass = 0;
		boolean visit = false;
		ArrayList<Integer> nb = new ArrayList<>();
		Node(int val, int pass){
			this.val = val;
			this.pass = pass;
		}
	}
}
