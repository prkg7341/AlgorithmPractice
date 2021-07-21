import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Zero {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int k = Integer.parseInt(br.readLine());

		int sum=0;
		LinkedList<Integer> list = new LinkedList<>(); 

		for(int i=0 ; i<k ; i++){
			int now = Integer.parseInt(br.readLine());
			if(now==0){
				sum -= list.removeLast();
			}
			else{
				sum += now;
				list.add(now);
			}
		}
		
		System.out.println(sum);
	}
}
