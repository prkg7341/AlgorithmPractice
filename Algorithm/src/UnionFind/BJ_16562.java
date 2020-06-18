package UnionFind;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_16562 {

	static int[] need;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int relation = Integer.parseInt(input[1]);
		int money = Integer.parseInt(input[2]);

		input = br.readLine().split(" ");
		need = new int[n];
		for(int i=0 ; i<n ; i++) {
			need[i] = -Integer.parseInt(input[i]);
		}

		for(int i=0 ; i<relation ; i++){
			input = br.readLine().split(" ");

			int a = Integer.parseInt(input[0])-1;
			int b = Integer.parseInt(input[1])-1;

			union(a, b);
		}

		int sum = 0;

		for(int i : need){
			if(i<0) sum -= i;
		}

		if(sum>money) bw.write("Oh no");
		else bw.write(String.valueOf(sum));

		bw.flush();
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a==b) return;

		if(need[a]>need[b]){
			need[b] = a;
		}
		else{
			need[a] = b;
		}
	}

	private static int find(int a) {
		if(need[a]<0) return a;
		return need[a] = find(need[a]);
	}
}
