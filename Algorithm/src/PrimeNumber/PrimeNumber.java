package PrimeNumber;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PrimeNumber {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int min,max,length,temp = 0;
		min = Integer.parseInt(br.readLine());
		max = Integer.parseInt(br.readLine());
		length = max-min+1;
		int[][] ar = new int[length][2];
		int sum=0;

		for(int i=0 ; i<length ; i++){
			ar[i][0] = min+i;
		} //행렬까지 초기화

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
				sum+=ar[i][0];
			}
		}
		if(sum==0){
			bw.write(-1+"");
		}
		else{
			bw.write(sum+"\n");
			for(int i=0 ; i<ar.length ; i++){
				if(ar[i][1]==0){
					temp=ar[i][0]; break;
				}
			}
			bw.write(temp+"");
		}
		bw.flush();
		bw.close();

	}

}
