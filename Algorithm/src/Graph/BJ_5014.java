package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_5014 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		int n = Integer.parseInt(input[0]);
		int from = Integer.parseInt(input[1]);
		int to = Integer.parseInt(input[2]);
		int up = Integer.parseInt(input[3]);
		int down = Integer.parseInt(input[4]);

		if(from==to){
			System.out.print(0);
			return;
		}

		boolean[] visit = new boolean[n+1];

		Queue<Integer> q = new LinkedList<>();

		int count = 1;
		int check = -1;

		visit[from] = true;
		q.add(from);

		while(!q.isEmpty()){
			int now = q.poll();

			if(now==check) {
				check = -1;
				count++;
			}

			int u = now+up;

			if(u<=n && u>0 && !visit[u]){
				if(u==to){
					System.out.print(count);
					return;
				}
				if(check==-1){
					check = u;
				}
				visit[u] = true;
				q.add(u);
			}

			int d = now-down;

			if(d>0 && d<=n && !visit[d]){
				if(d==to){
					System.out.print(count);
					return;
				}
				if(check==-1){
					check = d;
				}
				visit[d] = true;
				q.add(d);
			}
		}
		System.out.print("use the stairs");
	}
}
