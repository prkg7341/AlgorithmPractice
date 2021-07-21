package Kakao2020;

public class K1 {
	public int solution(String s) {
		int answer = s.length();

		int max_len = s.length()/2;

		int sub_max = 0;

		for(int i=max_len ; i>0 ; i--) {
			sub_max =  test(i,s);
			answer = Math.min(s.length()-sub_max, answer);
//			System.out.println(s.length()-sub_max);
		}

		return answer;
	}

	private int test(int len, String st) {

		if(2*len>st.length()) {
			return 0;
		}

		int ret = 0;

		for(int i=0 ; ; i+=len) {
			String stan = "";
			String next = "";
			try{
				stan = st.substring(i, i+len);
				next = st.substring(i+len, i+len+len);
			}catch(StringIndexOutOfBoundsException e) {
				break;
			}
		

//			System.out.println(stan+" "+next);

			if(next.compareTo(stan)==0) {
				while(next.compareTo(stan)==0) {
//					System.out.println("same!!!!!!!!!!!!!!!!");
					ret += len;
					try{
						st = st.substring(0, i+len)+st.substring(i+len+len);
						next = st.substring(i+len, i+len+len);
//						System.out.println(st);
					}catch(StringIndexOutOfBoundsException e) {
						break;
					}
				}
				ret--;
			}
		}

		return ret;
	}
}
