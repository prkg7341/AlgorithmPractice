package Kakao2021;

public class K1 {
	public String solution(String new_id) {
		
		new_id = new_id.toLowerCase();
		
		StringBuilder sb = new StringBuilder(new_id);
		
		/**
		 * 1�ܰ� new_id�� ��� �빮�ڸ� �����Ǵ� �ҹ��ڷ� ġȯ�մϴ�.
2�ܰ� new_id���� ���ĺ� �ҹ���, ����, ����(-), ����(_), ��ħǥ(.)�� ������ ��� ���ڸ� �����մϴ�.
3�ܰ� new_id���� ��ħǥ(.)�� 2�� �̻� ���ӵ� �κ��� �ϳ��� ��ħǥ(.)�� ġȯ�մϴ�.
4�ܰ� new_id���� ��ħǥ(.)�� ó���̳� ���� ��ġ�Ѵٸ� �����մϴ�.
5�ܰ� new_id�� �� ���ڿ��̶��, new_id�� "a"�� �����մϴ�.
6�ܰ� new_id�� ���̰� 16�� �̻��̸�, new_id�� ù 15���� ���ڸ� ������ ������ ���ڵ��� ��� �����մϴ�.
     ���� ���� �� ��ħǥ(.)�� new_id�� ���� ��ġ�Ѵٸ� ���� ��ġ�� ��ħǥ(.) ���ڸ� �����մϴ�.
7�ܰ� new_id�� ���̰� 2�� ���϶��, new_id�� ������ ���ڸ� new_id�� ���̰� 3�� �� ������ �ݺ��ؼ� ���� ���Դϴ�.
		 */
		
		for(int i=0 ; i<sb.length() ; i++) {
			char now = sb.charAt(i);
			if(now!='-' && now!='_' && now!='.' && !(now>='0' && now<='9') && !(now>='a' && now<='z')) {
				sb.deleteCharAt(i);
				i--;
			}
			else if(now=='.') {
				if(i==sb.length()-1 || i==0) {
					sb.deleteCharAt(i);
					i--;
				}
				else if(sb.charAt(i+1)=='.' || sb.charAt(i-1)=='.') {
					sb.deleteCharAt(i);
					i--;
				}
			}
		}

		while(sb.length()>0 && sb.charAt(0)=='.') sb.deleteCharAt(0);
		while(sb.length()>0 && sb.charAt(sb.length()-1)=='.') sb.deleteCharAt(sb.length()-1);

		if(sb.length()==0) sb.append('a');
		if(sb.length()>=16) {
			sb.delete(15, sb.length());
			if(sb.charAt(sb.length()-1)=='.') sb.deleteCharAt(sb.length()-1);
		}
		while(sb.length()<=2) {
			sb.append(sb.charAt(sb.length()-1));
		}
		
        return sb.toString();
    }
}
