package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Alphabet_BFS {

	static int row;
	static int col;

	static char[][] table;
	static boolean[] has;
	static boolean[][] visit;

	static int[] dx = {-1,0,0,1};
	static int[] dy = {0,-1,1,0};

	static int max = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		row = Integer.parseInt(input[0]);
		col = Integer.parseInt(input[1]);

		table = new char[row][col];
		visit = new boolean[row][col];

		for(int i=0 ; i<row ; i++){
			table[i] = br.readLine().toCharArray();
		}
		Queue<Position> q = new LinkedList<>();
		visit[0][0] = true;
		has = new boolean[26];
		has[table[0][0]-'A'] = true;
		q.add(new Position(0,0,1));
		bfs(q);		
		System.out.print(max);
	}

	private static void bfs(Queue<Position> q) {
		while(!q.isEmpty()){
			Position now = q.poll();
			max = Math.max(max, now.count);
			for(int i=0 ; i<4 ; i++){
				int newX = now.x+dx[i];
				int newY = now.y+dy[i];
				if(newX!=-1 && newX!=row && newY!=-1 && newY!=col){
					if(!visit[newX][newY] && !has[(int)(table[newX][newY]-'A')]){
						Position newP = new Position(newX,newY,now.count+1);
						has[(int)(table[newX][newY]-'A')] = true;
						visit[newX][newY] = true;
						Queue<Position> nq = new LinkedList<>();
						nq.add(newP);
						bfs(nq);
						has[(int)(table[newX][newY]-'A')] = false;
						visit[newX][newY] = false;
					}
				}
			}
		}		
	}

	static class Position{
		int x;
		int y;
		int count;
		Position(int x, int y, int count){
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}
}
