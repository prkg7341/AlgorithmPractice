package JongMan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class JumpGame {

	static int[][] table;
	static boolean[][] checked;
	static int size;
	static Queue<Point> queue;
	static boolean no;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		for(int i=0 ; i<n ; i++){
			size= Integer.parseInt(br.readLine());
			table = new int[size][size];
			checked = new boolean[size][size];
			no = true;
			queue = new LinkedList<>();

			for(int j=0 ; j<size ; j++){
				String[] input = br.readLine().split(" ");
				for(int k=0 ; k<size ; k++){
					table[j][k] = Integer.parseInt(input[k]);
				}
			}
			// ------------------------------------------------------
			checked[0][0] = true;
			queue.add(new Point(0,0));

			bfs();
			if(no){
				System.out.println("NO");
			}
		}
	}

	private static void bfs() {

		while(!queue.isEmpty()){
			Point now = queue.poll();
			int x = now.x;
			int y = now.y;

			if(x==size-1 && y==size-1){
				System.out.println("YES");
				no = false;
				if(queue.size()==0){
				}
				return;
			}
			int num = table[x][y];

			if(x+num<size && !checked[x+num][y]){
				checked[x+num][y] = true;
				queue.add(new Point(x+num,y));
			}
			if(y+num<size && !checked[x][y+num]){
				checked[x][y+num] = true;
				queue.add(new Point(x,y+num));
			}
		}
	}	

	static class Point{
		int x;
		int y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}
