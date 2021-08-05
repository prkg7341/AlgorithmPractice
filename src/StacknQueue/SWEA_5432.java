package StacknQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_5432 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for(int tt=1 ; tt<=t ; tt++) {
			char[] ar = br.readLine().toCharArray();

			int stack_size = 0;
			int ret = 0;

			for(int i=0 ; i<ar.length ; i++) {
				char now = ar[i];

				if(now=='(') {
					ret++;
					stack_size++;
				}
				else {
					if(ar[i-1]=='(') {
						ret--;
						ret += --stack_size;
					}
					else stack_size--;
				}				
			}
			System.out.println("#"+tt+" "+ret);
		}
	}	
}
