package Naver;

public class N2 {

	public int solution(String[] drum) {
		int answer = 0;

		char[][] table = new char[drum.length][drum.length];
		for(int i=0 ; i<drum.length ; i++) {
			table[i] = drum[i].toCharArray();
		}

		test:for(int i=0 ; i<drum.length ; i++) {
			int col = i;
			int row = 0;
			char now = table[row][col];
			boolean stop = false;
			
			while(true) {
				now = table[row][col];
//				System.out.println(row+" "+col+" "+now);
				switch(now) {
				case '#':
					if(row==drum.length-1) {
						answer++;
						continue test;
					}
					else row++;
					break;
				case '>':
					col++;
					break;
				case '<':
					col--;
					break;
				case '*':
					if(stop) {
//						System.err.println(4);
						continue test;
					}
					else if(row==drum.length-1) {
						answer++;
						continue test;
					}
					else {
						stop = true;
						row++;
					}
					break;
				}
			}
		}

		return answer;
	}

}
