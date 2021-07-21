package SegmentTree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_2042_new {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int update = Integer.parseInt(input[1]);
		int sum = Integer.parseInt(input[2]);

		long[] segtree = new long[4*n];

		for(int i=0 ; i<n ; i++) {
			long now = Long.parseLong(br.readLine());
			update(segtree, now, 1, i, 0, n-1);
		}

		for(int i=0 ; i<update+sum ; i++){
			input = br.readLine().split(" ");

			long a = Long.parseLong(input[0]);
			int b = Integer.parseInt(input[1]);
			long c = Long.parseLong(input[2]);

			if(a==1){
				update(segtree, c, 1, b-1, 0, n-1);
			}
			else{
				bw.write(String.valueOf(sum(segtree, b-1, (int)c-1, 1, 0, n-1)));
				bw.write("\n");
			}
		}

		bw.flush();
	}

	private static long update(long[] segtree, long value, int node, int index, int left, int right) {
		int mid = (left+right)/2;
		long dif;

		if(left>=right) {
			dif = value-segtree[node];
		}
		else if(mid>=index) {
			dif = update(segtree, value, node*2, index, left, mid);
		}
		else {
			dif = update(segtree, value, node*2+1, index, mid+1, right);
		}

		segtree[node] += dif;
		return dif;
	}

	private static long sum(long[] segtree, int from, int to, int node, int leftNode, int rightNode) {
		if(leftNode>=from && rightNode<=to) return segtree[node];
		if(rightNode<from || leftNode>to) return 0;
		int mid = (leftNode+rightNode)/2;
		return sum(segtree, from, to, node*2, leftNode, mid) + sum(segtree, from, to, node*2+1, mid+1, rightNode);
	}
}
