package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CalculatingChon {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		String[] input = br.readLine().split(" ");

		int from, to;		
		from = Integer.parseInt(input[0]);
		to = Integer.parseInt(input[1]);

		if(from==to) {
			System.out.print(0);
			return;
		}

		int num = Integer.parseInt(br.readLine());

		Node[] nodes = new Node[n+1];
		boolean[] visit = new boolean[n+1];

		for(int i=1 ; i<=n ; i++){
			nodes[i] = new Node(i);
		}

		for(int i=0 ; i<num ; i++){
			input = br.readLine().split(" ");

			int a, b;
			a = Integer.parseInt(input[0]);
			b = Integer.parseInt(input[1]);

			nodes[a].relations.add(nodes[b]);
			nodes[b].relations.add(nodes[a]);
		}

		Queue<Node> q = new LinkedList<>();

		q.add(nodes[from]);
		visit[from] = true;

		int count = 1;
		int check = -1;

		while(!q.isEmpty()){
			Node now = q.poll();

			if(now.index==check){
				check = -1;
				count++;
			}			

			for(Node node : now.relations){
				int i = node.index;
				if(i==to){
					System.out.print(count);
					return;
				}
				if(!visit[i]){
					if(check==-1){
						check = i;
					}
					visit[i] = true;
					q.add(nodes[i]);
				}
			}
		}
		System.out.print(-1);
	}
	static class Node{
		int index;
		ArrayList<Node> relations = new ArrayList<>();

		Node(int index){
			this.index = index;
		}
	}
}
