package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1937{

	// 그래프 탐색을 위한 배열
	static int[] dr = {-1,0,0,1};
	static int[] dc = {0,-1,1,0};
	
	// 방문여부를 저장하고 판별하기 위한 배열
	static boolean[][] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		// 대나무 숲의 정보를 저장할 배열
		int[][] ar = new int[n][n];
		// DP를 적용한 dfs의 탐색결과를 저장할 배열
		int[][] dp = new int[n][n];
		// 방문배열 초기화
		visit = new boolean[n][n];

		// 마지막에 출력할 변수
		int max = 0;

		// 입력부
		for(int i=0 ; i<n ; i++) {
			String[] input = br.readLine().split(" ");
			for(int j=0 ; j<n ; j++) {
				ar[i][j] = Integer.parseInt(input[j]);
			}
		}

		// 배열을 탐색하면서 DP를 적용한 dfs 적용
		for(int i=0 ; i<n ; i++) {
			for(int j=0 ; j<n ; j++) {
				if(!visit[i][j]) { // 현재 위치를 방문한적이 없으면
					dp[i][j] = dfs(ar,dp,i,j); // dp 배열에 dfs 결과를 저장
					max = Math.max(max, dp[i][j]); // 출력할 변수 update
				}
			}
		}

		System.out.println(max);
	}

	private static int dfs(int[][] ar, int[][] dp, int r, int c) {

		visit[r][c] = true;

		// 4방향의 dfs 결과를 저장할 배열
		int[] m = new int[4];

		for(int i=0 ; i<4 ; i++) {
			int newR = r+dr[i];
			int newC = c+dc[i];

			// 배열에서 벗어나는 경우 예외처리
			if(newR<0 || newC<0 || newR==ar.length || newC==ar.length) continue;
			
			if(ar[newR][newC]>ar[r][c]) { // 판다가 다음칸으로 갈수 있으면
				if(visit[newR][newC]) {	// 인접칸에 방문한 적이 있으면 저장된 값을 가져옴		
					m[i] = dp[newR][newC];
				}			
				else  { // 인접칸에 방문한 적이 없으면 dfs 탐색 후 결과 저장
					m[i] = dfs(ar,dp,newR,newC);
				}
			}
		}

		// 최대값+1을 배열에 저장 후 리턴
		return dp[r][c] = 1+max(m);
	}

	// 배열중 최대값 return
	private static int max(int[] m) {
		int ret = 0;
		for(int i : m) ret = Math.max(ret, i);
		return ret;
	}
}