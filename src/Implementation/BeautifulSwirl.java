package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BeautifulSwirl {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		String[] input = br.readLine().split(" ");

		int r1 = Integer.parseInt(input[0]);
		int c1 = Integer.parseInt(input[1]);
		int r2 = Integer.parseInt(input[2]);
		int c2 = Integer.parseInt(input[3]);

		int[][] ar = new int[r2-r1+1][c2-c1+1];

		int max = -1;

		for(int i=0 ; i<=r2-r1 ; i++){
			for(int j=0 ; j<=c2-c1 ; j++){
				int row = i+r1;
				int col = j+c1;
				if(row>0 && row>=Math.abs(col)){
					ar[i][j] = (2*row+1)*(2*row+1)-(row-col);
					max = Math.max(max, ar[i][j]);
				}
				else if(row<0 && Math.abs(row+1)>=Math.abs(col)){
					ar[i][j] = (2*row)*(2*row)-(col-row-1);
					max = Math.max(max, ar[i][j]);
				}
				else if(col<0){
					ar[i][j] = (2*col-1)*(2*col-1)+2*col+(row+col);
					max = Math.max(max, ar[i][j]);
				}
				else{
					ar[i][j] = (2*col-1)*(2*col-1)+(col-row);
					max = Math.max(max, ar[i][j]);
				}
			}
		}
		int num=1;
		while((max=max/10)!=0){
			num++;
		}

		for(int i=0 ; i<=r2-r1 ; i++){
			for(int j=0 ; j<=c2-c1 ; j++){
				String now = String.valueOf(ar[i][j]);
				int len = now.length();
				while(len++<num){
					sb.append(" ");
				}
				sb.append(now+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
