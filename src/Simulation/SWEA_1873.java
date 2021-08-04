package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1873 {

	// 동서남북
	static int[] dr = {0,0,1,-1};
	static int[] dc = {1,-1,0,0};

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for(int tt=1 ; tt<=t ; tt++) {
			String[] input = br.readLine().split(" ");

			int r = Integer.parseInt(input[0]);
			int c = Integer.parseInt(input[1]);

			char[][] ar = new char[r][c];

			int row=0, col=0, dir=0;

			for(int i=0 ; i<r ; i++) {
				ar[i] = br.readLine().toCharArray();
				for(int j=0 ; j<c ; j++) {
					char now = ar[i][j];

					if(now=='^') {
						row = i; col = j;
						dir = 3;
					}
					else if(now=='<') {
						row = i; col = j;
						dir = 1;
					}
					else if(now=='>') {
						row = i; col = j;						
					}
					else if(now=='v') {
						row = i; col = j;
						dir = 2;
					}
				}
			}

			int n = Integer.parseInt(br.readLine());

			char[] command = br.readLine().toCharArray();

			for(int i=0 ; i<n ; i++) {
				char now = command[i];

				switch(now) {
				case 'U':
					dir = 3;
					ar[row][col] = '^';
					if(row+dr[dir]>=0 && ar[row+dr[dir]][col]=='.') {
						ar[row][col] = '.';
						row += dr[dir];
						ar[row][col] = '^';
					}
					break;
				case 'D':
					dir = 2;
					ar[row][col] = 'v';
					if(row+dr[dir]<r && ar[row+dr[dir]][col]=='.') {
						ar[row][col] = '.';
						row += dr[dir];
						ar[row][col] = 'v';
					}
					break;
				case 'L':
					dir = 1;
					ar[row][col] = '<';
					if(col+dc[dir]>=0 && ar[row][col+dc[dir]]=='.') {
						ar[row][col] = '.';
						col += dc[dir];
						ar[row][col] = '<';
					}
					break;
				case 'R':
					dir = 0;
					ar[row][col] = '>';
					if(col+dc[dir]<c && ar[row][col+dc[dir]]=='.') {
						ar[row][col] = '.';
						col += dc[dir];
						ar[row][col] = '>';
					}
					break;
				case 'S':
					int brow=row, bcol=col;

					try {
						do {
							brow += dr[dir];
							bcol += dc[dir];
						}
						while(brow<r && brow>=0 && col<c && bcol>=0 && (ar[brow][bcol]=='.' || ar[brow][bcol]=='-'));

						if(brow<r && brow>=0 && col<c && bcol>=0 && ar[brow][bcol]=='*') {
							ar[brow][bcol]='.';
						}
					}catch(Exception e) {
						continue;
					}

					break;
				}				
			}
			System.out.print("#"+tt+" ");
			StringBuilder sb = new StringBuilder();
			for(int i=0 ; i<r ; i++) {
				for(int j=0 ; j<c ; j++) {
					sb.append(ar[i][j]);
				}
				sb.append("\n");
			}
			System.out.print(sb.toString());
		}
	}	
}
