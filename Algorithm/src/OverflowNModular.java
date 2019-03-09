import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OverflowNModular {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);

		input = br.readLine().split(" ");

		long result = 1;

		for(int i=0 ; i<n ; i++){
			result = (result*(Integer.parseInt(input[i]))%m)%m;
		}
		System.out.println(result);
	}
}
