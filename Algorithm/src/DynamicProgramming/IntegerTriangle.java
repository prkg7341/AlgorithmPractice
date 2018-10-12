package DynamicProgramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class IntegerTriangle {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String temp = br.readLine();
		
		int n = Integer.parseInt(temp);
		
		int[][] ar = new int[n][n];
		
		for(int i=0 ; i<n ; i++){
			temp = br.readLine();
			for(int j=0 ; j<=i ; j++){
				ar[i][j] = Integer.parseInt(temp.split(" ")[j]);
			}
		}
		
		for(int i=n-2 ; i>=0 ; i--){
			for(int j=i ; j>=0 ; j--){
				ar[i][j] += Math.max(ar[i+1][j], ar[i+1][j+1]);
			}
		}
		
		bw.write(ar[0][0]+"");
		bw.flush();
		bw.close();

	}

}
