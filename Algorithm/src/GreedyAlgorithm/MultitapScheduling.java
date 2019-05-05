package GreedyAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MultitapScheduling {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);

		int[] tab = new int[n];
		int[] ar = new int[k];

		input = br.readLine().split(" ");

		for(int i=0 ; i<k ; i++){
			ar[i] = Integer.parseInt(input[i]);
		}

		int last = -1;
		int count = 0;

		ent:
			for(int i=0 ; i<k ; i++){
				int now = ar[i];
				for(int j=0 ; j<=last ; j++){
					if(tab[j]==now) continue ent;
				}
				if(last<n-1 && tab[last+1]==0) tab[++last] = now;
				else{
					if(i==k-1){
						count++;
						break ent;
					}
					int maxI = -1;
					int toChange = -1;
					for(int j=0 ; j<n ; j++){
						int check = 0;
						for(int z=i+1 ; z<k ; z++){
							if(tab[j]==ar[z]) {
								check++;
								if(z>maxI){
									maxI = z;
									toChange = j;
								}
								break;
							}
						}
						if(check==0){
							maxI = 101;
							toChange = j;
							break;
						}
					}
					count++;
					tab[toChange] = now;
				}
			}
		System.out.print(count);
	}
}