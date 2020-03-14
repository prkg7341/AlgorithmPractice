package Star;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_10996 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		if(n==1) {
			bw.write("*");
		}

		else {
			for(int i=0 ; i<2*n ; i++) {
				if(i%2==0) {
					for(int k=0 ; k<n/2 ; k++) {
						bw.write("* ");
					}
					if(n%2==1) bw.write("*");
					bw.write("\n");
				}
				else {
					for(int k=0 ; k<n/2 ; k++) {
						bw.write(" *");
					}
					if(n%2==1) bw.write(" ");
					bw.write("\n");
				}
			}
		}

		bw.flush();
	}
}
