package Baemin2021;

public class B1 {
	public int[] solution(int N) {
		int max = 0;
		int max_i = 0;

		for(int i=9 ; i>=2 ; i--) {
			int value = N;
			String returnString = "";
			int temp = 1;

			while(value != 0){
				// �������� 0~9 �����̸�  ĳ���� ���� �迭�� ����
				if( (value % i) < 10 ) {
					//���ڿ� ��->�·� �迭
					returnString = (value % i) + returnString;
					//���� ����
					value /= i;
				}
				// �������� 10 �̻��̸� �ش��ϴ� ���� ���ĺ��� ����
				else {
					int temp1 = (char)((value % i)  + 55);
					returnString = Integer.toString(temp1) + returnString;
				}
			}
			for(char c : returnString.toCharArray()) {
				if(c!='0') temp *= (int)(c-'0'); 
			}
			if(temp>max) {
				max = temp;
				max_i = i;
			}
		}

		return new int[] {max_i, max};
	}
}
