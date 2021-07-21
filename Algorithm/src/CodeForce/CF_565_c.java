package CodeForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF_565_c {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] count = new int[7];		

		String[] input = br.readLine().split(" ");
		for(int i=0 ; i<n ; i++){
			int now = Integer.parseInt(input[i]);
			switch(now){
			case 4:
				count[1]++; 
				break;
			case 8:
				if(count[1]!=0){
					count[1]--;
					count[2]++;
				}
				else{
					count[0]++;
				}
				break;
			case 15:
				if(count[2]!=0){
					count[2]--;
					count[3]++;
				}
				else{
					count[0]++;
				}
				break;
			case 16:
				if(count[3]!=0){
					count[3]--;
					count[4]++;
				}
				else{
					count[0]++;
				}
				break;
			case 23:
				if(count[4]!=0){
					count[4]--;
					count[5]++;
				}
				else{
					count[0]++;
				}
				break;
			case 42:
				if(count[5]!=0){
					count[5]--;
					count[6]++;
				}
				else{
					count[0]++;
				}
				break;
			}
		}
		int result = 0;
		result += count[0];
		for(int i=1 ; i<6 ; i++){
			result += count[i]*(i);
		}
		System.out.println(result);
	}
}
