package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TermProject {

	static int count;
	static int[] want;
	static boolean[] visit;
	static boolean[] finish;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for(int t=0 ; t<T ; t++){
			int n = Integer.parseInt(br.readLine());

			String[] input = br.readLine().split(" ");

			count = n;
			want = new int[n+1];
			visit = new boolean[n+1];
			finish = new boolean[n+1];

			for(int i=1 ; i<=n ; i++){
				want[i] = Integer.parseInt(input[i-1]);
			}

			for(int i=1 ; i<=n ; i++){
				if(!visit[i]) dfs(i);
			}
			sb.append(count).append("\n");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.print(sb.toString());
	}

	static void dfs(int now){

		visit[now] = true;
		int next = want[now];

		if(visit[next]) {
			if(!finish[next]){
				for(int i=next ; i!=now ; i=want[i]){
					count--;
				}
				count--;
			}
		}
		else{
			dfs(next);
		}
		finish[now] = true;
	}
}
