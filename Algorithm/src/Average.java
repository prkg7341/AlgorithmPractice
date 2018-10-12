import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Average {

	public static void main(String[] args) throws NumberFormatException, IOException, IndexOutOfBoundsException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i=0 ; i<n ; i++){
			String st = br.readLine();
			int m = Integer.parseInt(st.split(" ")[0]);
			int[] ar = new int[m];
			int sum = 0;
			int average = 0;
			int check = 0;
			
			for(int j=0 ; j<m ; j++){
				ar[j] = Integer.parseInt(st.split(" ")[j+1]);
				sum += ar[j];
			}
			average = sum/m;
			for(int j=0 ; j<m ; j++){
				if(ar[j]>average) check++;
			}
			float output = (float)100*check/m;
			//String temp = ""+output;
			//String print = temp.substring(0, 2) + "." + temp.substring(2) + "%";
			//System.out.println(print);
			System.out.printf("%.3f", output);
			System.out.println("%");
		}
		br.close();
	}
}
