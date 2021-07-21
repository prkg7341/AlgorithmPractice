package NHNgodo_prac;

public class NG2 {
	public int knapsack(int[] w, int[] v, int k){
		
		// 냅색 알고리즘을 활용하기 위한 배열을 만듭니다.
		int[][] ar = new int[w.length+1][k+1];
		
		// 냅색 배열을 채웁니다.
		for(int i=1 ; i<ar.length ; i++) {
			for(int j=1 ; j<k+1 ; j++) {
				// i번째 물건을 담을 수 있는 무게일때
				if(j>=w[i-1]) {
					// i번째 물건을 담았을때의 가치와 담지 않았을때의 가치를 비교하여 최대값을 저장합니다.
					ar[i][j] = Math.max(ar[i-1][j], ar[i-1][j-w[i-1]]+v[i-1]);
				}
				// i번째 물건을 담을 수 없는 무게일때
				else {
					// 이전에 저장된 최대값을 그대로 가져옵니다.
					ar[i][j] = ar[i-1][j];
				}
			}
		}
		
		// 최대값을 리턴합니다.
        return ar[ar.length-1][ar[0].length-1];
    }
}
