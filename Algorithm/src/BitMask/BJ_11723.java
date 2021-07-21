package BitMask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_11723 {

	public static void main(String[] args) throws IOException {	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		int bit = 0;

		for(int i=0 ; i<n ; i++){
			String[] input = br.readLine().split(" ");
			String now = input[0];
			int value = -1;

			if(input.length>1)
				value = Integer.parseInt(input[1]);

			switch(now){
			case "all": bit |= (1<<20)-1; break;
			case "empty": bit &= 0; break;
			case "add": bit |= (1<<(value-1)); break;
			case "remove": bit &= ~(1<<(value-1)); break;
			case "check": sb.append((bit & (1<<(value-1)))>0? 1 : 0).append("\n"); break;
			case "toggle": bit ^= (1<<(value-1)); break;
			}
		}
		System.out.println(sb.toString());
	}
}
