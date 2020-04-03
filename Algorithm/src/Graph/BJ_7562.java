package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_7562 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		int[] dx = {-1,-1,-2,-2,1,1,2,2};
		int[] dy = {-2,2,-1,1,-2,2,-1,1};

		test:
			for(int tt=1 ; tt<=t ; tt++){

				int size = Integer.parseInt(br.readLine());

				boolean[][] visit = new boolean[size][size];

				String[] input = br.readLine().split(" ");

				int fromX = Integer.parseInt(input[0]);
				int fromY = Integer.parseInt(input[1]);

				input = br.readLine().split(" ");

				int toX = Integer.parseInt(input[0]);
				int toY = Integer.parseInt(input[1]);

				if(fromX==toX && fromY==toY){
					sb.append(0).append("\n");
					continue;
				}

				Queue<Position> q = new LinkedList<>();

				visit[fromX][fromY] = true;
				q.add(new Position(fromX, fromY));

				int count = 1;
				int checkX = -1;
				int checkY = -1;

				while(!q.isEmpty()){
					Position now = q.poll();

					if(checkX==now.x && checkY==now.y){
						checkX = -1;
						checkY = -1;
						count++;
					}

					for(int i=0 ; i<8 ; i++){
						int nextX = now.x+dx[i];
						int nextY = now.y+dy[i];
						if(nextX>=0 && nextX<size && nextY>=0 && nextY<size){
							if(nextX==toX && nextY==toY){
								sb.append(count).append("\n");
								continue test;
							}
							if(!visit[nextX][nextY]){								
								if(checkX==-1){
									checkX = nextX;
									checkY = nextY;
								}
								visit[nextX][nextY] = true;
								q.add(new Position(nextX, nextY));
							}
						}
					}
				}
			}
		sb.deleteCharAt(sb.length()-1);
		System.out.print(sb.toString());
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
