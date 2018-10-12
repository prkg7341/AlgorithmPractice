package DivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bilbo {

	int count;

	public Bilbo(String[] ar1, String[] ar2) {
		count=0;
		int i=0;
		int j=0;
		countNum(ar1, ar2, i, j);
		System.out.println(count);
	}

	private void countNum(String[] ar1, String[] ar2, int a, int b) {
		int i1=a;
		for(int i=0 ; i<ar1.length ; i++){
			for(int j=i ; j<ar1.length ; j++){

				if(ar1[j].compareTo(ar2[i])==0){
					if(i!=j){
						swap(ar1, a, i1);
						count++;
					}
				}
			}
		}
	}

	private void swap(String[] ar, int a, int b) {
		String temp = ar[a];
		ar[a] = ar[b];
		ar[b] = temp;		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=1;
		while(n!=0){
			n = Integer.parseInt(br.readLine().toString());
			String[] ar1 = new String[n];
			String[] ar2 = new String[n];
			String st1 = br.readLine();
			String st2 = br.readLine();
			for(int i=0 ; i<n ; i++){
				ar1[i] = st1.split(" ")[i];
			}
			for(int i=0 ; i<n ; i++){
				ar2[i] = st2.split(" ")[i];
			} //ÀÔ·Â ³¡

			new Bilbo(ar1, ar2);
		}		
	}
}
