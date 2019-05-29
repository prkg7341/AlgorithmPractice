package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Escape {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] dx = {-1,0,0,1};
		int[] dy = {0,-1,1,0};

		int row;
		int col;

		String[] input = br.readLine().split(" ");

		row = Integer.parseInt(input[0]);
		col = Integer.parseInt(input[1]);

		char[][] map = new char[row][col];
		boolean[][] visit = new boolean[row][col];

		int startX = -1;
		int startY = -1;

		Queue<Position> water = new LinkedList<>();

		for(int i=0 ; i<row ; i++){
			map[i] = br.readLine().toCharArray();
			for(int j=0 ; j<col ; j++){
				if(map[i][j]=='S'){
					startX = i;
					startY = j;
				}
				else if(map[i][j]=='*'){
					water.add(new Position(i,j));
				}
			}
		}

		Queue<Position> q = new LinkedList<>();
		visit[startX][startY] = true;
		q.add(new Position(startX,startY));

		int count = 1;
		int checkX = -1;
		int checkY = -1;

		int size = water.size();
		for(int s=0 ; s<size ; s++){
			Position w = water.poll();
			for(int i=0 ; i<4 ; i++){
				int newX = w.x+dx[i];
				int newY = w.y+dy[i];

				if(newX>=0 && newX<row && newY>=0 && newY<col){
					visit[newX][newY] = true;
					water.add(new Position(newX, newY));
				}
			}
		}

		while(!q.isEmpty()){
			Position now = q.poll();

			if(now.x==checkX && now.y==checkY){
				count++;
				checkX = -1;

				size = water.size();
				for(int s=0 ; s<size ; s++){
					Position w = water.poll();
					for(int i=0 ; i<4 ; i++){
						int newX = w.x+dx[i];
						int newY = w.y+dy[i];

						if(newX>=0 && newX<row && newY>=0 && newY<col){
							if(map[newX][newY]=='.'){
								visit[newX][newY] = true;
								map[newX][newY] = '*';
								water.add(new Position(newX, newY));
							}
						}
					}
				}
			}

			for(int i=0 ; i<4 ; i++){
				int newX = now.x+dx[i];
				int newY = now.y+dy[i];

				if(newX>=0 && newX<row && newY>=0 && newY<col){
					if(map[newX][newY]=='D'){
						System.out.print(count);
						return;
					}
					else if(map[newX][newY]=='.' && !visit[newX][newY]){
						if(checkX==-1){
							checkX = newX;
							checkY = newY;
						}

						visit[newX][newY] = true;
						q.add(new Position(newX, newY));
					}
				}
			}
		}
		System.out.print("KAKTUS");
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
