package BruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class WhiteSnow {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int[] ar = new int[9];
		int sum=0;
		for(int i=0 ; i<9 ; i++){
			ar[i] = Integer.parseInt(br.readLine());
			sum += ar[i];
		}
		
		Arrays.sort(ar);
		
		for(int i=0 ; i<9 ; i++){
			sb.append(ar[i]+" ");
		}
		sb.deleteCharAt(sb.length()-1);
		
		int[][] star = new int[sb.length()][2];
		for(int i=0 ; i<9 ; i++){
			star[i][0] = Integer.parseInt(sb.toString().split(" ")[i]);
		}
		
		for(int i=0 ; i<9 ; i++){
			for(int j=i+1 ; j<9; j++){
				if(sum-ar[i]-ar[j]==100){
					star[i][1] = 1;
					star[j][1] = 1;
					break;
				}
			}
			if(star[i][1]==1) break;
		}
		
		sb.delete(0, sb.length());
		
		for(int i=0 ; i<9 ; i++){
			if(star[i][1]==0){
				sb.append(star[i][0]+"\n");
			}
		}
		sb.deleteCharAt(sb.length()-1);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
