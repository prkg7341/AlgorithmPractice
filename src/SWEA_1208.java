import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class SWEA_1208 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int i=1 ; i<=10 ; i++) {

			int n = Integer.parseInt(br.readLine());

			PriorityQueue<Integer> pq = new PriorityQueue<>();
			PriorityQueue<Integer> pq_ = new PriorityQueue<>(Collections.reverseOrder());

			String[] input = br.readLine().split(" ");

			for(int j=0 ; j<100 ; j++) {
				int now = Integer.parseInt(input[j]);
				pq.add(now);
				pq_.add(now);
			}

			for(int j=0 ; j<n ; j++) {
				int a = pq.poll();
				int b = pq_.poll();

				if(a==b) {
					break;
				}

				pq.add(a+1);
				pq_.add(b-1);
			}
			System.out.print("#"+i+" ");
			System.out.println(pq_.poll()-pq.poll());
		}
	}	
}
