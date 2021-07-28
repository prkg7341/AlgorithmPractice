package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_2252{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		int n = Integer.parseInt(input[0]);
		int comp = Integer.parseInt(input[1]);

		StringBuilder sb = new StringBuilder();

		ArrayList<ArrayList<Integer>> list = new ArrayList<>(n);

		for(int i=0 ; i<n ; i++) {
			list.add(new ArrayList<>(n));
		}

		int[] count = new int[n];

		for(int i=0 ; i<comp ; i++) {
			input = br.readLine().split(" ");

			int from = Integer.parseInt(input[0])-1;
			int to = Integer.parseInt(input[1])-1;

			list.get(from).add(to);

			count[to]++;
		}

		Queue<Integer> q = new LinkedList<>();

		for(int i=0 ; i<count.length ; i++) {
			if(count[i]==0) q.add(i);
		}

		while(!q.isEmpty()) {
			int index = q.poll();

			sb.append(index+1).append(" ");

			for(int i : list.get(index)) {
				if(--count[i]==0) {
					q.add(i);
				}

			}
		}
		System.out.println(sb.toString());
	}
}