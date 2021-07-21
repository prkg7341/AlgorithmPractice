package LinePlus;

public class LP2 {

	public int solution(String answer_sheet, String[] sheets) {
		char[] answer = answer_sheet.toCharArray();

		int max = 0;

		for(int i=0 ; i<sheets.length ; i++) {
			for(int j=i+1 ; j<sheets.length ; j++) {
				char[] A = sheets[i].toCharArray();
				char[] B = sheets[j].toCharArray();

				int count = 0;
				int temp_max = 0;
				int temp = 0;

				for(int k=0 ; k<answer.length ; k++) {
					if(A[k]==B[k] && A[k]!=answer[k]) {
						temp++;
					}
					else {
						temp_max = Math.max(temp_max, temp);
						count += temp;
						temp = 0;
					}
				}
				if(temp!=0) {
					temp_max = Math.max(temp_max, temp);
					count += temp;
				}
				max = Math.max(max, count + temp_max*temp_max);
			}
		}

		return max;
	}
}
