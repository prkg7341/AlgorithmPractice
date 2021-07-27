package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_4179{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		int r = Integer.parseInt(input[0]);
		int c = Integer.parseInt(input[1]);

		boolean[][] visit = new boolean[r][c];

		Queue<Position> fire = new LinkedList<>();
		Queue<Position> jh = new LinkedList<>();

		int[] dr = {0,-1,0,1};
		int[] dc = {-1,0,1,0};

		for(int i=0 ; i<r ; i++) {
			char[] temp = br.readLine().toCharArray();
			for(int j=0 ; j<c ; j++) {
				switch(temp[j]) {
				case 'J':
					visit[i][j] = true;
					jh.add(new Position(i,j));
					break;
				case 'F':
					visit[i][j] = true;
					fire.add(new Position(i,j));
					break;
				case '#':
					visit[i][j] = true;					
					break;
				}
			}			
		}
		int count = 0;

		while(true) {

			count++;

			int len = fire.size();

			for(int i=0 ; i<len ; i++) {
				Position now = fire.poll();

				for(int j=0 ; j<4 ; j++) {
					int newR = now.r+dr[j];
					int newC = now.c+dc[j];

					if(newR>=0 && newR<r && newC>=0 && newC<c && !visit[newR][newC]) {
						visit[newR][newC] = true;
						fire.add(new Position(newR,newC));
					}
				}
			}

			len = jh.size();

			if(len==0) {
				System.out.println("IMPOSSIBLE");
				return;
			}

			for(int i=0 ; i<len ; i++) {
				Position now = jh.poll();

				for(int j=0 ; j<4 ; j++) {
					int newR = now.r+dr[j];
					int newC = now.c+dc[j];

					if(newR<0 || newR>=r || newC<0 || newC>=c) {						
						System.out.println(count);
						return;
					}
					else if(!visit[newR][newC]) {
						visit[newR][newC] = true;
						jh.add(new Position(newR, newC));
					}
				}
			}
		}
	}

	static class Position{
		int r,c;
		Position(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
}