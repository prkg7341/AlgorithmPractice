package PrimeNumber;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FindPrimeNumber {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		String st = br.readLine();		
		int[][] ar = new int [n][2];
		int count=0;

		for(int i=0 ; i<ar.length ; i++){
			ar[i][0] = Integer.parseInt(st.split(" ")[i]);
		}

		for(int i=0 ; i<ar.length ; i++){
			if(ar[i][0]%2==0 && ar[i][0]!=2){
				ar[i][1]=1;
			}
			else if(ar[i][0]%3==0 && ar[i][0]!=3){
				ar[i][1]=1;
			}
			else if(ar[i][0]==1){
				ar[i][1]=1;
			}
			else if(ar[i][0]!=5 && ar[i][0]%5==0){
				ar[i][1]=1;
			}
			else{
				for(int j=7 ; j<=ar[i][0]/11 ; j+=2){
					if(ar[i][0]%j==0){
						ar[i][1]=1; break;
					}
				}
			}
		}
		for(int i=0 ; i<ar.length ; i++){
			if(ar[i][1]==0){
				count++;
			}
		}
		bw.write(count+"");
		bw.flush();
		bw.close();
	}

}
