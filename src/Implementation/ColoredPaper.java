package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ColoredPaper {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] table = new int [100][100];

		int n = Integer.parseInt(br.readLine());

		for(int i=0 ; i<n ; i++){
			String[] input = br.readLine().split(" ");
			int x = Integer.parseInt(input[0]);
			int y = Integer.parseInt(input[1]);
			for(int xx=x ; xx<x+10 ; xx++){
				for(int yy=y ; yy<y+10 ; yy++){
					table[xx][yy] = 1;
				}
			}
		}
		int count=0;
		for(int i=0 ; i<100 ; i++){
			for(int j=0 ; j<100 ; j++){
				if(table[i][j]==1){
					count++;
				}
			}
		}
		System.out.print(count);
	}
}
