package SegmentTree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_2357 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int find = Integer.parseInt(input[1]);

		int[] ar = new int[n];
		Pair[] st = new Pair[4*n];

		for(int i=0 ; i<n ; i++){
			ar[i] = Integer.parseInt(br.readLine());
		}

		for(int i=0 ; i<st.length ; i++){
			st[i] = new Pair(Integer.MIN_VALUE, Integer.MAX_VALUE);
		}
		init(st, ar, 0, n-1, 1);

		for(int i=0 ; i<find ; i++){
			input = br.readLine().split(" ");
			int from = Integer.parseInt(input[0])-1;
			int to = Integer.parseInt(input[1])-1;
			int min = min(st, 0, n-1, from, to, 1);
			int max = max(st, 0, n-1, from, to, 1);
			bw.write(min+" "+max+"\n");
		}

		bw.flush();
	}

	private static int max(Pair[] st, int left, int right, int from, int to, int root) {
		if(left>to || right<from){
			return Integer.MIN_VALUE;
		}
		else if(from<=left && to>=right){
			return st[root].max;
		}
		else{
			int mid = (left+right)/2;
			return Math.max(max(st, left, mid, from, to, root*2), max(st, mid+1, right, from, to, root*2+1));
		}
	}

	private static int min(Pair[] st, int left, int right, int from, int to, int root) {
		if(left>to || right<from){
			return Integer.MAX_VALUE;
		}
		else if(from<=left && to>=right){
			return st[root].min;
		}
		else{
			int mid = (left+right)/2;
			return Math.min(min(st, left, mid, from, to, root*2), min(st, mid+1, right, from, to, root*2+1));
		}
	}

	private static Pair init(Pair[] st, int[] ar, int left, int right, int root) {
		if(left>=right){
			return st[root] = new Pair(ar[left], ar[left]);
		}
		else{
			int mid = (left+right)/2;
			Pair ret;
			Pair p1 = init(st, ar, left, mid, root*2);
			Pair p2 = init(st, ar, mid+1, right, root*2+1);
			ret = new Pair(Math.max(p1.max, p2.max), Math.min(p1.min, p2.min));
			return st[root] = ret;
		}
	}
	static class Pair{
		int max;
		int min;
		Pair(int max, int min){
			this.min = min;
			this.max = max;
		}
	}
}
