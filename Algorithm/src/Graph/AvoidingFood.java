package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class AvoidingFood {

	static int[] rx = {-1,0,0,1};
	static int[] ry = {0,-1,1,0};

	static int row;
	static int col;

	static boolean[][] has;
	static boolean[][] check;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		row = Integer.parseInt(input[0]);
		col = Integer.parseInt(input[1]);
		int num = Integer.parseInt(input[2]);

		has = new boolean[row+1][col+1];
		check = new boolean[row+1][col+1];

		for(int i=0 ; i<num ; i++){
			input = br.readLine().split(" ");
			int r = Integer.parseInt(input[0]);
			int c = Integer.parseInt(input[1]);
			has[r][c] = true;
		}

		int max = 0;

		for(int i=1 ; i<=row ; i++){
			for(int j=1 ; j<=col ; j++){
				if(has[i][j] && !check[i][j]){
					max = Math.max(max, bfs(i,j));
				}
			}
		}
		System.out.print(max);
	}

	private static int bfs(int x, int y) {
		check[x][y] = true;
		int count = 1;

		Queue<Position> q = new LinkedList<>();

		q.add(new Position(x,y));		

		while(!q.isEmpty()){
			Position now = q.poll();
			for(int i=0 ; i<4 ; i++){
				int newX = now.x+rx[i];
				int newY = now.y+ry[i];
				if(newX>=1 && newX<=row && newY>=1 && newY<=col)
					if(has[newX][newY] && !check[newX][newY]){
						count++;
						check[newX][newY] = true;
						q.add(new Position(newX,newY));
					}
			}
		}

		return count;
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
