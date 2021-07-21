package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CCW {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int x1,x2,x3,y1,y2,y3;

		String[] input = br.readLine().split(" ");

		x1 = Integer.parseInt(input[0]);
		y1 = Integer.parseInt(input[1]);

		input = br.readLine().split(" ");

		x2 = Integer.parseInt(input[0]);
		y2 = Integer.parseInt(input[1]);

		input = br.readLine().split(" ");

		x3 = Integer.parseInt(input[0]);
		y3 = Integer.parseInt(input[1]);

		int temp = x1*y2+x2*y3+x3*y1;

		temp -= y1*x2+y2*x3+y3*x1;

		int result;

		if(temp>0){
			result = 1;
		}
		else if(temp==0){
			result = 0;
		}
		else{
			result = -1;
		}

		System.out.print(result);
	}
}
