package Tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_14942 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		Node[] tree = new Node[n+1];

		for(int i=1 ; i<=n ; i++) {
			tree[i] = new Node(i, Integer.parseInt(br.readLine()));
		}

		Queue<Temp> q = new LinkedList<>();

		for(int i=0 ; i<n-1 ; i++) {
			String[] input = br.readLine().split(" ");

			int from = Integer.parseInt(input[0]);
			int to = Integer.parseInt(input[1]);
			int distance = Integer.parseInt(input[2]);

			if(from==1 || hasParent(tree, from)) {
				tree[to].parent = from;
				tree[to].distance = distance;
			}
			else if(to==1 || hasParent(tree, to)) {
				tree[from].parent = to;
				tree[from].distance = distance;
			}
			else if(hasParent(tree, from)) {
				tree[to].parent = from;
				tree[to].distance = distance;				
			}
			else {
				q.add(new Temp(from, to, distance));
			}
		}

		while(!q.isEmpty()) {

			Temp now = q.poll();

			int from = now.from;
			int to = now.to;
			int distance = now.distance;

			if(from==1 || hasParent(tree, from)) {
				tree[to].parent = from;
				tree[to].distance = distance;
			}
			else if(to==1 || hasParent(tree, to)) {
				tree[from].parent = to;
				tree[from].distance = distance;
			}
			else if(hasParent(tree, from)) {
				tree[to].parent = from;
				tree[to].distance = distance;				
			}
			else {
				q.add(new Temp(from, to, distance));
			}
		}

		for(Node node : tree) {
			try {
				int energy = node.energy;
				while(energy>=node.distance) {
					energy -= node.distance;
					node = tree[node.parent];
				}
				bw.write(Integer.toString(node.val));
				bw.write("\n");
			}catch(NullPointerException e) {

			}
		}

		bw.flush();
	}

	private static boolean hasParent(Node[] tree, int index) {
		if(tree[index].parent!=0) return true;
		else return false;
	}

	static class Node{
		int val;
		int parent = 0;
		int distance = 123456789;
		int energy;
		Node(int val, int energy){
			this.val = val;
			this.energy = energy;
		}
	}

	static class Temp{
		int from;
		int to;
		int distance;
		Temp(int from, int to, int distance) {
			this.from = from;
			this.to = to;
			this.distance = distance;
		}
	}
}
