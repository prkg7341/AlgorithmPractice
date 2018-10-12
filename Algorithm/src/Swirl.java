import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Swirl {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int r1, c1, r2, c2;
		int rc1=0, rc2=0;
		
		String st = br.readLine();
		r1 = Integer.parseInt(st.split(" ")[0]);
		c1 = Integer.parseInt(st.split(" ")[1]);
		r2 = Integer.parseInt(st.split(" ")[2]);
		c2 = Integer.parseInt(st.split(" ")[3]);
		
		// <= 0 : 礎熱寡熱 嬴棲賊 �汝鶾頛�
		if(r1==c1){
			rc1 = (int) (4*Math.pow(c1, 2)+1);
		}
		else if(r1>c1){
			rc1 = (int) (4*Math.pow(c1, 2)+1)+(r1-c1); 
		}
		System.out.println(rc1);
		
	}

}
