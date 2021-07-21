package NHNgodo;

public class NG4 {
	public String solution(String cardNumber){
		
		// 각 자릿수 숫자를 배열로 저장합니다.
		int[] ar = new int[cardNumber.length()];
		
		for(int i=0 ; i<ar.length ; i++) {
			ar[i] = (int) (cardNumber.charAt(i)-'0');
			if(i%2==ar.length%2) ar[i]*=2;
		}
		
		// 저장된 배열의 숫자들을 1의 자리와 10의 자리 숫자 각각 더합니다.
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
