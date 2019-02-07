package Graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class NumberOfIslands {

	static Map[][] ar;
	static int col;
	static int row;
	static int[] dc = {-1,-1,-1,0,0,1,1,1};
	static int[] dr = {-1,0,1,-1,1,-1,0,1};

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		while(true){
			// 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			col = Integer.parseInt(st.nextToken());
			row = Integer.parseInt(st.nextToken());

			if(col==0 && row==0) break;

			int count = 0;

			ar =  new Map[row][col];

			for(int i=0 ; i<row ; i++){
				st = new StringTokenizer(br.readLine());
				for(int j=0 ; j<col ; j++){
					ar[i][j] = st.nextToken().compareTo("1")==0? new Map(true) : new Map(false);
				}
			}
			// 풀이
			for(int i=0 ; i<row ; i++){
				for(int j=0 ; j<col ; j++){
					if(check(i,j)){
						count++;
					}
				}
			}
			// 출력
			sb.append(String.valueOf(count)+"\n");
		}
		if(sb.length()!=0) sb.deleteCharAt(sb.length()-1);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static boolean check(int r, int c) {

		if(r>row-1 || c>col-1 || r==-1 || c==-1){
			return false;
		}

		Map now = ar[r][c];

		if(now.isIsland==false || now.isChecked==true){
			return false;
		}

		now.isChecked = true;

		for(int i=0 ; i<8 ; i++){
			check(r+dr[i], c+dc[i]);
		}

		return true;		
	}

	static class Map{
		boolean isIsland;
		boolean isChecked;
		Map(boolean isIsland){
			this.isIsland = isIsland;
			isChecked = false;
		}
	}
}
