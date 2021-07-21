package Kakao_SummerInternship;

import java.util.HashSet;

public class KSI5 {
	
	static int answer;
	
	public int solution(int k, int[] num, int[][] links) {
		Node[] tree = new Node[num.length];

		for(int i=0 ; i<tree.length ; i++) {
			tree[i] = new Node(links[i][0], links[i][1], i, num[i]);
		}
		
		HashSet<Integer> leaves = new HashSet<>();
		
		int root = -1;

		for(int i=0 ; i<tree.length ; i++) {
			if(tree[i].left==-1 && tree[i].right==-1) {
				leaves.add(i);
				int now = i;
				while(now!=-1) {
					tree[tree[now].parent].value += tree[now].value;
					root = now;
					now = tree[now].parent;
				}
			}
		}
		
		int st = tree[root].value/k;
		int temp;
		
		for(int i : leaves) {
			temp = k;
			while(tree[i].value<st) {
				
			}
		}

		return answer;
	}

	static class Node{
		int parent = -1;
		int left, right, index, value, fin;
		Node(int left, int right, int index, int value){
			this.left = left;
			this.right = right;
			this.index = index;
			this.value = value;
			this.fin = value;
		}
	}
}
