package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class RedGreenColorWeakness {

	static int[] rx = {-1,0,0,1};
	static int[] ry = {0,-1,1,0};

	static int row;
	static int col;

	static char[][] color;
	static boolean[][] check;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		row = n;
		col = n;

		color = new char[row+1][];
		check = new boolean[row+1][col+1];

		for(int i=0 ; i<n ; i++){
			color[i+1] = br.readLine().toCharArray();
		}

		int count = 0;

		for(int i=1 ; i<=row ; i++){
			for(int j=0 ; j<col ; j++){
				if(!check[i][j]){
					bfs(i,j);
					count++;
				}
			}
		}
		System.out.print(count+" ");

		count = 0;

		for(int i=1 ; i<=row ; i++){
			for(int j=0 ; j<col ; j++){
				if(color[i][j]=='R') color[i][j] = 'G';
				check[i][j] = false;
			}
		}

		for(int i=1 ; i<=row ; i++){
			for(int j=0 ; j<col ; j++){
				if(!check[i][j]){
					bfs(i,j);
					count++;
				}
			}
		}
		System.out.print(count);
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
				if(newX>=1 && newX<=row && newY>=0 && newY<col)
					if(color[newX][newY]==color[x][y])
						if(!check[newX][newY]){
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
