package ACP_practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class I {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n,m,max,count,sum;

		max = -1;
		count = 0;
		sum = 0;

		String temp = br.readLine();

		n = Integer.parseInt(temp.split(" ")[0]);
		m = Integer.parseInt(temp.split(" ")[1]);

		int[][][] ar = new int[n][m][2];

		for(int i=0 ; i<n ; i++){
			temp = br.readLine();
			for(int j=0 ; j<m ; j++){
				ar[i][j][0] = Integer.parseInt(temp.split(" ")[j]); 
				sum += ar[i][j][0];
			}
		} 	

		for(int i=0 ; i<n ; i++){
			for(int j=0 ; j<m ; j++){
				count++;
				if(max<ar[i][j][0]){
					max = ar[i][j][0];
					ar[i][j][1] = 1;					
					if(j!=0){
						ar[i][j-count][1] = 0;
					}
					count=0;
				}				
			}			
			sum -= max; 
			max = -1;
		}		

		for(int j=0 ; j<m ; j++){
			for(int i=0 ; i<n ; i++){
				count++;
				if(max<ar[i][j][0]){
					if(ar[i][j][1]!=1){
						max = ar[i][j][0];
					}
					else{
						count=0; max = -1; break;
					}
					count=0;
				}

			}
			if(max>=0){
				sum -= max; 
			}
			max = -1;
		}
		bw.write(sum+"");
		bw.flush();
		bw.close();
	}

}
