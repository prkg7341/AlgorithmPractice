package String;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_2214 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while(true) {
			String[] input = br.readLine().split(" ");
			int r = Integer.parseInt(input[0]);
			int c = Integer.parseInt(input[1]);

			if(r==0 && c==0) break;

			boolean[][] col = new boolean[r+1][c];
			boolean[][] row = new boolean[r][c+1];

			for(int i=0 ; i<2*r+1 ; i++) {
				char[] car = br.readLine().toCharArray();
				for(int j=0 ; j<car.length ; j++) {
					if(i%2==0) {
						if(car[j]!='*') {
							col[i/2][j] = true;
						}
					}
					else{
						if(car[j]!='*') {
							row[i/2][j] = true;
						}
					}
				}				
			}

			int count = 0;

			for(int i=0 ; i<Math.min(col.length, row[0].length) ; i++) {
				for(int j=0 ; j<col[0].length ; j++) {
					count += check(col, row, i, j, 0);
				}
			}

			bw.write(Integer.toString(count));			
			bw.write(" squares\n");
		}

		bw.flush();
	}

	private static int check(boolean[][] col, boolean[][] row, int i, int j, int num) {
		int ret = 0;

		try {
			loop: while(true) {
				if(!col[i][j+num]) return ret;

				if(!row[i+num][j]) return ret;

				num++;

				for(int x=j ; x<j+num ; x++) {
					if(!col[i+num][x]) continue loop;
				}

				for(int x=i ; x<i+num ; x++) {
					if(!row[x][j+num]) continue loop;
				}
				ret++;
			}
		}catch(Exception e) {
		}

		return ret;
	}
}
