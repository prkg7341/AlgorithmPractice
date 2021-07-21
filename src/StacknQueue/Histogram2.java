package StacknQueue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Histogram2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static long max = 0;

	public static void main(String[] args) throws IOException {

		StringBuilder sb = new StringBuilder();

		while(true){

			max = 0;

			String[] input = br.readLine().split(" ");

			int n = Integer.parseInt(input[0]);

			if(n==0){
				sb.deleteCharAt(sb.length()-1);
				System.out.print(sb.toString());
				return;
			}

			long[] ar = new long[n];

			for(int i=0 ; i<n ; i++){
				ar[i] = Integer.parseInt(input[i+1]);
			}

			doit(ar);

			sb.append(max).append("\n");
		}
	}

	static void doit(long[] ar){

		long n = ar.length;

		Stack<Pair> st = new Stack<>();

		for(int i=0 ; i<n ; i++){
			long now = ar[i];

			if(now==0){
				extra(st, i);
				if(i!=n-1)
					doit(Arrays.copyOfRange(ar, i+1, (int) (n)));
				return;
			}

			max = Math.max(max, now);

			if(st.isEmpty()){
				st.push(new Pair(now,i));
			}
			else if(st.peek().value==now){
				Pair pair = st.pop();
				max = Math.max(max, pair.value*(long)(i-pair.from+1));
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

	static void extra(Stack<Pair> st, long n){
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