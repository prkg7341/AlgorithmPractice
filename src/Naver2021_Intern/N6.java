package Naver2021_Intern;

import java.util.HashMap;

public class N6 {
	public String[] solution(String[] companies, String[] applicants) {
		String[] answer = {};

		Com[] coms = new Com[companies.length];    
		HashMap<String, App> apps = new HashMap<>();

		for(int i=0 ; i<companies.length ; i++) {
			String[] temp = companies[i].split(" ");
			String com = temp[0]; //대문자
			String app = temp[1]; //소문자 쭉
			int num = Integer.parseInt(temp[2]); //뽑는 숫자

			coms[i] = new Com(com, new StringBuilder(app), num);
		}

		for(int i=0 ; i<applicants.length ; i++) {
			String[] temp = applicants[i].split(" ");
			String app = temp[0]; //소문자
			String com = temp[1]; //대문자 쭉
			int num = Integer.parseInt(temp[2]); //기업숫자       

			apps.put(app, new App(new StringBuilder(com), num));
		}

		while(!apps.isEmpty()) {
			HashMap<String, StringBuilder> match = new HashMap<>();

			for(Com c : coms) {
				match.put(c.name, (StringBuilder) c.sb.subSequence(0, Math.min(c.sb.length(), c.num)));
				c.sb.delete(0, Math.min(c.sb.length(), c.num));
			}

			for(String ap : apps.keySet()) {
				apps.get(ap).chance--;
				  
			}
		}

		return answer;
	}

	static class App{
		StringBuilder sb;
		int chance;
		App(StringBuilder sb, int chance){
			this.sb = sb;
			this.chance = chance;
		}		
	}

	static class Com{
		String name;
		StringBuilder sb;
		int num;
		Com(String name, StringBuilder sb, int num){
			this.name = name;
			this.sb = sb;
			this.num = num;
		}
	}
}
