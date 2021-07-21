package KakaoEnterprise;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class KE4 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int num = Integer.parseInt(input[0]);
		int n = Integer.parseInt(input[1]);

		int[][] ar = new int[(int)Math.pow(2, num)][(int)Math.pow(2, num)];

		for(int i=0 ; i<ar.length ; i++){
			for(int j=0 ; j<ar.length ; j++){
				if(i!=j) ar[i][j] = 123456789;
			}
		}

		for(int i=0 ; i<n ; i++){
			input = br.readLine().split(" ");
			int start = 0;
			int end = 0;

			for(int j=0 ; j<input[0].length() ; j++) {
				char now = input[0].charAt(j);
				if(now=='o') start |= (1<<(j));
				now = input[1].charAt(j);
				if(now=='o') end |= (1<<(j));
			}

			int cost = Integer.parseInt(input[2]);

			ar[start][end] = Math.min(ar[start][end], cost);
		}

		for(int k=0 ; k<ar.length ; k++){
			for(int i=0 ; i<ar.length ; i++){
				for(int j=0 ; j<ar.length ; j++){
					if(i==j) continue;
					if(ar[i][j]>ar[i][k]+ar[k][j]){
						ar[i][j] = ar[i][k]+ar[k][j];
					}
				}
			}
		}

		n = Integer.parseInt(br.readLine());

		for(int i=0 ; i<n ; i++) {
			input = br.readLine().split(" ");
			int start = 0;
			int end = 0;

			for(int j=0 ; j<input[0].length() ; j++) {
				char now = input[0].charAt(j);			
				if(now=='o') start |= (1<<(j));
				now = input[1].charAt(j);
				if(now=='o') end |= (1<<(j));
			}

			int ans = ar[start][end];
			if(ans==123456789) ans = -1;
			System.out.println(ans);
		}
	}
}