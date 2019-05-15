package StacknQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Histogram {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static long max = 0;

	public static void main(String[] args) throws IOException {

		int n = Integer.parseInt(br.readLine());

		doit(n);

		System.out.print(max);
	}

	static void doit(int n) throws NumberFormatException, IOException{

		Stack<Pair> st = new Stack<>();

		for(int i=0 ; i<n ; i++){
			int now = Integer.parseInt(br.readLine());

			if(now==0){
				extra(st, i);
				doit(n-i-1);
				return;
			}

			max = Math.max(max, now);

			if(st.isEmpty()){
				st.push(new Pair(now,i));
			}
			else if(st.peek().value==now){
				Pair pair = st.pop();
				max = Math.max(max, pair.value*(i-pair.from+1));
				st.push(new Pair(now,pair.from));
			}
			else if(st.peek().value<now){
				st.push(new Pair(now,i));
			}
			else{
				long from = i;
				while(!st.isEmpty() && st.peek().value>now){
					Pair pair = st.pop();
					max = Math.max(max, pair.value*(i-pair.from));
					from = Math.min(from, pair.from);
				}
				if(!st.isEmpty() && st.peek().value==now){
					Pair pair = st.pop();
					max = Math.max(max, pair.value*(i-pair.from+1));
					st.push(new Pair(now,pair.from));
				}
				else{
					st.push(new Pair(now,from));
				}
			}
		}
		extra(st, n);
	}

	static void extra(Stack<Pair> st, int n){
		while(!st.isEmpty()){
			Pair pair = st.pop();
			max = Math.max(max, pair.value*(n-pair.from));
		}
	}

	static class Pair{
		long value;
		long from;
		Pair(long value, long from){
			this.value = value;
			this.from = from;
		}
	}
}