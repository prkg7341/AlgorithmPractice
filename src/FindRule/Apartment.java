package FindRule;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Apartment {

	int plus(int layer, int index){
		if(layer==0){
			return index;
		}
		else{
			if(index==1){
				return 1;
			}
			else{
				return plus(layer-1, index)+plus(layer, index-1);
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		Apartment apart = new Apartment();

		int n = Integer.parseInt(br.readLine());
		int layer=0;
		int index=0;
		
		while(n--!=0){
			layer = Integer.parseInt(br.readLine());
			index = Integer.parseInt(br.readLine());
			sb.append(apart.plus(layer, index)+"\n");
		}
		
		sb.deleteCharAt(sb.length()-1);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}
