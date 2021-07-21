package String;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class StudyingWord {	

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String st = br.readLine().toUpperCase();

		if(st.length()==1){
			bw.write(st);
		}
		else{

			String[] star = st.split("");

			Arrays.sort(star);

			String[][] ar = new String [st.length()][2];
			for(int i=0 ; i<ar.length ; i++){
				ar[i][0] = star[i];
				ar[i][1] = 0+"";
			}

			for(int i=1 ; i<star.length ; i++){
				if(ar[i][0].compareTo(ar[i-1][0])==0){
					ar[i][1] = (Integer.parseInt(ar[i-1][1])+1)+"";
				}
			}

			int[] intar = new int[st.length()];
			for(int i=0 ; i<intar.length ; i++){
				intar[i] = Integer.parseInt(ar[i][1]);
			}

			Arrays.sort(intar);

			if(intar[intar.length-1]==intar[intar.length-2]){
				bw.write("?");
			}
			else{
				for(int i=0 ; i<intar.length ; i++){
					if(intar[intar.length-1]==Integer.parseInt(ar[i][1])){
						bw.write(ar[i][0]);
					}
				}
			}
		}
		bw.flush();
		bw.close();

	}

}
