package Kakao2020_intern;

public class K1 {
	public String solution(int[] numbers, String hand) {
		boolean isRight;
		if(hand.contains("right")) isRight = true;
		else isRight = false;

		int right = 12;
		int left = 10;

		StringBuilder answer = new StringBuilder();

		for(int i=0 ; i<numbers.length ; i++) {
			int now = numbers[i];

			if(now==1 || now==4 || now==7) {
				left = now;
				answer.append("L");
			}
			else if(now==3 || now==6 || now==9) {
				right = now;
				answer.append("R");        		
			}
			else {
				if(now==0) now = 11;

				int tempL = Math.abs(left-now);
				tempL = tempL/3 + tempL%3;

				int tempR = Math.abs(right-now);
				tempR = tempR/3 + tempR%3;

				if(tempL<tempR) {
					left = now;
					answer.append("L");
				}
				else if(tempL>tempR) {
					right = now;
					answer.append("R"); 
				}
				else {
					if(isRight) {
						right = now;
						answer.append("R"); 
					}
					else {
						left = now;
						answer.append("L");
					}
				}
			}
		}

		return answer.toString();
	}
}
