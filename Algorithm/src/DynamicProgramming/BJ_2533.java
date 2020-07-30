package DynamicProgramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class BJ_2533 {

	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> children;
	static int[][] dp;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		visited = new boolean[n];
		children = new ArrayList<>(n);

		for(int i=0 ; i<n ; i++){
			children.add(new ArrayList<>());
		}

		for(int i=0 ; i<n-1 ; i++) {
			String[] input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0])-1;
			int b = Integer.parseInt(input[1])-1;

			children.get(a).add(b);
			children.get(b).add(a);
		}

		dp = new int[n][2];

		dp(0);

		bw.write(String.valueOf(Math.min(dp[0][0], dp[0][1])));

		bw.flush();
	}

	private static void dp(int node) {
		visited[node] = true;
		dp[node][0] = 0;
		dp[node][1] = 1;
		ArrayList<Integer> list = children.get(node);

		for(int i=0 ; i<list.size() ; i++){
			int child = list.get(i);
			if(!visited[child]) {
				dp(child);
				dp[node][0] += dp[child][1];
				dp[node][1] += Math.min(dp[child][0], dp[child][1]);
			}
		}
	}
}
