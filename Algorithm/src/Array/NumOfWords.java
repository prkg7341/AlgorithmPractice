package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumOfWords {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String st = br.readLine();
		br.close();

		String[] ar = st.split(" ");
		
		if(ar.length==0) {
			System.out.println(0);
		}
		else if(ar[0].compareTo("")==0) {
			System.out.println(ar.length-1);
		}
		else {
			System.out.println(ar.length);
		}
	}
}