package BitMask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1052{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);

		for(int i=0 ; i<=n ; i++) {
			if(Integer.bitCount(n+i)<=k) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(-1);
	}
}