package UnionFind;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_14868 {

	static int[] ar;
	static int[] dr = new int[] {0,0,1,-1};
	static int[] dc = new int[] {1,-1,0,0};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		int len = Integer.parseInt(input[0]);
		int num = Integer.parseInt(input[1]);
		int temp = num;

		ar = new int[20002001];

		Queue<Position> q = new LinkedList<>();

		for(int i=0 ; i<temp ; i++) {
			input = br.readLine().split(" ");
			int row = Integer.parseInt(input[0]);
			int col = Integer.parseInt(input[1]);
			int index = cal_index(row, col);

			ar[index] = index;

			q.add(new Position(row, col, index));

			for(int t=0 ; t<4 ; t++){
				int newR = row + dr[t];
				int newC = col + dc[t];
				int newI = cal_index(newR, newC);
				if(newR>len || newR<0 || newC>len || newC<0) continue;

				if(find(newI)!=0){
					if(union(index, newI)){
						num--;
					}
				}
			}
		}

		if(num==1) {
			System.out.println(0);
			return;
		}

		loop: for(int year=1 ; ; year++){
			int n = q.size();
			for(int i=0 ; i<n ; i++){
				Position now = q.poll();
				//				System.out.println(now.row+" "+now.col+" "+now.from+" "+year);
				for(int t=0 ; t<4 ; t++){
					int newR = now.row + dr[t];
					int newC = now.col + dc[t];
					int newI = cal_index(newR, newC);
					if(newR>len || newR<=0 || newC>len || newC<=0) continue;
					if(find(newI)!=0){
						if(union(newI, cal_index(now.row, now.col))) {							
							num--;
							if(num==1) {
								bw.write(String.valueOf(year));
								break loop;
							}
						}
					}
					else{
						ar[newI] = now.from;
						q.add(new Position(newR, newC, now.from));

						for(int tt=0 ; tt<4 ; tt++){
							int newR_ = newR + dr[tt];
							int newC_ = newC + dc[tt];
							int newI_ = cal_index(newR_, newC_);
							if(newR_>len || newR_<=0 || newC_>len || newC_<=0) continue;
							if(find(newI_)!=0){
								if(union(newI_, newI)){
									num--;
									if(num==1) {
										bw.write(String.valueOf(year));
										break loop;
									}
								}
							}
						}
					}					
				}
			}
		}

		bw.flush();
	}

	private static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a==b) return false;
		ar[b] = a;
		return true;
	}

	private static int find(int a) {
		if(a==ar[a]) return a;
		return ar[a] = find(ar[a]);
	}

	static int cal_index(int row, int col){
		return row*10000 + col;
	}

	static class Position{
		int row, col, from;
		Position(int row, int col, int from){
			this.row = row;
			this.col = col;
			this.from = from;
		}
	}
}
