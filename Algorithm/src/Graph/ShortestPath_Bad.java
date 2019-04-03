package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class ShortestPath_Bad {

	public static void main(String[] args) throws NumberFormatException, IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] input = br.readLine().split(" ");

		int v = Integer.parseInt(input[0]);
		int e = Integer.parseInt(input[1]);

		int start = Integer.parseInt(br.readLine());

		Node[] nodes = new Node[v+1];

		for(int i=1 ; i<=v ; i++){
			nodes[i] = new Node(i);
		}

		int[] distances = new int[v+1];
		Arrays.fill(distances, 1234567);
		boolean[] checked = new boolean[v+1];		

		for(int i=0 ; i<e ; i++){
			input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			int w = Integer.parseInt(input[2]);

			nodes[a].edges.add(new Map(b,w));
		}

		distances[start] = 0;

		Node now = nodes[start];

		for(int i=1 ; i<=v ; i++){
			checked[now.value] = true;

			for(int j=0 ; j<now.edges.size() ; j++){
				Map map = now.edges.get(j);
				if(!checked[map.dest]){
					distances[map.dest] = Math.min(distances[map.dest], distances[now.value]+map.dist);
				}
			}

			if(i!=v){
				int min = 1234568;
				int index = -1;

				for(int j=1 ; j<=v ; j++){
					if(!checked[j]){
						if(min>distances[j]){
							min = Math.min(min, distances[j]);
							index = j;
						}
					}
				}
				now = nodes[index];
			}
		}

		for(int i=1 ; i<=v ; i++){
			int result = distances[i];
			if(result==1234567) sb.append("INF\n");
			else sb.append(result).append("\n");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.print(sb.toString());
	}

	static class Node{
		int value;
		ArrayList<Map> edges;
		Node(int value){
			this.value = value;
			edges = new ArrayList<>();
		}
	}

	static class Map{
		int dest;
		int dist;
		Map(int dest, int dist){
			this.dest = dest;
			this.dist = dist;
		}
	}
}