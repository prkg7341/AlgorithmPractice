package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Alphabet_BackTracking {

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
		visit[0][0] = true;
		has = new boolean[26];
		has[table[0][0]-'A'] = true;
		bt(0,0,1);
		System.out.print(max);
	}

	private static void bt(int x, int y, int count) {
		max = Math.max(max, count);
		for(int i=0 ; i<4 ; i++){
			int newX = x+dx[i];
			int newY = y+dy[i];
			if(newX!=-1 && newX!=row && newY!=-1 && newY!=col){
				if(!visit[newX][newY] && !has[(int)(table[newX][newY]-'A')]){
					has[(int)(table[newX][newY]-'A')] = true;
					visit[newX][newY] = true;
					bt(newX,newY,count+1);
					has[(int)(table[newX][newY]-'A')] = false;
					visit[newX][newY] = false;
				}
			}
		}
	}
}
