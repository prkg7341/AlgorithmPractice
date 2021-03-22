package Graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_14677 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		char[] ar = br.readLine().toCharArray();		
		char[] ch = {'B', 'L', 'D'};

		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(0, n*3-1, 0));		

		boolean[][] visit = new boolean[3*n][3*n];		
		visit[0][n*3-1] = true;

		int max = 0;

		while(!q.isEmpty()) {
			Pair now = q.poll();

			max = Math.max(max, now.count);

			if(now.a>now.b) {
				break;
			}

			char c = ch[now.count%3];

			try{
				if(ar[now.a]==c && !visit[now.a+1][now.b]) {
					q.add(new Pair(now.a+1, now.b, now.count+1));
					visit[now.a+1][now.b] = true;
				}}catch(Exception e){

				}
			try{if(ar[now.b]==c && !visit[now.a][now.b-1]) {
				q.add(new Pair(now.a, now.b-1, now.count+1));
				visit[now.a][now.b-1] = true;
			}}catch(Exception e){

			}
		}

		bw.write(Integer.toString(max));

		bw.flush();
	}

	static class Pair{
		int a, b, count = 0;
		Pair(int a, int b, int count){
			this.a = a;
			this.b = b;
			this.count = count;
		}
	}
}
