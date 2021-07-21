package KakaoEnterprise;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class KE1 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();

		int count = 0;

		boolean big = false;
		boolean small = false;
		boolean number = false;
		boolean spe = false;

		for(int i=0 ; i<input.length ; i++) {
			char now = input[i];
			if(now>='A' && now<='Z') big = true;
			else if(now>='a' && now<='z') small = true;
			else if(now>='0' && now<='9') number = true;
			else spe = true;
		}

		if(input.length>=10) count++;
		if(big) count++;
		if(small) count++;
		if(number) count++;
		if(spe) count++;

		System.out.println("LEVEL"+count);
	}
}