package KakaoEnterprise;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;

class KE2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		HashMap<String, Pair> map = new HashMap<>();

		for(int i=0 ; i<n*(n-1) ; i++) {
			String[] input = br.readLine().split(" ");

			String teamA = input[0];
			int scoreA = Integer.parseInt(input[1]);
			String teamB = input[2];
			int scoreB = Integer.parseInt(input[3]);

			Pair A = map.get(teamA);
			Pair B = map.get(teamB);
			int a, b, a_, b_;
			a_ = scoreA-scoreB; b_ = scoreB-scoreA;
			if(scoreA>scoreB) {
				a = 1; b = 0;
			}
			else {
				a = 0; b = 1;
			}

			if(A==null) {
				map.put(teamA, new Pair(a, a_));
			}
			else {
				map.replace(teamA, new Pair(A.win+a, A.dif+a_));
			}
			if(B==null) {
				map.put(teamB, new Pair(b, b_));
			}
			else {
				map.replace(teamB, new Pair(B.win+b, B.dif+b_));
			}
		}

		PriorityQueue<Team> pq = new PriorityQueue<>();

		for(String key : map.keySet()){
			Pair now = map.get(key);
			pq.add(new Team(key, now.win, now.dif));
		}

		while(!pq.isEmpty()) {
			Team now = pq.poll();
			System.out.println(now.name+" "+now.win+" "+now.dif);
		}
	}

	static class Team implements Comparable<Team>{
		String name;
		int win;
		int dif;
		Team(String name, int win, int dif){
			this.name = name;
			this.win = win;
			this.dif = dif;
		}
		@Override
		public int compareTo(Team o) {
			if(this.win>o.win) return -1;
			else if(this.win<o.win) return 1;
			else {
				if(this.dif>o.dif) return -1;
				else if(this.dif<o.dif) return 1;
				else{
					int ret = this.name.compareTo(o.name);
					return ret;
				}
			}
		}
	}

	static class Pair{
		int win;
		int dif;
		Pair(int win, int dif){
			this.win = win;
			this.dif = dif;
		}
	}
}