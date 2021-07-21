package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FloorofDormitory {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		int r = Integer.parseInt(input[0]);
		int b = Integer.parseInt(input[1]);

		int all = r+b;

		int root = (int) Math.pow(all, 0.5)+1;

		int l=-1; //max
		int w=-1; //min

		for(int i=root ; i>=0 ; i--){
			if(all%i==0){
				if(2*i+2*(all/i)-4==r){
					l = Math.max(i, all/i);
					w = Math.min(i, all/i);
					break;
				}
			}
		}
		System.out.print(l+" "+w);
	}
}