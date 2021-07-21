package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_6593 {

	static int[] dx = {-1,0,0,0,0,1};
	static int[] dy = {0,-1,1,0,0,0};
	static int[] dz = {0,0,0,-1,1,0};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String input;

		test:
			while(true){

				input = br.readLine();

				if(input.compareTo("0 0 0")==0) {
					sb.deleteCharAt(sb.length()-1);
					System.out.print(sb.toString());
					return;
				}

				String[] split = input.split(" ");

				int layer = Integer.parseInt(split[0]);
				int low = Integer.parseInt(split[1]);
				int col = Integer.parseInt(split[2]);

				char[][][] building = new char[layer][low][col];
				boolean[][][] visit = new boolean[layer][low][col];

				int startX=-1;
				int startY=-1;
				int startZ=-1;

				for(int i=0 ; i<layer ; i++){
					for(int j=0 ; j<low ; j++){
						char[] temp = br.readLine().toCharArray();
						for(int k=0 ; k<col ; k++){
							building[i][j][k] = temp[k];
							if(temp[k]=='S'){
								startX = i;
								startY = j;
								startZ = k;
							}
						}
					}
					br.readLine();
				}
				if(startX==-1 || startY==-1 || startZ==-1){
					sb.append("Trapped!").append("\n");
					continue test;
				}

				Queue<Position> q = new LinkedList<>();
				visit[startX][startY][startZ] = true;
				q.add(new Position(startX, startY, startZ));

				int checkX = -1;
				int checkY = -1;
				int checkZ = -1;

				int count = 1;

				while(!q.isEmpty()){
					Position now = q.poll();					

					if(checkX==now.x && checkY==now.y && checkZ==now.z){
						count++;
						checkX = -1;
					}

					for(int i=0 ; i<6 ; i++){
						int newX = now.x+dx[i];
						int newY = now.y+dy[i];
						int newZ = now.z+dz[i];

						if(newX>=0 && newX<layer){
							if(newY>=0 && newY<low){
								if(newZ>=0 && newZ<col){
									if(!visit[newX][newY][newZ]){
										visit[newX][newY][newZ] = true;
										if(building[newX][newY][newZ]=='E'){
											sb.append("Escaped in ").append(count).append(" minute(s).\n");
											continue test;
										}
										else if(building[newX][newY][newZ]=='.'){
											if(checkX==-1){
												checkX = newX;
												checkY = newY;
												checkZ = newZ;
											}
											q.add(new Position(newX,newY,newZ));
										}
									}
								}
							}
						}
					}
				}
				sb.append("Trapped!").append("\n");

			}
	}

	static class Position{
		int x;
		int y;
		int z;
		Position(int x, int y, int z){
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
}
