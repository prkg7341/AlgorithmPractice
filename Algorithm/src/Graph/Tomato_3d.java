package Graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Tomato_3d {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[] dx = {-1,0,0,0,0,1};
		int[] dy = {0,-1,1,0,0,0};
		int[] dz = {0,0,0,-1,1,0};

		String[] input = br.readLine().split(" ");
		int m = Integer.parseInt(input[0]);
		int n = Integer.parseInt(input[1]);
		int h = Integer.parseInt(input[2]);

		int[][][] box = new int[h][n][m];

		int all = m*n*h;
		int done = all;

		Queue<Position> q = new LinkedList<>();

		for(int i=0 ; i<h ; i++){
			for(int j=0 ; j<n ; j++){
				input = br.readLine().split(" ");
				for(int k=0 ; k<m ; k++){
					int to = Integer.parseInt(input[k]);
					if(to==0) done--;
					if(to==1) q.add(new Position(i,j,k,0));
					if(to==-1) {
						all--;
						done--;
					}
					box[i][j][k] = to;
				}
			}
		}

		if(done==all) {
			bw.write(String.valueOf(0));
		}

		else{
			int count = 0;
			while(!q.isEmpty()){
				Position now = q.poll();
				for(int i=0 ; i<6 ; i++){
					int newX = now.x+dx[i];
					int newY = now.y+dy[i];
					int newZ = now.z+dz[i];
					if(newX>=h || newX<0 || newY>=n || newY<0 || newZ>=m || newZ<0) continue;
					if(box[newX][newY][newZ]==0){
						box[newX][newY][newZ] = 1;
						q.add(new Position(newX, newY, newZ, now.day+1));
						done++;
					}
				}
				count = Math.max(count, now.day+1);
				if(done==all) break;
			}

			if(done==all) bw.write(String.valueOf(count));
			else bw.write(String.valueOf(-1));
		}

		bw.flush();
	}

	static class Position{
		int x; //h
		int y; //n
		int z; //m
		int day;
		Position(int x, int y, int z, int day){
			this.x = x;
			this.y = y;
			this.z = z;
			this.day = day;
		}
	}
}
