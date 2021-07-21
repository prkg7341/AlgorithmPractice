package SDS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SDS_1_1 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();		

		int t = Integer.parseInt(br.readLine().split(" ")[0]); // 테스트 케이스 갯수

		for(int i=1 ; i<=t ; i++){
			int n = Integer.parseInt(br.readLine().split(" ")[0]);
			String[] input = br.readLine().split(" ");
			String first = input[0];
			for(int j=1 ; j<n ; j++){
				if(input[j].charAt(0)>=first.charAt(0)){
					first = input[j]+first;
				}
				else{
					first = first+input[j];
				}
			}
			sb.append("#"+i+" "+first+"\n");
		}

		sb.deleteCharAt(sb.length()-1);
		bw.write(sb.toString());
		bw.flush();
		bw.close();	
		
	}
}
