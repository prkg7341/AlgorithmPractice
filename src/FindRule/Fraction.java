package FindRule;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Fraction {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int x = Integer.parseInt(br.readLine());
		int layer;
		int a;

		int i=1;
		while(true){
			if(x<=i*(i+1)/2){
				layer=i; break;
			}
			i++;
		}
		
		if(layer%2==1){
			x -= layer*(layer-1)/2;
			a=layer+1-x;
			bw.write(a+"/"+(layer+1-a));
		}
		else{
			x -= layer*(layer-1)/2;
			a=layer+1-x;
			bw.write((layer+1-a)+"/"+a);
		}
		bw.flush();
		bw.close();		
	}

}
