package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FindingParentsofTree {

	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		int[] parent = new int[n];

		ArrayList<ArrayList<Integer>> list = new ArrayList<>(n);

		for(int i=0 ; i<n ; i++){
			list.add(new ArrayList<>());
		}

		for(int i=1 ; i<n ; i++){
			String[] input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);

			list.get(a-1).add(b);
			list.get(b-1).add(a);
		}

		Queue<Integer> q = new LinkedList<>();

		q.add(1);

		while(!q.isEmpty()){
			int now = q.poll()-1;

			for(int temp : list.get(now)){
				if(parent[temp-1]==0){
					parent[temp-1] = now+1;
					q.add(temp);
				}
			}
		}

		for(int i=1 ; i<n ; i++){
			sb.append(parent[i]).append("\n");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.print(sb.toString());
	}
}
