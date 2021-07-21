package DynamicProgramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_9252 {

	static char[] a;
	static char[] b;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		a = br.readLine().toCharArray();
		b = br.readLine().toCharArray();

		int[][][] ar = new int[a.length+1][b.length+1][2];

		for(int i=1 ; i<=a.length ; i++) {
			for(int j=1 ; j<=b.length ; j++){
				if(a[i-1]==b[j-1]) {
					ar[i][j][0] = ar[i-1][j-1][0]+1;
					ar[i][j][1] = 1;
				}
				else{
					if(ar[i][j-1][0]>=ar[i-1][j][0]){
						ar[i][j][0] = ar[i][j-1][0];
						ar[i][j][1] = 3;
					}
					else{
						ar[i][j][0] = ar[i-1][j][0];
						ar[i][j][1] = 2;
					}
				}
			}
		}

		StringBuilder sb = new StringBuilder();

		int row = a.length;
		int col = b.length;

		while(ar[row][col][0]!=0 && row>0 && col>0){
			if(ar[row][col][1]==1){
				sb.insert(0, a[row-1]);
				row--;
				col--;
			}
			else if(ar[row][col][1]==2){
				row--;
			}
			else{
				col--;
			}
		}

		bw.write(sb.length()+"\n"+sb.toString());

		bw.flush();
	}
}
