import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BigIntegerAPlustB {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		
		BigInteger bigx, bigy;

		bigx = new BigInteger(input[0]);
		bigy = new BigInteger(input[1]);
				
		System.out.println(bigx.add(bigy));
	}
}
