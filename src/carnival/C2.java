package carnival;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class C2 {

	static int[] dx = new int[] {-1,0,0,1};
	static int[] dy = new int[] {0,1,-1,0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		
		int[][] ar = new int[n][n];
		
		int dc=0, dr=0;
		
		for(int i=0 ; i<n ; i++) {
			String input = br.readLine();
			for(int j=0 ; j<n ; j++) {
				char now = input.charAt(j);
				switch(now) {
				case 'X':
					ar[i][j] = 1;
					break;
				case 'D':
					dc = i; dr = j;
					break;
				}
			}
		}
		
		int ret = 0;
		boolean done1 = false;
		boolean done2 = false;
		
		String[] input = br.readLine().split(" ");

		int c1 = Integer.parseInt(input[0]);
		int r1 = Integer.parseInt(input[1]);
		int c2 = Integer.parseInt(input[2]);
		int r2 = Integer.parseInt(input[3]);
		
		Queue<Position> q = new LinkedList<>();
		
		q.add(new Position(c1,r1,c2,r2,0));
		
		while(!q.isEmpty()) {
			Position now = q.poll();
			
			System.out.println(now.c1+" "+now.r1+" "+now.c2+" "+now.r2);
			
			for(int i=0 ; i<4 ; i++) {				
				if(done1 && done2) {
					bw.write(String.valueOf(ret));
					break;
				}
				
				int newc1 = now.c1 +dx[i];
				int newr1 = now.r1 +dy[i];
				int newc2 = now.c2 +dx[i];
				int newr2 = now.r2 +dy[i];
				
				if(done1 || newc1>=n || newr1>=n || newc1<0 || newr1<0 || (ar[newc1][newr1]==1) || (ar[newc1][newr1]==-1) || (ar[newc1][newr1]==-3)) {
					if(done2 || newc2>=n || newr2>=n || newc2<0 || newr2<0 || (ar[newc2][newr2]==1) || (ar[newc2][newr2]==-2) || (ar[newc2][newr2]==-3)) {
						continue;
					}
					else {
						if(newc2==dc && newr2==dr) {
							done2 = true;
							ret = Math.max(ret, now.count+1);
							System.out.println("done2!!");
							continue;
						}
						newc1 = now.c1; newr1 = now.r1;
						ar[newc2][newr2] -= 2;
					}
				}
				else if(done2 || newc2>=n || newr2>=n || newc2<0 || newr2<0 || (ar[newc2][newr2]==1) || (ar[newc2][newr2]==-2) || (ar[newc2][newr2]==-3)){
					if(newc1==dc && newr1==dr) {
						done1 = true;
						ret = Math.max(ret, now.count+1);
						System.out.println("done1!!");
						continue;
					}
					newc2 = now.c2; newr2 = now.r2;
					ar[newc1][newr1] -= 1;
				}
				else {
					ar[newc1][newr1] -= 1;
					ar[newc2][newr2] -= 2;
				}
				q.add(new Position(newc1, newr1, newc2, newr2, now.count+1));
			}
			
			if(done1 && done2) {
				bw.write(String.valueOf(ret));
				break;
			}
		}
		
		if(!done1 || !done2) bw.write(String.valueOf(-1));		
		bw.flush();
	}
	
	static class Position{
		int c1, c2, r1, r2, count;
		Position(int c1, int r1, int c2, int r2, int count){
			this.c1 = c1;
			this.r1 = r1;
			this.c2 = c2;
			this.r2 = r2;			
			this.count = count;
		}
	}
}