package Implementation;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Yoot {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
	
		for(int i=0 ; i<3 ; i++){
			String st = br.readLine();
			switch(Integer.parseInt(st.split(" ")[0])+Integer.parseInt(st.split(" ")[1])+Integer.parseInt(st.split(" ")[2])+Integer.parseInt(st.split(" ")[3])){
			case 0: sb.append("D"+"\n"); break;
			case 1: sb.append("C"+"\n"); break;
			case 2: sb.append("B"+"\n"); break;
			case 3: sb.append("A"+"\n"); break;
			case 4: sb.append("E"+"\n"); break;
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}	
}
