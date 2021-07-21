package Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class CalculatingScore {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int[] ar = new int[8];
		
		for(int i=1 ; i<=8 ; i++){
			int score = Integer.parseInt(br.readLine());
			ar[i-1] = score*10+i;
		}
		
		Arrays.sort(ar);
		
		int[] ar2 = new int[5];
		int sum = 0;
		
		for(int i=7 ; i>=3 ; i--){
			sum += ar[i]/10;
			ar2[i-3] = ar[i]%10;
		}
		
		Arrays.sort(ar2);
		
		sb.append(sum+"\n");
		
		for(int i=0 ; i<ar2.length ; i++){
			sb.append(ar2[i]+" ");
		}
		sb.deleteCharAt(sb.length()-1);
		bw.write(sb.toString());
		bw.flush();
		bw.close();	
	}
}
