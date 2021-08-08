package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1516{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] ar = new int[n];

		Queue<Integer> q = new LinkedList<>();
		ArrayList<ArrayList<Integer>> list = new ArrayList<>(n);
		int[] befores = new int[n];
		int[] times = new int[n];

		for(int i=0 ; i<n ; i++) {
			list.add(new ArrayList<>());
		}

		for(int i=0 ; i<n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			ar[i] = time;
			while(st.hasMoreTokens()) {
				int before = Integer.parseInt(st.nextToken());
				if(before--==-1) {
					break;
				}
				else {
					list.get(before).add(i);
					befores[i]++;
				}
			}
		}

		for(int i=0 ; i<n ; i++){
			if(befores[i]==0) {
				q.add(i);
				times[i] = ar[i];
			}
		}			

		while(!q.isEmpty()) {
			int now = q.poll();
			for(int i : list.get(now)) {
				befores[i]--;
				times[i] = Math.max(times[i], ar[i]+times[now]);
				if(befores[i]==0) q.add(i);
			}
		}

		for(int i : times) System.out.println(i);
	}
}