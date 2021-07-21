package NHNgodo_prac;

public class NG2 {
	public int knapsack(int[] w, int[] v, int k){
		
		// ���� �˰����� Ȱ���ϱ� ���� �迭�� ����ϴ�.
		int[][] ar = new int[w.length+1][k+1];
		
		// ���� �迭�� ä��ϴ�.
		for(int i=1 ; i<ar.length ; i++) {
			for(int j=1 ; j<k+1 ; j++) {
				// i��° ������ ���� �� �ִ� �����϶�
				if(j>=w[i-1]) {
					// i��° ������ ��������� ��ġ�� ���� �ʾ������� ��ġ�� ���Ͽ� �ִ밪�� �����մϴ�.
					ar[i][j] = Math.max(ar[i-1][j], ar[i-1][j-w[i-1]]+v[i-1]);
				}
				// i��° ������ ���� �� ���� �����϶�
				else {
					// ������ ����� �ִ밪�� �״�� �����ɴϴ�.
					ar[i][j] = ar[i-1][j];
				}
			}
		}
		
		// �ִ밪�� �����մϴ�.
        return ar[ar.length-1][ar[0].length-1];
    }
}
