package SegmentTree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_2042_old {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");

		int n = Integer.parseInt(input[0]);
		int change = Integer.parseInt(input[1]);
		int summation = Integer.parseInt(input[2]);

		long[] st = new long[4*n];
		int[] ar = new int[n];

		for(int i=0 ; i<n ; i++){
			ar[i] = Integer.parseInt(br.readLine());
		}

		init(st,ar,0,n-1,1);

		for(int i=0 ; i<change+summation ; i++){
			input = br.readLine().split(" ");
			int num = Integer.parseInt(input[0]);
			if(num==1){
				int index = Integer.parseInt(input[1])-1;
				int to = Integer.parseInt(input[2]);
				int dif = ar[index]-to;
				update(st, 0, n-1, index, dif, 1);
				ar[index] = to;
			}
			else{
				int from = Integer.parseInt(input[1])-1;
				int to = Integer.parseInt(input[2])-1;
				long print = sum(st, 0, n-1, from, to, 1);
				bw.write(print+"\n");
			}
		}

		bw.flush();
	}

	private static void update(long[] st, int from, int to, int index, int dif, int root) {
		if(index>to || index<from){
			return;
		}
		st[root] -= dif;
		if(from!=to){
			int mid = (from+to)/2;
			update(st, from, mid, index, dif, 2*root);
			update(st, mid+1, to, index, dif, 2*root+1);
		}
	}

	private static long sum(long[] st, int left, int right, int from, int to, int root) {

		if(from>right || to<left){
			return 0;
		}
		else if(from<=left && to>=right){
			return st[root];
		}
		else{
			int mid = (left+right)/2;
			return sum(st, left, mid, Math.max(from, left), Math.min(to, mid), 2*root)
					+sum(st, mid+1, right, Math.max(from, mid+1), Math.min(to,  right), 2*root+1);
		}
	}

	private static long init(long[] st, int[] ar, int left, int right, int root) {
		if(left>=right){
			st[root] = ar[left];
		}
		else{
			int mid = (left+right)/2;
			st[root] = init(st, ar, left, mid, 2*root) + init(st, ar, mid+1, right, 2*root+1);
		}
		return st[root];
	}
}
