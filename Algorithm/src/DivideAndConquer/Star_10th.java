package DivideAndConquer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Star_10th {

	public Star_10th() {

	}

	private void rec(int[][] ar, int n, int row, int col){

		if(n==3){
			ar[row][col] = 1;
			ar[row][col+1] = 1;
			ar[row][col+2] = 1;
			ar[row+1][col] = 1;
			ar[row+1][col+2] = 1;
			ar[row+2][col] = 1;
			ar[row+2][col+1] = 1;
			ar[row+2][col+2] = 1;
		}

		else{
			rec(ar, n/3, row, col);
			rec(ar, n/3, row, col+n/3);
			rec(ar, n/3, row, col+2*n/3);
			rec(ar, n/3, row+n/3, col);
			//rec(ar, n/3, row, col);
			rec(ar, n/3, row+n/3, col+2*n/3);
			rec(ar, n/3, row+2*n/3, col);
			rec(ar, n/3, row+2*n/3, col+n/3);
			rec(ar, n/3, row+2*n/3, col+2*n/3);
		}
	}
	
	private void draw(int[][] ar, int n, StringBuilder sb) {

		for(int i=0 ; i<n ; i++){
			for(int j=0 ; j<n ; j++){
				if(ar[i][j]==1){
					sb.append("*");
				}
				else{
					sb.append(" ");
				}
			}
			sb.append("\n");
		}
		sb.deleteCharAt(sb.length()-1);
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		if(n==1){
			System.out.println("*");
		}

		else{
			int ar[][] = new int[n][n];
			
			Star_10th star = new Star_10th();
			
			star.rec(ar, n, 0, 0);
			
			star.draw(ar, n, sb);
			
			bw.write(sb.toString());
			bw.flush();
			bw.close();
		}
	}
}
