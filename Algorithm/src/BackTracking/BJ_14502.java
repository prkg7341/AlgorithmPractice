package BackTracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_14502 {

	static int max = 0;
	static int v;
	static Queue<Position> virus = new LinkedList<>();
	static Queue<Position> q;
	static int[] dx = {-1,0,0,1};
	static int[] dy = {0,-1,1,0};
	static boolean[][] visit;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");

		int m = Integer.parseInt(input[0]);
		int n = Integer.parseInt(input[1]);

		int[][] ar = new int[m][n];
		visit = new boolean[m][n];
		v = m*n;

		for(int i=0 ; i<m ; i++){
			input = br.readLine().split(" ");
			for(int j=0 ; j<n ; j++){
				int now = Integer.parseInt(input[j]);
				ar[i][j] = now;
				if(now==2) {
					virus.add(new Position(i, j));
					v--;
					visit[i][j] = true;
				}
				if(now==1) v--;
			}
		}

		btrk(ar, 0, 0, 0);

		bw.write(String.valueOf(max));

		bw.flush();
	}

	private static void btrk(int[][] ar, int count, int x, int y) {
		if(count==3){
			int nums = 0;
			boolean[][] temp = new boolean[visit.length][visit[0].length];
			for(int i=0 ; i<temp.length ; i++){
				for(int j=0 ; j<temp[0].length ; j++){
					temp[i][j] = visit[i][j];
				}
			}
			q = new LinkedList<>(virus);
			while(!q.isEmpty()){
				Position now = q.poll();
				for(int i=0 ; i<4 ; i++){
					int newX = now.x+dx[i];
					int newY = now.y+dy[i];
					if(newX<ar.length && newX>=0 && newY<ar[0].length && newY>=0){
						if(ar[newX][newY]==0 && !temp[newX][newY]){
							temp[newX][newY] = true;
							q.add(new Position(newX, newY));
							nums++;
						}
					}
				}
			}
			max = Math.max(max, v-nums);
			return;
		}

		int nextX = x;
		int nextY = y+1;
		if(nextY==ar[0].length) {
			nextY = 0;
			nextX++;
		}
		if(nextX==ar.length && nextY!=0) return;
		if(ar[x][y]==0){
			ar[x][y] = 1; v--;
			btrk(ar, count+1, nextX, nextY);
			ar[x][y] = 0; v++;
		}
		btrk(ar, count, nextX, nextY);
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
