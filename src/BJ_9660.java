import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_9660 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long n = Long.parseLong(br.readLine());
		n %= 7;

		if (n == 2 || n == 0)
			System.out.println("CY");
		else
			System.out.println("SK");
	}
}