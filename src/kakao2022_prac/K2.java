package kakao2022_prac;

public class K2 {
	public int solution(int n, int k) {

		int answer = 0;

		String temp_ = 0 + Integer.toString(n, k) + 0;
		char[] temp = temp_.toCharArray();

		StringBuilder num = new StringBuilder();

		for (int i = 1; i < temp.length; i++) {
			if (temp[i] == '0') {
				if (num.length()>0 && sosu(Long.parseLong(num.toString())))
					answer++;
				num = new StringBuilder();
			} else {
				num.append(temp[i]);
			}
		}

		return answer;
	}

	private boolean sosu(long num) {
		if(num<2) return false;
		for(int i=2 ; i<=Math.pow(num,0.5) ; i++){
			if(num%i==0) return false;
		}
        System.out.println(num);
		return true;
	}
}
