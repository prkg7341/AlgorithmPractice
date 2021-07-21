package DivideAndConquer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Matrix {

	public Matrix() {

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		String temp = br.readLine();
		
		int n1,m1,n2,m2;
		
		n1 = Integer.parseInt(temp.split(" ")[0]);
		m1 = Integer.parseInt(temp.split(" ")[1]);
		
		int[][] ar1 = new int[n1][m1]; 
		
		for(int i=0 ; i<n1 ; i++){
			temp = br.readLine();
			for(int j=0 ; j<m1 ; j++){
				ar1 [i][j] = Integer.parseInt(temp.split(" ")[j]);
			}
		}
		
		temp = br.readLine();

		n2 = Integer.parseInt(temp.split(" ")[0]);
		m2 = Integer.parseInt(temp.split(" ")[1]);
		
		int[][] ar2 = new int[n2][m2]; 
		
		for(int i=0 ; i<n2 ; i++){
			temp = br.readLine();
			for(int j=0 ; j<m2 ; j++){
				ar2 [i][j] = Integer.parseInt(temp.split(" ")[j]);
			}
		}
		
		int[][] ar3 = new int[n1][m2];
		
		int sum=0;
		
		for(int i=0 ; i<n1 ; i++){
			for(int j=0 ; j<m2 ; j++){
				for(int k=0 ; k<m1 ; k++){
					sum += ar1[i][k] * ar2[k][j];
				}
				ar3[i][j] = sum;
				sum = 0;
			}
		}
		

		for(int i=0 ; i<n1 ; i++){
			for(int j=0 ; j<m2 ; j++){
				sb.append(ar3[i][j]+" ");
			}
			sb.deleteCharAt(sb.length()-1);
			sb.append("\n");
		}
		sb.deleteCharAt(sb.length()-1);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
