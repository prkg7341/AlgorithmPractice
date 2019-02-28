package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Tomato {

	static Queue<Position> queue = new LinkedList<>();
	static boolean[][] checked;
	static int col;
	static int row;
	static int[] dx = {-1,0,0,1};
	static int[] dy = {0,1,-1,0};
	static int count = 0;
	static int max = 0;
	static Position[][] ar ;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		col = Integer.parseInt(input[0]);
		row = Integer.parseInt(input[1]);

		checked = new boolean[row][col];

		ar = new Position[row][col];

		int num = row*col;

		for(int i=0 ; i<row ; i++){
			input = br.readLine().split(" ");
			for(int j=0 ; j<col ; j++){
				int state = Integer.parseInt(input[j]);
				ar[i][j] = new Position(i,j,state);
				if(ar[i][j].state==1){
					checked[i][j] = true;
					queue.add(ar[i][j]);
				}
				if(ar[i][j].state==-1){
					num--;
				}
			}
		}
		bfs();

		if(count!=num) {
			System.out.println(-1);
		}
		else{
			System.out.println(max);
		}
	}

	private static void bfs() {
		while(!queue.isEmpty()){
			Position now = queue.poll();
			count++;
			max = Math.max(max, now.day);

			for(int i=0 ; i<4 ; i++){
				int nextX = now.x+dx[i];
				int nextY = now.y+dy[i];
				if(nextX!=-1 && nextX!=row && nextY!=-1 && nextY!=col){
					if(!checked[nextX][nextY]){
						Position next = ar[nextX][nextY];
						if(next.state==0){
							checked[next.x][next.y] = true;
							next.day = now.day+1;
							queue.add(next);
						}
					}
				}
			}
		}

	}

	static class Position{
		int x;
		int y;
		int state;
		int day;
		Position(int x, int y, int state){
			this.x = x;
			this.y = y;
			this.state = state;
		}
	}
}
