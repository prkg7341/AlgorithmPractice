import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tt = Integer.parseInt(br.readLine());


		sb.deleteCharAt(sb.length()-1);
		System.out.print(sb.toString());
	}
}