package UnionFind;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BJ_1976 {

	static int[] ar;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int city = Integer.parseInt(br.readLine());
		int plan = Integer.parseInt(br.readLine());

		if(plan<=1){
			bw.write("YES");
			return;
		}

		ar = new int[city];
		Arrays.fill(ar, -1);

		for(int i=0 ; i<city ; i++) {
			String[] input = br.readLine().split(" ");
			for(int j=0 ; j<city ; j++){
				if(j>i){
					if(Integer.parseInt(input[j])==1) union(i, j);
				}
			}
		}

		boolean yes = true;
		String[] input = br.readLine().split(" ");
		int root = find(Integer.parseInt(input[0])-1);

		for(String st : input){
			if(root!=find(Integer.parseInt(st)-1)){
				yes = false;
				break;
			}
		}

		if(yes) bw.write("YES");
		else bw.write("NO");

		bw.flush();
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a==b) return;
		if(ar[a]<ar[b]){
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
		return ar[a] = find(ar[a]);
	}
}
