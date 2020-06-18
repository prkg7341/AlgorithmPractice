package UnionFind;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BJ_1717 {

	static int[] ar;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int num = Integer.parseInt(input[1]);

		ar = new int[n+1];

		Arrays.fill(ar, -1);

		for(int i=0 ; i<num ; i++){
			input = br.readLine().split(" ");
			int kind = Integer.parseInt(input[0]);
			int a = Integer.parseInt(input[1]);
			int b = Integer.parseInt(input[2]);
			if(kind==0){
				union(a, b);
			}
			else{
				String ret = check(a, b);
				bw.write(ret+"\n");
			}
		}

		bw.flush();
	}

	private static String check(int a, int b) {
		if(find(a)==find(b)) return "YES";
		else return "NO";
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a==b) return;
		if(a<b) {
			ar[a] += ar[b];
			ar[b] = a;
		}
		else{
			ar[b] += ar[a];
			ar[a] = b;
		}
	}

	private static int find(int a) {
		if(ar[a]<0) return a;
		ar[a] = find(ar[a]);
		return ar[a];
	}
}
