package CodeForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF_560_d {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		test:
			for(int tt=0 ; tt<t ; tt++){
				int n = Integer.parseInt(br.readLine());
				int max = 0;
				int min = 1234567;

				String[] input = br.readLine().split(" ");

				for(int i=0 ; i<n ; i++){
					int now = Integer.parseInt(input[i]);
					max = Math.max(max, now);
					min = Math.min(min, now);
				}

				long num = max*min;

				for(int i=0 ; i<n ; i++){
					int now = Integer.parseInt(input[i]);
					if(num%now != 0){
						System.out.print(-1);
						continue test;
					}
				}

				System.out.println(num);
			}
	}
}