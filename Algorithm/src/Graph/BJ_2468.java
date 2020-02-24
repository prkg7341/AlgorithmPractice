package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_2468 {

	static int[] rx = {-1,0,0,1};
	static int[] ry = {0,-1,1,0};

	static int row;
	static int col;

	static int[][] height;
	static boolean[][] check;
	static boolean[][] safe;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		row = n;
		col = n;

		height = new int[row+1][col+1];
		check = new boolean[row+1][col+1];

		for(int i=1 ; i<=n ; i++){
			String[] input = br.readLine().split(" ");
			for(int j=1 ; j<=col ; j++){
				height[i][j] = Integer.parseInt(input[j-1]);
			}
		}

		int max = 0;

		for(int h=0 ; h<=100 ; h++){

			safe = new boolean[row+1][col+1];
			for(int i=1 ; i<=row ; i++){
				for(int j=1 ; j<=col ; j++){
					if(height[i][j]>h) safe[i][j] = true;
				}
			}

			check = new boolean[row+1][col+1];

			int count = 0;

			for(int i=1 ; i<=row ; i++){
				for(int j=1 ; j<=col ; j++){
					if(!check[i][j] && safe[i][j]){
						bfs(i,j,h);
						count++;
					}
				}
			}
			max = Math.max(max, count);
		}

		System.out.print(max);
	}

	private static void bfs(int x, int y, int h) {
		check[x][y] = true;

		Queue<Position> q = new LinkedList<>();

		q.add(new Position(x,y));		

		while(!q.isEmpty()){
			Position now = q.poll();
			for(int i=0 ; i<4 ; i++){
				int newX = now.x+rx[i];
				int newY = now.y+ry[i];
				if(newX>=1 && newX<=row && newY>=1 && newY<=col)
					if(safe[newX][newY])
						if(!check[newX][newY]){
							check[newX][newY] = true;
							q.add(new Position(newX,newY));
						}
			}
		}
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
