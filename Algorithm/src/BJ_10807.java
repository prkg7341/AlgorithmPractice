import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_10807 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		int[] ar = new int[n];
		
		for(int i=0 ; i<n ; i++) {
			ar[i] = Integer.parseInt(input[i]);
		}
		
		int num = Integer.parseInt(br.readLine());
		
		int result = 0;
		
		for(int i : ar) {
			if(i==num) result++;
		}
		
		bw.write(String.valueOf(result));
		
		bw.flush();
	}
}
