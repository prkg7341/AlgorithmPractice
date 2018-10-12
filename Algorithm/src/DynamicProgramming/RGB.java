package DynamicProgramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class RGB {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		if(n==0){
			System.out.println(0);
		}

		else{

			int[][] ar = new int[n][3];
			int a,b,c;
			String st;

			for(int i=0 ; i<n ; i++){
				st = br.readLine();
				for(int j=0 ; j<3 ; j++){
					ar[i][j] = Integer.parseInt(st.split(" ")[j]);
				}
			}

			int min = Integer.MAX_VALUE;

			int temp = 0;

			for(int i=0 ; i<n ; i++){

			}
		}

	}

}
