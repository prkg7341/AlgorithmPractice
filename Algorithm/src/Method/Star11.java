package Method;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Star11 {
	
	void drawBase(char[][] ar, int row1, int col1){
		ar[row1][col1+2] = 1;
		ar[row1+1][col1+1] = 1;
		ar[row1+1][col1+3] = 1;
		ar[row1+2][col1] = 1;
		ar[row1+2][col1+1] = 1;
		ar[row1+2][col1+2] = 1;
		ar[row1+2][col1+3] = 1;
		ar[row1+2][col1+4] = 1;
	}
	
	void recursion(char[][] ar, int size, int row1, int row2, int col1, int col2){
		
		int rowMid = (row1+row2)/2;
		int colQ1 = col1+size/2;
		int colMid = (col1+col2)/2;
		int colQ2 = col2-size/2;
		
		if(size==3){			
			drawBase(ar, row1, col1);
		}
		else{
			size /= 2;
			recursion(ar, size, row1, rowMid, colQ1, colQ2);
			recursion(ar, size, rowMid+1, row2, col1, colMid-1);
			recursion(ar, size, rowMid+1, row2, colMid+1, col2);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		Star11 star = new Star11();
		
		char[][] ar = new char[n][2*n-1]; //2Áø
		
		star.recursion(ar, n, 0, n-1, 0, 2*n-2);
		
		for(int i=0 ; i<n ; i++){
			for(int j=0 ; j<2*n-1 ; j++){
				if(ar[i][j]==1){
					sb.append("*");
				}
				else{
					sb.append(" ");
				}
			}
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();		
	}
}
