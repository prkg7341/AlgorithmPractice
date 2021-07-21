package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AfterParty {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		int num = Integer.parseInt(input[0])*Integer.parseInt(input[1]);
		input = br.readLine().split(" ");
		for(int i=0 ; i<5 ; i++){
			System.out.print(Integer.parseInt(input[i])-num+" ");
		}
	}
}
