package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class MoveWithBreakingWall {	

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		int row = Integer.parseInt(input[0]);
		int col = Integer.parseInt(input[1]);

		int[][] ar = new int[row][col];
		boolean[][][] visit = new boolean[row][col][2];

		int[] dx = {-1,0,0,1};
		int[] dy = {0,1,-1,0};

		for(int i=0 ; i<row ; i++){
			input = br.readLine().split("");
			for(int j=0 ; j<col ; j++){
				ar[i][j] = Integer.parseInt(input[j]);
			}
		}

		if(row==1 && col==1 && ar[0][0]==0){
			System.out.print(1);
			return;
		}

		Queue<Position> q = new LinkedList<>();

		visit[0][0][0] = true;
		q.add(new Position(0,0,false));

		int count = 2;
		int checkX = -1;
		int checkY = -1;

		while(!q.isEmpty()){
			Position now = q.poll();

			if(now.x==checkX && now.y==checkY){
				checkX = -1;
				count++;
			}

			for(int i=0 ; i<4 ; i++){
				int newX = now.x+dx[i];
				int newY = now.y+dy[i];

				if(newX!=-1 && newX!=row && newY!=-1 && newY!=col){
					if(now.use){
						if(!visit[newX][newY][1]){
							if(newX==row-1 && newY==col-1){
								System.out.print(count);
								return;
							}
							else if(ar[newX][newY]==1){
								if(!now.use){
									if(checkX==-1){
										checkX = newX;
										checkY = newY;
									}
									q.add(new Position(newX, newY, true));
								}
							}
							else{
								if(checkX==-1){
									checkX = newX;
									checkY = newY;
								}
								visit[newX][newY][1] = true;
								q.add(new Position(newX, newY, now.use));
							}
						}
					}
					else{
						if(!visit[newX][newY][0]){
							if(newX==row-1 && newY==col-1){
								System.out.print(count);
								return;
							}
							else if(ar[newX][newY]==1){
								if(!now.use){
									if(checkX==-1){
										checkX = newX;
										checkY = newY;
									}
									q.add(new Position(newX, newY, true));
								}
							}
							else{
								if(checkX==-1){
									checkX = newX;
									checkY = newY;
								}
								visit[newX][newY][0] = true;
								q.add(new Position(newX, newY, now.use));
							}
						}
					}
				}
			}
		}
		System.out.print(-1);
	}

	static class Position{
		int x;
		int y;
		boolean use;
		Position(int x, int y, boolean use){
			this.x = x;
			this.y = y;
			this.use = use;
		}
	}
}
