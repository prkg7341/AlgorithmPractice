package Kakao2021;

public class K4 {
	public int solution(int n, int s, int a, int b, int[][] fares) {
		int answer = 223456789;

		int[][] ar = new int[n][n];

		for(int i=0 ; i<n ; i++){
			for(int j=0 ; j<n ; j++){
				if(i==j) continue;
				ar[i][j] = 123456789;
			}
		}

		for(int i=0 ; i<fares.length ; i++){
			int start = fares[i][0];
			int end = fares[i][1];
			int cost = fares[i][2];

			ar[start-1][end-1] = Math.min(ar[start-1][end-1], cost);
			ar[end-1][start-1] = Math.min(ar[start-1][end-1], cost);
		}

		for(int k=0 ; k<n ; k++){
			for(int i=0 ; i<n ; i++){
				for(int j=0 ; j<n ; j++){
					if(i==j) continue;
					if(ar[i][j]>ar[i][k]+ar[k][j]){
						ar[i][j] = ar[i][k]+ar[k][j];
					}
					if(ar[j][i]>ar[k][i]+ar[j][k]){
						ar[j][i] = ar[k][i]+ar[j][k];
					}
				}
			}
		}

		for(int i=0 ; i<n ; i++) {
			answer = Math.min(answer, ar[s-1][i]+ar[i][a-1]+ar[i][b-1]);
		}

		return answer;
	}
}
