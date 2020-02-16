package Array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_2840 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		boolean[] used = new boolean[26];

		String[] input = br.readLine().split(" ");

		int n = Integer.parseInt(input[0]);
		int num = Integer.parseInt(input[1]);

		char[] ar = new char[n];

		int index = 0;

		for(int i=0 ; i<num ; i++){
			input = br.readLine().split(" ");
			int k = Integer.parseInt(input[0]);
			char c = input[1].charAt(0);

			index = (index+k)%n;

			int check = (int)(c-'A');

			if(ar[index]!=c && (ar[index]!=0 || used[check])) {
				System.out.println("!");
				return;
			}

			used[check] = true;

			ar[index] = c;
		}

		for(int i=index ; i>index-n ; i--){
			char now = ar[(i+n)%n];
			if(now==0) bw.write(String.valueOf('?'));
			else bw.write(String.valueOf(now));
		}

		bw.flush();
	}
}
