package Kakao2020;

import java.util.PriorityQueue;

public class K5 {
	public int[][] solution(int n, int[][] build_frame) {        
		int[][] wall = new int[n+1][n+1]; // 1:���(y++)/2:��(x++)/3:�Ѵ�

		for(int[] task : build_frame) {
			int x = task[0];
			int y = task[1];
			int a = task[2]; // 0:���(y++)/1:��(x++)
			int b = task[3]; // 0:����/1:��ġ

			try {if(b==1) {
				if(a==0) {
					if(y==0 || (wall[x-1][y]>=2 && wall[x][y]==0) || (wall[x-1][y]==0 && wall[x][y]==2) || wall[x][y-1]%2==1) {
						wall[x][y] += 1;
					}
				}
				else {
					if(wall[x][y-1]%2==1 || wall[x+1][y-1]%2==1 || (wall[x-1][y]>=2&&wall[x+1][y]>=2)){
						wall[x][y] += 2;
					}
				}
			}
			else {
				if(a==0) {
					// ���� ���, ������ ��, �������� ��
					if(wall[x][y+1]%2==0 || (wall[x-1][y+1]>=2 && wall[x][y+1]>=2) || (wall[x-1][y+1]==0 && wall[x][y+1]==0) || (wall[x-1][y+1]>=2 && wall[x-1][y]%2==1) || (wall[x+1][y+1]>=2 && wall[x+1][y]%2==1)) {
						wall[x][y] -= 1;
					}
				}
				else {
					// ���� ��, ������ ��, �����ʿ� ���, �������� ���
					if(wall[x-1][y]>=2 && wall[x-1][y-1]%2==0) continue;
					if(wall[x+1][y]>=2 && wall[x+1][y-1]%2==0) continue;
					if(wall[x][y]%2==1 && (wall[x][y-1]%2==0 && wall[x-1][y]>2)) continue;
					if(wall[x+1][y]%2==1 && (wall[x+1][y-1]%2==0 && wall[x][y]>2)) continue;						
					wall[x][y] -= 2;
				}
			}
			}catch(Exception e) {

			}
		}

		PriorityQueue<Temp> pq = new PriorityQueue<>();

		for(int i=0 ; i<n+1 ; i++) {
			for(int j=0 ; j<n+1 ; j++) {
				if(wall[j][i]==1) pq.add(new Temp(j,i,1));
				if(wall[j][i]==2) pq.add(new Temp(j,i,2));
				if(wall[j][i]==3) {
					pq.add(new Temp(j,i,1));
					pq.add(new Temp(j,i,2));
				}
			}
		}

		int[][] answer = new int[pq.size()][3];

		for(int i=0 ; i<answer.length ; i++) {
			Temp now = pq.poll();
			answer[i] = new int[] {now.x,now.y,now.value-1};
		}

		return answer;
	}

	static class Temp implements Comparable<Temp>{

		int x;
		int y;
		int value;

		public Temp(int x, int y, int value) {
			this.x = x;
			this.y = y;
			this.value = value;
		}

		@Override
		public int compareTo(Temp o) {
			if(this.x>o.x) {
				return 1;
			}
			else if(this.x<o.x) {
				return -1;
			}
			else {
				if(this.y>o.y) {
					return 1;
				}
				else if(this.y<o.y) {
					return -1;
				}
				else return this.value-o.value;
			}
		}
	}
}
