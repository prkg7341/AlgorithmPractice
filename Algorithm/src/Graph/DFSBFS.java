package Graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DFSBFS {

	static StringBuilder sb;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		String[] input = br.readLine().split(" ");

		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		int v = Integer.parseInt(input[2]);

		ArrayList<Node> nodes = new ArrayList<>();

		for(int i=0 ; i<n ; i++){
			Node node = new Node(i+1);
			nodes.add(node);
		}

		for(int i=0 ; i<m ; i++){
			input = br.readLine().split(" ");
			int start = Integer.parseInt(input[0]);
			int end = Integer.parseInt(input[1]);
			nodes.get(start-1).neightbor.add(end);
			nodes.get(end-1).neightbor.add(start);
		}

		for(Node node : nodes){
			sort(node);
		}		

		Node first = nodes.get(v-1);

		dfs(first, nodes);
		sb.replace(sb.length()-1, sb.length(), "\n");

		bfs(first, nodes);
		sb.deleteCharAt(sb.length()-1);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void sort(Node node) {
		int[] ar = new int[node.neightbor.size()];

		for(int i=0 ; i<ar.length ; i++){
			ar[i] = node.neightbor.get(i);
		}

		Arrays.sort(ar);

		for(int i=0 ; i<ar.length ; i++){
			node.neightbor.set(i, ar[i]);
		}
	}

	private static void dfs(Node node, ArrayList<Node> nodes) {
		if(node.checked){
			return;
		}
		else{
			node.checked = true;
			sb.append(node.value+" ");

			for(int i : node.neightbor){
				if(!nodes.get(i-1).checked){
					dfs(nodes.get(i-1), nodes);
				}
			}
		}
	}

	private static void bfs(Node node, ArrayList<Node> nodes) {
		Queue<Integer> queue = new LinkedList<>();

		queue.add(node.value);
		node.checked = false;

		while(!queue.isEmpty()){
			int temp = queue.poll();
			sb.append(temp+" ");
			for(int i : nodes.get(temp-1).neightbor){
				if(nodes.get(i-1).checked){
					nodes.get(i-1).checked = false;
					queue.add(i);
				}
			}
		}		
	}

	static class Node{
		int value;
		boolean checked;
		LinkedList<Integer> neightbor;

		Node(int value){
			this.value = value;
			checked = false;
			neightbor = new LinkedList<>();
		}
	}
}
