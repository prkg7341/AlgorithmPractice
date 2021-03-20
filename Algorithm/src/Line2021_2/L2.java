package Line2021_2;

import java.util.HashMap;
import java.util.HashSet;

public class L2 {
	public boolean[] solution(String program, String[] flag_rules, String[] commands) {
		// ������ boolean �迭
		boolean[] answer = new boolean[commands.length];

		// flag rule�� �����ϱ� ���� �ؽ���
		HashMap<String, String> rule = new HashMap<>();

		// �迭�� �־���  flag rule���� �� �ؽ��ʿ� ����
		for(int i=0 ; i<flag_rules.length ; i++) {
			String[] input = flag_rules[i].split(" ");
			rule.put(input[0], input[1]);
		}

		// �� Ŀ�ǵ带 �����Ͽ� ó��
		for(int i=0 ; i<commands.length ; i++) {

			// ���ϰ��� �� boolean ������ true�� �ʱ�ȭ�Ͽ� ����
			boolean ret = true;

			// �� Ŀ�ǵ带 ������ �������� ��� ����
			String[] input = commands[i].split(" ");

			// ���α׷��̸��� �ٸ��� üũ
			String pro = input[0];
			if(!pro.equals(program)) {
				answer[i] = false;System.out.println("���α׷� �̸��� �ٸ��ϴ�!");
				continue;
			}			

			// �� flag�� ������ �������� üũ�ϱ� ���� �ؽ���
			HashSet<String> set = new HashSet<>();
			for(String key : rule.keySet()) set.add(key);
			
			// ���� �������� ���� Ŀ�ǵ带 �����ϸ鼭 ������ �ִ��� Ȯ���ϴ� �ݺ���
			loop: for(int j=1 ; j<input.length ; j++) {
				String flag_rule = input[j];	
				System.out.println("flag_rule: "+flag_rule);
				
				// �ش� flag�� rule�� �ִ��� Ȯ��
				if(rule.containsKey(flag_rule)) {
					if(rule.get(flag_rule).equals("STRING")) {
						// flag_argument_type ������ ������ ���� ���
						if(j==input.length-1) {
							ret = false;System.out.println("STRING ������ �����ϴ�!");
							break;
						}
						// STRING�� ������ ������ �޴��� Ȯ��
						String next = input[j+1];
						for(int k=0 ; k<next.length() ; k++) {
							if(!((next.charAt(k)>='A' && next.charAt(k)<='Z') || (next.charAt(k)>='a' && next.charAt(k)<='z'))) {
								ret = false;System.out.println(next+" �� ������ STRING ������ �ƴմϴ�!");
								break loop;
							}
						}
						j++;
					}
					else if(rule.get(flag_rule).equals("NUMBER")) {
						// NUMBER�� ������ ������ �޴��� Ȯ��
						try{
							Integer.parseInt(input[j+1]);
						}catch(Exception e) {
							ret = false;System.out.println(input[j+1]+" �� ������ NUMBER ������ �ƴմϴ�!");
							break;
						}
						j++;
					}
					else if(rule.get(flag_rule).equals("NUMBERS")) {
						// NUMBER�� ������ ������ �޴��� Ȯ��
						try{
							Integer.parseInt(input[j+1]);
						}catch(Exception e) {
							ret = false;System.out.println(input[j+1]+" �� ������ NUMBER ������ �ƴմϴ�!");
							break loop;
						}
						j++;

						// 0�� �̻��� NUMBER ������ �ޱ� ���� �ݺ���
						while(true) {
							try{
								Integer.parseInt(input[j+1]);
							}catch(Exception e) {
								break;
							}
							j++;
						}

					}
					else if(rule.get(flag_rule).equals("STRINGS")) {
						if(j==input.length-1) {
							ret = false;System.out.println("STRING ������ �����ϴ�!");
							break;
						}
						// STRING�� ������ ������ �޴��� Ȯ��
						String next = input[j+1];
						for(int k=0 ; k<next.length() ; k++) {
							if(!((next.charAt(k)>='A' && next.charAt(k)<='Z') || (next.charAt(k)>='a' && next.charAt(k)<='z'))) {
								ret = false;System.out.println(next+" �� ������ STRING ������ �ƴմϴ�!");
								break loop;
							}
						}
						j++;
						
						// 0�� �̻��� STRING ������ �ޱ� ���� �ݺ���
						while(true) {
							if(j==input.length-1) {
								break;
							}
							next = input[j+1];
							for(int k=0 ; k<next.length() ; k++) {
								if(!((next.charAt(k)>='A' && next.charAt(k)<='Z') || (next.charAt(k)>='a' && next.charAt(k)<='z'))) {									
									break;
								}
							}
							j++;
						}
					}
					// �������� �ƴϰų� ������ flag�� ������ ������ flag argument�� ���� �ʴ� flag�� ������ ���� ���
					else {
						if(j!=input.length-1 && input[j+1].charAt(0)!='-') {
							ret = false;System.out.println("flag argument�� ���� �� ���� flag�Դϴ�!");
							break;
						}
					}

					// �� flag�� �ι��̻� ���̸� ���� ���
					if(!set.remove(flag_rule)) {
						ret = false;System.out.println("�� flag�� �ѹ��� command�� �ѹ��� ��� �����մϴ�!");
						break;
					}
				}
				// �ش� flag�� rule�� ������ ���� ���
				else {
					ret = false;ret = false;System.out.println("�ش� flag rule�� �����ϴ�");
					break;
				}
			}
			answer[i] = ret;
		}       

		return answer;
	}
}
