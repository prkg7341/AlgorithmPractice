package StacknQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_2493 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] ar = new int[n];

		for(int i=0 ; i<n ; i++){
			ar[i] = Integer.parseInt(st.nextToken());
		}

		Stack<Pair> stack = new Stack<>();

		for(int i=n-1 ; i>=0 ; i--) {
			int now = ar[i];

			while(!stack.isEmpty() && stack.peek().h<now) {
				Pair pair = stack.pop();
				ar[pair.index] = i;
			}			
			stack.add(new Pair(i,now));
		}

		while(!stack.isEmpty()) {
			Pair pair = stack.pop();
			ar[pair.index] = -1;
		}

		StringBuilder sb = new StringBuilder();

		for(int i : ar) sb.append(i+1).append(" ");
		System.out.println(sb);
	}	

	static class Pair{
		int index, h;

		public Pair(int index, int h) {
			super();
			this.index = index;
			this.h = h;
		}
	}
}
