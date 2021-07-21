package CodeForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CF_627_c {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());

		for(int tt=0 ; tt<t ; tt++) {
			char[] input = br.readLine().toCharArray();
			int maxL = 0;
			int tempL = 0;
			for(int i=0 ; i<input.length ; i++) {
				char now = input[i];
				if(now=='L') {
					tempL++;
				}
				else {
					maxL = Math.max(maxL, tempL);
					tempL = 0;
				}
			}
			if(tempL!=0) maxL = Math.max(maxL, tempL);
			bw.write(maxL+1+"\n");
		}

		bw.flush();
	}
}
