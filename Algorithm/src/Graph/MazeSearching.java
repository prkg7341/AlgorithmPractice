package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class MazeSearching {

	static Map[][] ar;
	static int n,m;
	static int c = 0;
	static int[] dx = {-1,0,0,1};
	static int[] dy = {0,-1,1,0};

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		ar = new Map[n][m];

		for(int i=0 ; i<n ; i++){
			String[] input = br.readLine().split("");
			for(int j=0 ; j<m ; j++){
				int now = Integer.parseInt(input[j]);
				ar[i][j] = now==1? new Map(i,j,true) : new Map(i,j,false);
			}
		}

		bfs();

		System.out.println(String.valueOf(c));
	}

	private static void bfs() {
		Queue<Map> q = new LinkedList<>();

		q.add(ar[0][0]);

		while(!q.isEmpty()){
			Map now = q.poll();

			if(now.x==n-1 && now.y==m-1){
				c = now.count;
				return;
			}
			
			for(int i=0 ; i<4 ; i++){
				int newX = now.x+dx[i];
				int newY = now.y+dy[i];
				if(!(newX==-1 || newY==-1 || newX==n || newY==m)){
					Map next = ar[newX][newY];
					if(next.canGo==true && next.isChecked==false){
						next.count = now.count+1;
						next.isChecked = true;
						q.add(next);
					}
				}
			}
		}
	}

	static class Map{
		boolean canGo;
		boolean isChecked;
		int x;
		int y;
		int count;
		Map(int x, int y, boolean canGo){
			this.canGo = canGo;
			isChecked = false;
			this.x = x;
			this.y = y;
			count = 1;
		}
	}
}
