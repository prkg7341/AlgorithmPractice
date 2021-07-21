package NHNgodo_prac;

public class NG1 {
	public long solution(int n){
		
		// dp�� Ȱ���� �Ǻ���ġ ������ ���ϱ� ���� �迭�� ����ϴ�.
		long[] ar = new long[n+1];
		
		// n�� 0�϶��� ����ó���� ���ص�, ù��° ���� �Է��մϴ�.
		if(n>0) ar[1] = 1;
		
		// �Ǻ���ġ ������ ���մϴ�.
		for(int i=2 ; i<ar.length ; i++) {
			ar[i] = ar[i-1] + ar[i-2];
		}
		
		// ���� �����մϴ�.
        return ar[n];
    }
}
