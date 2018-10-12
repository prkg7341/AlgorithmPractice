import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PlusCycle {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		br.close();
		int np = n;
		int count=0;
		do{count++;
			if(n<10){
				n = 11*n;
			}
			else{
				n = (n/10+(n%10))%10 + 10*(n%10);
			}
			
		} while(np!=n);

		System.out.println(count);	
	}
}
