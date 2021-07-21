package BitMask;

import java.io.IOException;
import java.util.Scanner;

public class BJ_2098 {

	static int n;
	static int min = Integer.MAX_VALUE;
	static int[][] ar; // 입력값 저장
	static int[][] dp; // 각 상황별(a 마을에 마지막으로 방문했고, b 마을들에 방문한 상황일때) 최소값 저장
	final static int IMPOSSIBLE = 100000000; // 길없음

	public static void main(String[] args) throws IOException {	

		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();

		ar = new int[n][n];
		dp = new int[n][1<<n];

		// 입력부
		for(int i=0 ; i<n ; i++){
			for(int j=0 ; j<n ; j++){
				int now = sc.nextInt();
				if(i!=j && now==0){
					ar[i][j] = IMPOSSIBLE;
				}
				else
					ar[i][j] = now;
			}
		}

		sc.close();

		tsp(0,1,0);

		System.out.println(min);
	}

	private static void tsp(int now, int visited, int sum) {
		// 후보값 중 최소값 저장
		if(visited==(1<<n)-1){
			min = Math.min(min, sum+ar[now][0]);
		}

		else{
			for(int i=0 ; i<n ; i++){
				// 지금 마을이 아니고, 아직 방문하지 않은 마을일 때
				if(i!=now && (visited & 1<<i)==0){
					int added = ar[now][i]; // 거리
					// 갈수없으면 제외
					if(added >= IMPOSSIBLE){
						continue;
					}
					// 방문 마을 업데이트
					int newbit = visited|1<<i;
					// 거리 합계
					int newsum = sum+added;
					// 동적 계획법 적용 부분 (마지막 마을 기준 같은 마을들 방문했을때 dp배열에 최솟값 저장)
					if(dp[i][newbit]!=0) {
						if(dp[i][newbit] > newsum){
							dp[i][newbit] = newsum;
							tsp(i,newbit,newsum);
						}
					}
					else{
						dp[i][newbit] = newsum;
						tsp(i,newbit,newsum);
					}
				}
			}
		}
	}
}
