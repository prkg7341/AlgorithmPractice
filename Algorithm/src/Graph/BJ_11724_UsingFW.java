package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * ��������� ����� �� �÷��̵�-�ͼ� �˰����� ����ߴµ�,
 * �ٸ� ������� �ڵ带 ���� DFS ����� ����ϴ°� �ξ� ����. 
 */
public class BJ_11724_UsingFW {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);

		if(m==0){
			System.out.print(n);
			return;
		}

		boolean[][] hasRoute = new boolean[n][n];

		for(int i=0 ; i<m ; i++){
			input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);

			hasRoute[a-1][b-1] = true;
			hasRoute[b-1][a-1] = true;
		}

		for(int i=0 ; i<n ; i++){
			for(int j=0 ; j<n ; j++){
				for(int k=0 ; k<n ; k++){
					if(!hasRoute[j][k]){
						hasRoute[j][k] = hasRoute[j][i] && hasRoute[i][k]; 
					}
				}
			}
		}

		int min = Integer.MAX_VALUE;

		for(int k=0 ; k<n ; k++){

			int count=1;

			for(int i=0 ; i<n ; i++){
				if(!hasRoute[k][i]){
					count++;
					for(int j=0 ; j<n ; j++){
						if(hasRoute[i][j]){
							hasRoute[k][j] = true;
						}
					}
				}
			}

			min = Math.min(min, count);
		}

		System.out.print(min);
	}
}