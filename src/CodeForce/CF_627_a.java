package CodeForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CF_627_a {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());
		
		test: for(int tt=0 ; tt<t ; tt++) {
			int n = Integer.parseInt(br.readLine());
			
			String[] input = br.readLine().split(" ");
			
			int st = Integer.parseInt(input[0]);
			
			for(int i=1 ; i<n ; i++) {
				int now = Integer.parseInt(input[i]);
				if(st%2 != now%2) {
					bw.write("NO\n");
					continue test;
				}
			}
			
			bw.write("YES\n");
		}

		bw.flush();
	}
}
