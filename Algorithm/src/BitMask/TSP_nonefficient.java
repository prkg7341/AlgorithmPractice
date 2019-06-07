package BitMask;

import java.io.IOException;
import java.util.Scanner;

public class TSP_nonefficient {

	static int n;
	static int min = Integer.MAX_VALUE;
	static int[][] ar;
	static int[][] dp;
	static int MAX_VAL = 100000000;

	public static void main(String[] args) throws IOException {	

		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();

		ar = new int[n][n];
		dp = new int[n][1<<n];

		for(int i=0 ; i<n ; i++){
			for(int j=0 ; j<n ; j++){
				int now = sc.nextInt();
				if(i!=j && now==0){
					ar[i][j] = MAX_VAL;
				}
				else
					ar[i][j] = now;
			}
		}

		sc.close();

		tsp(0,1,0);

		System.out.println(min);
	}

	private static void tsp(int now, int bit, int sum) {
		if(bit==(1<<n)-1){
			min = Math.min(min, sum+ar[now][0]);
		}

		else{
			for(int i=0 ; i<n ; i++){
				if(i!=now && (bit & 1<<i)==0){
					int added = ar[now][i];
					if(added >= MAX_VAL){
						continue;
					}
					int newbit = bit|1<<i;
					int newsum = sum+added;
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
