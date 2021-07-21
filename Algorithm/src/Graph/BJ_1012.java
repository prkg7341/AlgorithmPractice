package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_1012 {

	static boolean[][] is;
	static boolean[][] checked;
	static int[] dx = {-1,0,0,1};
	static int[] dy = {0,1,-1,0};
	static int col;
	static int row;
	static int count;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for(int tt=0 ; tt<t ; tt++){
			count=0;
			String[] input = br.readLine().split(" ");

			col = Integer.parseInt(input[0]);
			row = Integer.parseInt(input[1]);
			int n = Integer.parseInt(input[2]);

			is = new boolean[row][col];
			checked = new boolean[row][col];

			for(int i=0 ; i<n ; i++){
				input = br.readLine().split(" ");
				int y = Integer.parseInt(input[0]);
				int x = Integer.parseInt(input[1]);

				is[x][y] = true;
			}

			for(int i=0 ; i<row ; i++){
				for(int j=0 ; j<col ; j++){
					if(is[i][j] && !checked[i][j])
						bfs(i,j);
				}
			}

			System.out.println(count);
		}
	}

	private static void bfs(int p, int q) {
		Queue<Position> queue = new LinkedList<>();

		queue.add(new Position(p,q));
		checked[p][q] = true;

		while(!queue.isEmpty()){
			Position now = queue.poll();
			int x = now.x;
			int y = now.y;
			for(int i=0 ; i<4 ; i++){
				int newX = x+dx[i];
				int newY = y+dy[i];

				if(newX!=-1 && newY!=-1 && newX!=row && newY!=col){
					if(is[newX][newY] && !checked[newX][newY]){
						checked[newX][newY] = true;
						queue.add(new Position(newX, newY));
					}
				}
			}
		}
		count++;
	}
	static class Position{
		int x;
		int y;
		Position(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}
