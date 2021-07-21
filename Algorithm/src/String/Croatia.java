package String;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Croatia {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String st = br.readLine();
		String[] star = st.split("");
		int digit=star.length;
		for(int i=2 ; i<star.length ; i++){
			st = star[i-2]+star[i-1]+star[i];
			switch(st){
			case "dz=":digit-=2; star[i-1]="A"; break;
			}
		}
		for(int i=1 ; i<star.length ; i++){
			st = star[i-1]+star[i];
			switch(st){
			case "c=": digit--; break;
			case "c-": digit--; break;
			case "d-":digit--; break;
			case "lj":digit--; break;
			case "nj":digit--; break;
			case "s=":digit--; break;
			case "z=": digit--; break;
			}
		}
		bw.write(digit+"");
		bw.flush();
		bw.close();
	}

}
