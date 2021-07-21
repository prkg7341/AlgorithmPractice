package Graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_14496 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		int from = Integer.parseInt(input[0])-1;
		int to = Integer.parseInt(input[1])-1;
		
		if(from==to) {
			System.out.println(0);
			return;
		}

		input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);

		boolean[] visit = new boolean[n];
		ArrayList<ArrayList<Integer>> list = new ArrayList<>(n);

		for(int i=0 ; i<n ; i++) {
			list.add(new ArrayList<Integer>());
		}

		for(int i=0 ; i<m ; i++) {
			input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0])-1;
			int b = Integer.parseInt(input[1])-1;
			list.get(a).add(b);
			list.get(b).add(a);
		}

		Queue<Spot> q = new LinkedList<>();

		q.add(new Spot(from, 0));
		visit[from] = true;

		boolean fin = false;

		while(!q.isEmpty() && !fin) {
			Spot now = q.poll();
			for(int next : list.get(now.val)) {
				if(next==to) {
					fin = true;
					bw.write(Integer.toString(now.count+1));
				}
				if(!visit[next]) {
					visit[next] = true;
					q.add(new Spot(next, now.count+1));
				}
			}
		}

		if(!fin) bw.write(Integer.toString(-1));

		bw.flush();
	}

	static class Spot{
		int val;
		int count;
		Spot(int val, int count){
			this.val = val;
			this.count = count;
		}
	}
}
