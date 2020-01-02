package DivideAndConquer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_2630 {

	static int[] result = new int[2];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		int[][] table = new int[n][n];

		for(int i=0 ; i<n ; i++) {
			String[] input = br.readLine().split(" ");
			for(int j=0 ; j<n ; j++) {
				table[i][j] = Integer.parseInt(input[j]);
			}
		}

		divide(table,0,n-1,0,n-1);

		bw.write(String.valueOf(result[0]));
		bw.write("\n");
		bw.write(String.valueOf(result[1]));

		bw.flush();
	}

	private static void divide(int[][] table, int startX, int endX, int startY, int endY) {

		if(startX==endX) {
			result[table[startX][startY]]++;
		}
		else {
			int now = table[startX][startY];
			for(int i=startX ; i<=endX ; i++) {
				for(int j=startY ; j<=endY ; j++) {
					if(table[i][j]!=now) {
						divide(table, startX, (startX+endX)/2, startY, (startY+endY)/2);
						divide(table, (startX+endX)/2+1, endX, startY, (startY+endY)/2);
						divide(table, startX, (startX+endX)/2, (startY+endY)/2+1, endY);
						divide(table, (startX+endX)/2+1, endX, (startY+endY)/2+1, endY);
						return;
					}
				}
			}
			result[now]++;
		}
	}
}
