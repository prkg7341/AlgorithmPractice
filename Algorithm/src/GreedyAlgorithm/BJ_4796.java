package GreedyAlgorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_4796 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int test = 0;

		while(true){
			String[] input = br.readLine().split(" ");
			int l = Integer.parseInt(input[0]);
			if(l==0) break;
			int p = Integer.parseInt(input[1]);
			int v = Integer.parseInt(input[2]);

			int result = l*(v/p) + Math.min(v%p, l);
			bw.write("Case "+(++test)+": "+String.valueOf(result)+"\n");
		}

		bw.flush();
	}
}
