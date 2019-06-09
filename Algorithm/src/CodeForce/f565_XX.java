package CodeForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class f565_XX {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		long sum = 0;
		
		int cards = 0;

		for(int tt=1 ; tt<=t ; tt++){
			int n = Integer.parseInt(br.readLine());

			PriorityQueue<Integer> pq1 = new PriorityQueue<>();
			PriorityQueue<Integer> pq2 = new PriorityQueue<>();
			PriorityQueue<Integer> pq3 = new PriorityQueue<>();

			for(int i=0 ; i<n ; i++){
				String[] input = br.readLine().split(" ");
				int cost = Integer.parseInt(input[0]);
				int damage = Integer.parseInt(input[1]);
				
				if(cost==1){
					pq1.add(damage);
				}
				else if(cost==2){
					pq2.add(damage);
				}
				else{
					pq3.add(damage);
				}
			}

			long submax = 0;
			if(!pq3.isEmpty()){
				submax=pq3.poll();
				cards++;
				if(cards%10==0){
					submax*=2;
				}
			}
			int temp=0;
			if(!pq2.isEmpty()){
				cards++;
				int now = pq2.poll();
				if(cards%10==0){
					now*=2;
				}
				if(!pq1.isEmpty()){
					temp = pq1.poll();
					cards++;
					if(cards%10==0){
						temp*=2;
					}
					submax = Math.max(submax, now+temp);
				}
				else{
					submax = Math.max(submax, now);
				}			
			}
			if(temp==0 && !pq1.isEmpty()){
				// TODO cards
				temp += pq1.poll();
			}
			if(!pq1.isEmpty()){
				temp += pq1.poll();
			}
			if(!pq1.isEmpty()){
				temp += pq1.poll();
			}
			submax = Math.max(submax, temp);

			sum += submax;
			System.out.println(sum);
		}
		System.out.println(sum);
	}
}
