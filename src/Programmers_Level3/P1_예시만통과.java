package Programmers_Level3;

public class P1_예시만통과 {

	static StringBuilder sb;
	static boolean[][] abs;
	static int[][] alphabet;
	static int bit = 0;

	public String solution(int m, int n, String[] board) {

		alphabet = new int[26][2];

		abs = new boolean[m][n];

		for(int i=0 ; i<board.length ; i++){
			char[] temp = board[i].toCharArray();

			for(int j=0 ; j<temp.length ; j++){

				char now = temp[j];

				if(now>='A' && now<='Z'){
					abs[i][j] = true;
					bit |= (1<<(int)(now-'A'));
					if(alphabet[(int)(now-'A')][0]==0){
						alphabet[(int)(now-'A')][0] = (i+1)*1000 + (j+1);
					}
					else{
						alphabet[(int)(now-'A')][1] = (i+1)*1000 + (j+1);
					}
				}
				else if(now=='*')
					abs[i][j] = true;
			}
		}

		sb = new StringBuilder();

		if(check(0))
			return sb.toString();
		else
			// TODO �����
			return "IMPOSSIBLE";
	}

	private boolean check(int index) {
		
//		System.out.println((char)('A'+index)+"�� ���� ����");

		if(index==alphabet.length) {
			if(bit==0) return true;
			else return false;
		}

		// �ش� ���ĺ��� ������
		if(alphabet[index][0] + alphabet[index][1] != 0){
			// ���� ���� �ȵǸ�
			if(!sum(index)){
				return check(index+1);
			}
			// �Ǹ� A���� �ٽ�
			else{
//				System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
				return check(0);
			}			
		}
		// ������ ���� ���ĺ����� �Ѿ
		else{
			return check(index+1);
		}
	}

	private boolean sum(int index) {

		boolean ret1 = true;
		boolean ret2 = true;

		int r1,r2,c1,c2;

		r1 = alphabet[index][0]/1000-1;
		c1 = alphabet[index][0]%1000-1;
		r2 = alphabet[index][1]/1000-1;
		c2 = alphabet[index][1]%1000-1;

		if(r1<r2){
//			System.out.print("��");
			for(int i=r1+1 ; ret1 && i<r2 ; i++){
				ret1 = !abs[i][c1];
			}
//			System.out.print(ret1);
			if(c1<c2){
//				System.out.println("��");
				for(int i=c1 ; ret1 && i<c2 ; i++){
					ret1 = !abs[r2][i];
				}
			}
			else if(c1>c2){
//				System.out.println("��");
				for(int i=c1 ; ret1 && i>c2 ; i--){
					ret1 = !abs[r2][i];
				}
			}
			else{
//				System.out.println("c�� ���Ƽ� ������ �ʿ� ����");
			}
		}
		else{
//			System.out.println("r�� ����");
			ret1 = false;
		}

		if(c1<c2){
			for(int i=c1+1 ; ret2 && i<c2 ; i++){
				ret2 = !abs[r2][i];
			}
//			System.out.print("��");
//			System.out.print(ret2);
			if(r1<r2){
//				System.out.println("��");
				for(int i=r1 ; ret2 && i<r2 ; i++){
					ret2 = !abs[i][c2];
				}
			}
			else{
//				System.out.println("r�� ���Ƽ� ������ �ʿ� ����");				
			}
		}
		else if(c1>c2){
			for(int i=c1-1 ; ret2 && i>c2 ; i--){
				ret2 = !abs[r2][i];
			}
//			System.out.print("��"); 
//			System.out.print(ret2);
			if(r1<r2){
//				System.out.println("��");
				for(int i=r1 ; ret2 && i<r2 ; i++){
					ret2 = !abs[i][c2];
				}
			}
			else{
//				System.out.println("r�� ���Ƽ� ������ �ʿ� ����");				
			}
		}
		else{
//			System.out.println("c�� ����");
			ret2 = false;
		}

		ret1 = ret1 || ret2;

//		System.out.print((char)('A'+index));
		if(ret1) {
//			System.out.println("���");
			abs[r1][c1] = false;
			abs[r2][c2] = false;
			alphabet[index] = new int[] {0,0};
			sb.append((char)('A'+index));
			bit &= ~(1<<(index));
		}
		else{
//			System.out.println("�������");
		}

		return ret1;
	}
}
