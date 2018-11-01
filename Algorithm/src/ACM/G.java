package ACM;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class G {

	public static void main(String[] args) throws NumberFormatException, IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n,k;
		
		String input = br.readLine();
		
		n = Integer.parseInt(input.split(" ")[0]);
		k = Integer.parseInt(input.split(" ")[1])-1; // 게이트 숫자-1 -> 부분 배열에서 역순(ar[n]>ar[n+1]이 나올 수 있는 횟수
		
		int[] ar = new int[n];
		
		input = br.readLine();
		
		for(int i=0 ; i<n ; i++){
			ar[i] = Integer.parseInt(input.split(" ")[i])-1; // 승객의 순서 번호를 index와 맞춰주기 위함
		}
		
		int max = -1;
		int count = 0;
		
		max = Math.max(max, ar[0]);
		
		for(int i=1 ; i<n ; i++){
			max = Math.max(max, ar[i]);
			if(ar[i]<ar[i-1]){ 
				count++;
				System.out.println("count is "+count);
			}
			if(max == i){ 
				if(count>k){
					bw.write("NO");
					break;
				}
				max = -1;
				count = 0;
				System.out.println("성공적인 부분배열 생성");
			}
			if(i==n-1){
				bw.write("YES");
			}
		}
		bw.flush();
		bw.close();
	}
}
