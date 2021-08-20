package GreedyAlgorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_3109_개선전 {

	static int row, col;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");

		row = Integer.parseInt(input[0]);
		col = Integer.parseInt(input[1]);

		boolean[][] ar = new boolean[row][col];

		for(int i=0 ; i<row ; i++) {
			input = br.readLine().split("");
			for(int j=0 ; j<col ; j++){
				if(input[j].charAt(0)=='.') ar[i][j] = true;
			}
		}

		int count = 0;

		for(int i=0 ; i<row ; i++){
			if(reach(ar, i, 0)) count++;
		}

		bw.write(Integer.toString(count));

		bw.flush();
	}

	private static boolean reach(boolean[][] ar, int r, int c) {
		if(r<0 || r>=row) return false;
		if(c==col-1) {
			boolean ret = ar[r][c];
			ar[r][c] = false;
			return ret;
		}
		if(ar[r][c]){
			ar[r][c] = false;
			return reach(ar, r-1, c+1) || reach(ar, r, c+1) || reach(ar, r+1, c+1);
		}
		else{
			return ar[r][c];
		}		
	}
}
