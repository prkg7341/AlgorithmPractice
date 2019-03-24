package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GettingAreas {

	static int row;
	static int col;
	static boolean[][] checked;
	static boolean[][] isWall;
	static int count=0;
	static ArrayList<Integer> list;
	static int[] dx = {-1,0,0,1};
	static int[] dy = {0,-1,1,0};

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] input = br.readLine().split(" ");

		row = Integer.parseInt(input[0]);
		col = Integer.parseInt(input[1]);

		int num = Integer.parseInt(input[2]);

		checked = new boolean[col][row];		
		isWall= new boolean[col][row];

		list = new ArrayList<>();

		for(int i=0 ; i<num ; i++){
			input = br.readLine().split(" ");

			int minX = Integer.parseInt(input[0]);
			int minY = Integer.parseInt(input[1]);
			int maxX = Integer.parseInt(input[2]);
			int maxY = Integer.parseInt(input[3]);

			for(int j=minX ; j<maxX ; j++){
				for(int k=minY ; k<maxY ; k++){
					isWall[j][k] = true;
				}
			}
		}		
		for(int i=0 ; i<row ; i++){
			for(int j=0 ; j<col ; j++){
				if(!isWall[j][i] && !checked[j][i]){
					bfs(j,i);
					count++;
				}
			}
		}
		sb.append(count+"\n");
		for(int area : list){
			sb.append(area+" ");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.print(sb.toString());
	}

	private static void bfs(int x, int y) {
		Queue<Position> queue = new LinkedList<>();

		int area=0;

		checked[x][y] = true;
		queue.add(new Position(x,y));

		while(!queue.isEmpty()){
			area++;
			Position now = queue.poll();
			for(int i=0 ; i<4 ; i++){
				int newX = now.x+dx[i];
				int newY = now.y+dy[i];
				if(newX==-1 || newX==col || newY==-1 || newY==row) continue;
				if(!isWall[newX][newY] && !checked[newX][newY]){
					checked[newX][newY] = true;
					queue.add(new Position(newX,newY));
				}
			}
		}
		list.add(biSearch(area, 0, list.size()-1),area);
	}

	private static int biSearch(int value, int start, int end){

		if(list.size()==0) return 0;

		if(start>end){			
			return start;
		}

		int mid = (start+end)/2;

		if(value==list.get(mid)){
			return mid;
		}
		else if(value>list.get(mid)){
			return biSearch(value,mid+1,end);
		}
		else{
			return biSearch(value,start,mid-1);
		}
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