package DivideAndConquer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_9934 {

	static StringBuilder[] sb;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());		
		sb = new StringBuilder[n];	
		for(int i=0 ; i<sb.length ; i++) {
			sb[i] = new StringBuilder();
		}
		n = (int) Math.pow(2, n)-1;

		String[] input = br.readLine().split(" ");

		int[] ar = new int[n];

		for(int i=0 ; i<n ; i++) {
			ar[i] = Integer.parseInt(input[i]);
		}

		dnq(ar, 0, n-1, 0);

		for(StringBuilder sb : sb) {
			bw.write(sb.toString());
			bw.write("\n");
		}

		bw.flush();
	}

	private static void dnq(int[] ar, int i, int j, int depth) throws IOException {
		int mid = (i+j)/2;		
		sb[depth].append(ar[mid]).append(" ");
		if(i==j) return;
		dnq(ar, i, mid-1, depth+1);
		dnq(ar, mid+1, j, depth+1);
	}
}
