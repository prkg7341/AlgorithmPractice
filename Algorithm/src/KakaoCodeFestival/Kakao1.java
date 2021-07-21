package KakaoCodeFestival;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Kakao1 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		int a,b,sum=0;
		String st;

		for(int i=0 ; i<n ; i++){
			st = br.readLine();
			a = Integer.parseInt(st.split(" ")[0]);
			b = Integer.parseInt(st.split(" ")[1]);
			sum = 0;

			if(a==0){
				sum += 0;
			}
			else if(a==1){
				sum += 5000000;
			}
			else if(a<=3){
				sum += 3000000;
			}
			else if(a<=6){
				sum += 2000000;
			}
			else if(a<=10){
				sum += 500000;
			}
			else if(a<=15){
				sum += 300000;
			}
			else if(a<=21){
				sum += 100000;
			}
			else{
				sum += 0;
			}
			
			if(b==0){
				sum += 0;
			}
			else if(b==1){
				sum += 5120000;
			}
			else if(b<=3){
				sum += 2560000;
			}
			else if(b<=7){
				sum += 1280000;
			}
			else if(b<=15){
				sum += 640000;
			}
			else if(b<=31){
				sum += 320000;
			}
			else{
				sum += 0;
			}
			
			sb.append(sum+"\n");
		}

		sb.deleteCharAt(sb.length()-1);

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}
