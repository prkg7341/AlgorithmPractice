package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BertrandGongjun {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		boolean[] notSosu = new boolean[123456*2+1];
		int[] num = new int[notSosu.length];

		notSosu[0] = true;

		notSosu[1] = true;

		for(int i=2 ; i<=123456*2 ; i++){
			if(i<=123456){
				if(!notSosu[i]){
					num[i] = num[i-1]+1;
					for(int j=2*i ; j<=123456*2 ; j = j+i){
						notSosu[j] = true;
					}
				}
				else{
					num[i] = num[i-1];
				}
			}
			else{
				if(!notSosu[i]){
					num[i] = num[i-1]+1;
				}
				else{
					num[i] = num[i-1];
				}
			}
		}

		StringBuilder sb = new StringBuilder();

		while(true){			

			int n = Integer.parseInt(br.readLine());

			if(n==0){
				sb.deleteCharAt(sb.length()-1);
				System.out.println(sb.toString());
				return;
			}

			sb.append(String.valueOf(num[2*n]-num[n])+"\n");
		}
	}
}
