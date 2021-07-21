package Graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_9019 {

	static boolean[] visit;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());

		for(int tt=0 ; tt<t ; tt++) {
			String[] input = br.readLine().split(" ");

			visit = new boolean[10000];

			int start = Integer.parseInt(input[0]);
			int end = Integer.parseInt(input[1]);

			StringBuilder sb = new StringBuilder();

			sb = bfs(sb, start, end);
			bw.write(sb.toString()+"\n");
		}

		bw.flush();
	}

	private static StringBuilder bfs(StringBuilder sb, int start, int end) {

		char[] commands = {'D','S','L','R'};

		Queue<Pair> q = new LinkedList<>();

		q.add(new Pair(sb, start));

		while(!q.isEmpty()) {
			Pair now = q.poll();

			for(int i=0 ; i<commands.length ; i++) {
				char com = commands[i];
				StringBuilder newSB = new StringBuilder(now.sb);
				int newValue;
				switch (com) {
				case 'D':
					newSB.append('D');
					newValue = (now.value*2)%10000;
					break;
				case 'S':
					newSB.append('S');
					newValue = now.value==0? 9999 : now.value-1;
					break;
				case 'L':
					newSB.append('L');
					newValue = now.value%1000*10 + now.value/1000;
					break;
				case 'R':
				default:
					newSB.append('R');
					newValue = now.value/10 + now.value%10*1000;
					break;
				}
				if(newValue==end) return newSB;

				if(!visit[newValue]) {
					q.add(new Pair(newSB, newValue));
					visit[newValue] = true;
				}	
			}			
		}
		return new StringBuilder("Fail");
	}

	static class Pair{
		StringBuilder sb;
		int value;
		Pair(StringBuilder sb, int value){
			this.sb = sb;
			this.value = value;
		}
	}
}
