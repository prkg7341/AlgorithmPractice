package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_5427 {

	static int[] dx = {-1,0,0,1};
	static int[] dy = {0,-1,1,0};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String input;

		int t = Integer.parseInt(br.readLine());

		test:
			for(int tt=1 ; tt<=t ; tt++){

				input = br.readLine();

				String[] split = input.split(" ");

				int low = Integer.parseInt(split[1]);
				int col = Integer.parseInt(split[0]);

				char[][] building = new char[low][col];
				boolean[][] visit = new boolean[low][col];

				int startX=-1;
				int startY=-1;

				Queue<Position> fire = new LinkedList<>();

				for(int i=0 ; i<low ; i++){
					char[] temp = br.readLine().toCharArray();
					for(int j=0 ; j<col ; j++){
						building[i][j] = temp[j];
						if(temp[j]=='@'){
							startX = i;
							startY = j;
						}
						else if(temp[j]=='*'){
							fire.add(new Position(i,j));
						}
					}
				}

				Queue<Position> q = new LinkedList<>();
				visit[startX][startY] = true;
				q.add(new Position(startX, startY));

				int size = fire.size();

				for(int s=0 ; s<size ; s++){
					Position f = fire.poll();
					for(int i=0 ; i<4 ; i++){
						int newX = f.x+dx[i];
						int newY = f.y+dy[i];

						if(newX>=0 && newX<low){
							if(newY>=0 && newY<col){
								if(building[newX][newY]=='.'){
									building[newX][newY] = '*';
									visit[newX][newY] = true;
									fire.add(new Position(newX,newY));
								}
							}
						}
					}
				}

				int checkX = -1;
				int checkY = -1;

				int count = 1;

				while(!q.isEmpty()){
					Position now = q.poll();

					if(checkX==now.x && checkY==now.y){
						count++;
						checkX = -1;

						size = fire.size();

						for(int s=0 ; s<size ; s++){
							Position f = fire.poll();
							for(int i=0 ; i<4 ; i++){
								int newX = f.x+dx[i];
								int newY = f.y+dy[i];

								if(newX>=0 && newX<low){
									if(newY>=0 && newY<col){
										if(building[newX][newY]=='.'){
											building[newX][newY] = '*';
											visit[newX][newY] = true;
											fire.add(new Position(newX,newY));
										}
									}
								}
							}
						}
					}

					for(int i=0 ; i<4 ; i++){
						int newX = now.x+dx[i];
						int newY = now.y+dy[i];

						if(newX==-1 || newX==low || newY==-1 || newY==col){
							sb.append(count).append("\n");
							continue test;
						}

						if(newX>=0 && newX<low){
							if(newY>=0 && newY<col){
								if(!visit[newX][newY]){
									visit[newX][newY] = true;
									if(building[newX][newY]=='.'){
										if(checkX==-1){
											checkX = newX;
											checkY = newY;
										}
										q.add(new Position(newX,newY));
									}
								}
							}
						}
					}
				}
				sb.append("IMPOSSIBLE").append("\n");
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
