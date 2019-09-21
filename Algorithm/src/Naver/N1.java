package Naver;

public class N1 {

	public int solution(String[] emails) {
		int answer = 0;

		test: for(int t=0 ; t<emails.length ; t++) {

			String name, domain, top;

			String[] now = emails[t].split("@");

			if(now.length!=2) {
				continue;
			}
			name = now[0];

			// name 검증
			if(name.length()==0) continue test;
			for(char c : name.toCharArray()) {
				if((c>'z' || c<'a') && c!='.') {
					continue test;
				}
			}

			now = now[1].split("\\.");

			if(now.length!=2) {
				continue;
			}

			domain = now[0];
			top = now[1];

			// domain 검증
			if(domain.length()==0) continue test;
			for(char c : domain.toCharArray()) {
				if(c>'z' || c<'a') {
					continue test;
				}
			}

			// top 검증
			if(top.compareTo("com")!=0 && top.compareTo("net")!=0 && top.compareTo("org")!=0) {
				continue test;
			}
			answer++;
		}

		return answer;
	}	
}
