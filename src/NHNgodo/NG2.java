package NHNgodo;

public class NG2 {
	public int solution(int page, int[] broken){

		// +�Ǵ� -�θ� ä���� �̵��Ҷ� ���� �̸� ���ϰ��� ����
		int ret = Math.abs(page-100);		

		// ���峭  ����Ű�� boolean���� �����ϴ� �迭 ���� �� �ʱ�ȭ
		boolean[] brk = new boolean[10];
		for(int i = 0; i < broken.length; i++) {
			brk[broken[i]] = true;
		}

		// page �ִ밪�� 2�踦 �����Ͽ� ���Ʈ���� �˰��� ���
		for(int i=0; i<=1000000; i++) {
			// �ݺ��� ������ ����� ä��
			int temp = i;
			// ä���̵��� ���� �������ϴ� Ƚ��
			int length = 0;
			// ä���� 0�϶� ����ó��
			if(i == 0){
				if(brk[0]) length = 0;
				else length = 1;
			} 
			// �ش� ä�η� �̵��� �� �ִ��� ���� �Ǻ�
			while (temp > 0) {
				if(brk[temp % 10]){
					length = 0;
					break;
				}
				length++;
				temp /= 10;
			}
			// �ش� ä�η� �̵��� �� �ִٸ� �ּڰ��� ���� ret�� ������Ʈ
			if (length > 0) {
				ret = Math.min(ret, length + Math.abs(i-page));
			}
		}
		return ret;
	}
}
