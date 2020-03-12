package CodeForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CF_627_b {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());

		test: for(int tt=0 ; tt<t ; tt++) {
			int n = Integer.parseInt(br.readLine());

			int[] index = new int[n];

			String[] input = br.readLine().split(" ");

			for(int i=0 ; i<n ; i++) {
				int now = Integer.parseInt(input[i])-1;

				if(index[now]!=0) {
					if(i+1-index[now]>1) {
						bw.write("YES\n");
						continue test;
					}
				}
				else index[now] = i+1;
			}
			bw.write("NO\n");
		}

		bw.flush();
	}
}
