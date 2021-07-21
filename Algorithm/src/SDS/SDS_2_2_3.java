package SDS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SDS_2_2_3 {

	static int n;
	static boolean[][] visit;
	static int[][] ar;
	static int[] dx = {-1,0,0,1};
	static int[] dy = {0,-1,1,0};
	static int count;
	static int odd;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine().split(" ")[0]);

		for(int tt=1 ; tt<=t ; tt++){
			
			count = 0;
			odd = 0;

			n = Integer.parseInt(br.readLine());

			visit = new boolean[n][n];

			ar = new int[n][n];
			
			for(int i=0 ; i<n ; i++){
				String[] input = br.readLine().split(" ");
				for(int j=0 ; j<n ; j++){
					int now = Integer.parseInt(input[j]);
					if(now%2==1){
						odd++;
					}
					ar[i][j] = now;
				}
			}
			
			int ret = biSearch(0, odd);

			sb.append("#").append(tt).append(" ").append(ret).append(" ").append(count-ret).append(" \n");
		}
		System.out.print(sb.toString());
	}

	private static int biSearch(int start, int end) {
		
		if(end>start) return start;
		
		int mid = (start+end)/2;
		
		if(!bfs()){
			return biSearch(mid+1, end);
		}
		else{
			return biSearch(start, mid-1);
		}
	}

	private static boolean bfs() {
		
		Queue<Position> q = new LinkedList<>();
		
		q.add(new Position(0,0,1,odd));
		
		while(!q.isEmpty()){
			Position now = q.poll();
			for(int i=0 ; i<4 ; i++){
				int newX = now.x+dx[i];
				int newY = now.y+dy[i];
				if(newX>=0 && newY>=0 && newX<n && newY<n){
					// TODO µµÂøÁ¡ÀÌ¸é return true
					int newOdd = now.odd;
					if(ar[newX][newY]%2==1) newOdd--;
					q.add(new Position(newX, newY, now.count+1, newOdd));
				}
			}
		}
		
		return false;
	}
	static class Position{
		int x;
		int y;
		int count;
		int odd;
		Position(int x, int y, int count, int odd){
			this.x = x;
			this.y = y;
			this.count = count;
			this.odd = odd;
		}
	}
}
