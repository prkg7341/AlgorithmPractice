package KakaoCommerce_2021;

public class KC2021_2 {

	public static void main(String[] args) {
		KC2021_2 k = new KC2021_2();
		System.out.println(k.solution(new int[][] {{1,0,0}, {1,1,0},{1,1,0},{1,0,1},{1,1,0},{0,1,1}}, 2));
	}

	static int answer = 0;

	public int solution(int[][] needs, int r) {        
		int[] count = new int[needs.length];

		for(int i=0 ; i<needs.length ; i++) {
			for(int j=0 ; j<needs[i].length ; j++) {
				if(needs[i][j]==1) count[i]++;
			}
		}

		btrk(needs, count, r, 0);

		return answer;
	}

	private void btrk(int[][] needs, int[] count, int r, int index) {

		if(index<needs[0].length-1) btrk(needs, count, r, index+1);		

		for(int i=0 ; i<count.length ; i++) {
			if(needs[i][index]==1) count[i]--;
		}

		if(r==1) {
			int temp = 0;
			for(int i=0 ; i<count.length ; i++) {
				if(count[i]==0) {
					temp++;
				}
			}
			answer = Math.max(answer, temp);
		}

		if(index<needs[0].length-1 && r>1) btrk(needs, count, r-1, index+1);

		for(int i=0 ; i<count.length ; i++) {
			if(needs[i][index]==1) count[i]++;
		}
	}
}
