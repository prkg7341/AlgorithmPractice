package Naver2021_Intern;

public class N4 {
	public int solution(int[][] maze) {
		int answer = 0;

		int[][] ar = new int[maze.length+2][maze.length+2];

		for(int i=0 ; i<ar.length ; i++) {
			for(int j=0 ; j<ar.length ; j++) {
				if(i==0 || j==0 || i==ar.length-1 || j==ar.length-1) {
					ar[i][j] = 1;
				}
				else {
					ar[i][j] = maze[i-1][j-1];
				}
			}
		}

		int c = 1;
		int r = 1;
		int[] dc = {0,1,0,-1};
		int[] dr = {1,0,-1,0};
		int d = 0; // ¹Ø, ¿À, À§, ¿Þ        

		while(!(c==ar.length-2 && r==ar.length-2)) {
			int left_c = c+dc[(d+1)%4];
			int left_r = r+dr[(d+1)%4];

			if(ar[left_r][left_c]==1) {
				int nect_c = c+dc[d];
				int nect_r = r+dr[d];
				while(ar[nect_r][nect_c]!=0) {
					d = (d+3)%4;
					nect_c = c+dc[d];
					nect_r = r+dr[d];
				}
				c = nect_c;
				r = nect_r;
				answer++;
			}
			else {
				d = (d+1)%4;
				c = left_c;
				r = left_r;
				answer++;
			}
		}

		return answer;
	}	
}
