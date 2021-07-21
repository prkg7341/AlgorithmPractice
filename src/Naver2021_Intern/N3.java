package Naver2021_Intern;

public class N3 {
	public int[] solution(int n) {

		int count = 0;

		while(n>=10) {
			String num = String.valueOf(n);

			int index = num.length()/2;
			int temp = findindex(index, num, 0);

			int front = front(temp, num);
			int back = back(temp, num);

			n = front+back;	
			count++;
		}

		return new int[] {count, n};
	}

	private int findindex(int index, String st, int di) {
		if(index==-1 || index==st.length()) {
			return -1;
		}
		
		if(back(index, st)==-1) {
			if(di==0) {
				int a = findindex(index-1, st, -1);
				int b = findindex(index+1, st, 1);
				if(a<0) return b;
				if(b<0) return a;
				
				if(front(a,st)+back(a,st)>front(b,st)+back(b,st)) return b;
				else return a;
			}
			else if(di==1) {
				return findindex(index+1, st, 1);
			}
			else {
				return findindex(index-1, st, -1);
			}			
		}
		else {
			int b = findindex(index+1, st, 1);
			if(b<1) return index;
			if(index<1) return -1;
			if(front(index,st)+back(index,st)>front(b,st)+back(b,st)) return b;
			else return index;
		}
	}

	private int front(int index, String st) {
		return Integer.parseInt(st.substring(0, index));
	}

	private int back(int index, String st) {
		String temp = st.substring(index);
		if(temp.length()!=1 && temp.charAt(0)=='0') return -1;
		return Integer.parseInt(temp);
	}
}
