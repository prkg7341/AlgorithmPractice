package BackTracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class BJ_2580 {

	static int[][] table = new int[9][9];
	static BufferedWriter bw;
	static boolean fin = false;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int count = 0;
		ArrayList<Position> list = new ArrayList<>();

		for(int i=0 ; i<9 ; i++){
			String[] input = br.readLine().split(" ");
			for(int j=0 ; j<9 ; j++){
				int temp = Integer.parseInt(input[j]);
				table[i][j] = temp;
				if(temp==0) {
					count++;
					list.add(new Position(i,j));
				}
			}
		}

		btrk(0, count, list);

		bw.flush();
	}

	private static void btrk(int index, int count, ArrayList<Position> list) {
		if(!fin){
			if(index==count){
				fin = true;
				try{
					for(int i=0 ; i<9 ; i++){
						for(int j=0 ; j<9 ; j++){
							bw.write(table[i][j]+" ");
						}
						bw.write("\n");
					}
				} catch (Exception e){

				}
				return;
			}			
			Position now = list.get(index);
			ArrayList<Integer> nums = new ArrayList<>(9);
			for(int i=1 ; i<=9 ; i++) nums.add(i);

			for(int i=0 ; i<9 ; i++){
				nums.remove((Integer) table[i][now.y]);
			}
			for(int i=0 ; i<9 ; i++){
				nums.remove((Integer) table[now.x][i]);
			}
			for(int i=now.x/3*3 ; i<now.x/3*3+3 ; i++){
				for(int j=now.y/3*3 ; j<now.y/3*3+3 ; j++){
					nums.remove((Integer) table[i][j]);
				}
			}
			for(int i=0 ; i<nums.size() ; i++){
				table[now.x][now.y] = nums.get(i);
				btrk(index+1, count, list);
				table[now.x][now.y] = 0;
			}
		}
	}

	static class Position{
		int x;
		int y;
		Position (int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}
