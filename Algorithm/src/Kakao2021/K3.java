package Kakao2021;

import java.util.ArrayList;

public class K3 {
	public int[] solution(String[] info, String[] query) {
		int[] answer = new int[query.length];

		ArrayList<Integer>[] ar = new ArrayList [24];

		for(int i=0 ; i<24 ; i++) {
			ar[i] = new ArrayList<Integer>();
		}

		for(int i=0 ; i<info.length ; i++) {
			String[] spl = info[i].split(" ");
			int lang;
			String lan = spl[0];
			if(lan.contains("java")) {
				lang = 0;
			}
			else if(lan.contains("cpp")) {
				lang = 1;
			}
			else{
				lang = 2;
			}
			int job = spl[1].contains("backend")? 0 : 1;
			int car = spl[2].contains("junior")? 0 : 1;
			int food = spl[3].contains("pizza")? 0: 1;
			int score = Integer.parseInt(spl[4]);

			int index = lang*8+job*4+car*2+food;

			if(ar[index].isEmpty()) ar[index].add(score);
			else {
				int temp = biSearch(score, 0, ar[index].size()-1, ar[index]);
				if(temp==-1) ar[index].add(score);
				else ar[index].add(temp, score);
			}
		}

		for(int i=0 ; i<query.length ; i++) {
			String[] spl = query[i].split(" and ");
			String lan = spl[0];
			String job = spl[1];
			String car = spl[2];
			String food = spl[3].split(" ")[0];
			String score = spl[3].split(" ")[1];
			String[] par = new String[] {lan, job, car, food, score};
			doit(par, 0, ar, 0, i, answer);
		}

		return answer;
	}

	private void doit(String[] par, int charAt, ArrayList<Integer>[] ar, int ar_index, int i, int[] answer) {
		if(charAt==par.length-1) {
			int count = biSearch(Integer.parseInt(par[charAt]), 0, ar[ar_index].size()-1, ar[ar_index])+1;
			answer[i] += count;
			return;
		}
		if(par[charAt].contains("-")) {
			if(charAt==0) {
				doit(par, charAt+1, ar, ar_index+(int)Math.pow(2, 3-charAt)*2, i, answer);
			}
			doit(par, charAt+1, ar, ar_index+(int)Math.pow(2, 3-charAt)*0, i, answer);
			doit(par, charAt+1, ar, ar_index+(int)Math.pow(2, 3-charAt)*1, i, answer);
		}
		else {
			int temp = 0;
			if(par[charAt].contains("cpp") || par[charAt].contains("frontend") || par[charAt].contains("senior") || par[charAt].contains("chicken")) temp = 1;
			else if(par[charAt].contains("python")) temp = 2;
			doit(par, charAt+1, ar, ar_index+(int)Math.pow(2, 3-charAt)*temp, i, answer);
		}
	}

	private static int biSearch(int now, int start, int end, ArrayList<Integer> list) {
		int index = (start+end)/2;

		if (start > end) return end;

		if(list.get(index)==now){
			while(index<list.size()-1 && list.get(index+1)==list.get(index)) index++;
			return index;
		}
		else if(list.get(index)>now){
			return biSearch(now,start, index-1, list);
		}
		else{
			return biSearch(now,index+1, end, list);
		}
	}
}
