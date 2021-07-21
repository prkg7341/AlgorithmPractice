package NHNgodo;

public class NG4 {
	public String solution(String cardNumber){
		
		// �� �ڸ��� ���ڸ� �迭�� �����մϴ�.
		int[] ar = new int[cardNumber.length()];
		
		for(int i=0 ; i<ar.length ; i++) {
			ar[i] = (int) (cardNumber.charAt(i)-'0');
			if(i%2==ar.length%2) ar[i]*=2;
		}
		
		// ����� �迭�� ���ڵ��� 1�� �ڸ��� 10�� �ڸ� ���� ���� ���մϴ�.
		int num = 0;
		
		for(int i : ar) {
			num += i/10;
			num += i%10;
			num %= 10;
		}
		
		String ret = "";
		
		if(num==0) {
			ret = "VALID";
		}
		else {
			ret = "INVALID";
		}
		
        return ret;
    }
}
