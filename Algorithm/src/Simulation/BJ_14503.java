package Simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_14503 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");

		int row = Integer.parseInt(input[0]);
		int col = Integer.parseInt(input[1]);

		input = br.readLine().split(" ");

		int x = Integer.parseInt(input[0]);
		int y = Integer.parseInt(input[1]);
		int dir = Integer.parseInt(input[2]);

		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};

		int[][] ar = new int[row][col];

		for(int i=0 ; i<row ; i++){
			input = br.readLine().split(" ");
			for(int j=0 ; j<col ; j++){
				ar[i][j] = Integer.parseInt(input[j]);
			}
		}

		int result = 0;

		whole: while(true){
			if(ar[x][y]==0){
				ar[x][y] = -1;
				result++;
			}

			for(int i=3 ; i>=0 ; i--){
				try{
					int nextD = (dir+i)%4;
					if(ar[x+dx[nextD]][y+dy[nextD]]==0){
						x += dx[nextD];
						y += dy[nextD];
						dir = nextD;
						continue whole;
					}
				} catch(IndexOutOfBoundsException E){
					continue;
				}
			}
			try{
				int nextD = (dir+2)%4;
				if(ar[x+dx[nextD]][y+dy[nextD]]<1){
					x += dx[nextD];
					y += dy[nextD];
				}
				else{
					break whole;
				}
			} catch(IndexOutOfBoundsException E2){
				break whole;
			}
		}

		bw.write(String.valueOf(result));

		bw.flush();
	}
}
