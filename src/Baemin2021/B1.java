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
				// 나머지가 0~9 사이이면  캐릭터 값을 배열에 저장
				if( (value % i) < 10 ) {
					//문자열 우->좌로 배열
					returnString = (value % i) + returnString;
					//몫을 구함
					value /= i;
				}
				// 나머지가 10 이상이면 해당하는 값의 알파벳을 저장
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
