package Math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_13458 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		String[] input = br.readLine().split(" ");

		int[] rooms = new int[n];

		for(int i=0 ; i<n ; i++){
			rooms[i] = Integer.parseInt(input[i]);
		}

		input = br.readLine().split(" ");

		int main = Integer.parseInt(input[0]);
		int sub = Integer.parseInt(input[1]);

		long result = n;

		for(int i=0 ; i<n ; i++){
			int now = rooms[i]-main;
			if(now>0){
				result += (long)(now/sub);
				if(now%sub!=0) result++;
			}
		}

		bw.write(String.valueOf(result));

		bw.flush();
	}
}
