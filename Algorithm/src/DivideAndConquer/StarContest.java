package DivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StarContest {

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().toString()); //참가자의 수
		int[] ar = new int[n]; //출력용
		String line = null;
		int count = n; //출력 index0
		for(int i=0 ; i<n ; i++){ //사람수만큼 반복
			line = br.readLine(); //n번째 사람에 대한 정보
			//int m = Integer.parseInt(line.split(" "));
			if(line.length()==1){ //이기는 관계가 없으면
				count--;
			}
			else{ //이기는 관계가 있으면
				ar[i] = Integer.parseInt(line.split(" ")[i]);
			}
		}
		//System.out.print(count);
	}

}
