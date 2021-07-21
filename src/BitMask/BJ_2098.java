package BitMask;

import java.io.IOException;
import java.util.Scanner;

public class BJ_2098 {

	static int n;
	static int min = Integer.MAX_VALUE;
	static int[][] ar; // �Է°� ����
	static int[][] dp; // �� ��Ȳ��(a ������ ���������� �湮�߰�, b �����鿡 �湮�� ��Ȳ�϶�) �ּҰ� ����
	final static int IMPOSSIBLE = 100000000; // �����

	public static void main(String[] args) throws IOException {	

		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();

		ar = new int[n][n];
		dp = new int[n][1<<n];

		// �Էº�
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
		// �ĺ��� �� �ּҰ� ����
		if(visited==(1<<n)-1){
			min = Math.min(min, sum+ar[now][0]);
		}

		else{
			for(int i=0 ; i<n ; i++){
				// ���� ������ �ƴϰ�, ���� �湮���� ���� ������ ��
				if(i!=now && (visited & 1<<i)==0){
					int added = ar[now][i]; // �Ÿ�
					// ���������� ����
					if(added >= IMPOSSIBLE){
						continue;
					}
					// �湮 ���� ������Ʈ
					int newbit = visited|1<<i;
					// �Ÿ� �հ�
					int newsum = sum+added;
					// ���� ��ȹ�� ���� �κ� (������ ���� ���� ���� ������ �湮������ dp�迭�� �ּڰ� ����)
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
