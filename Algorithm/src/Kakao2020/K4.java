package Kakao2020;

public class K4 {
	public int[] solution(String[] words, String[] queries) {
		int[] answer = new int[queries.length];

		for(int i=0 ; i<queries.length ; i++) {
			String now = queries[i];

			int count = 0;

			for(int k=0 ; k<words.length ; k++) {
				String comp = words[k];
				if(!same(now, comp)) continue;
				count++;
//				System.out.println("count");
			}

			answer[i] = count;
		}

		return answer;
	}

	private boolean same(String now, String comp) {
		if(now.length()!=comp.length()) return false;
		for(int i=0 ; i<now.length() ; i++) {
			if(now.charAt(i)!='?') {
				if(now.charAt(i)!=comp.charAt(i)) return false;
			}
		}
//		System.out.println(now+" "+comp);
		return true;
	}
}
