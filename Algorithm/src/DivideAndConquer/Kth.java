package DivideAndConquer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Kth {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n,k;
		String temp = br.readLine();
		n = Integer.parseInt(temp.split(" ")[0]); // ���� ����
		k = Integer.parseInt(temp.split(" ")[1]); // k��° ����
		temp = br.readLine();

		// k�� n/2���� Ŭ��/������

		for(int i=0 ; i<n ; i++){
			
		}
		
		
		//bw.write();
		bw.flush();
		bw.close();
	}
}
