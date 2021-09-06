package Kakao2020_Practice;

public class K2 {
	public static void main(String[] args) {
		K2 k2 = new K2();
		k2.solution("(()())()");
	}
	public String solution(String p) {
		return rec(p);
	}

	private String rec(String p) {
		System.out.println(p);
		// 1
		if (p.length() == 0)
			return p;

		// 2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다.
		// 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다.

		int count = 0;
		boolean good = true;

		for (int i = 0; i < p.length(); i++) {
			if (p.charAt(i) == '(')
				count++;
			else
				count--;
			if (count == 0) {
				if (good)
					return p.substring(0, i + 1) + rec(p.substring(i + 1));
				else {
					StringBuilder sb = new StringBuilder("(");
					sb.append(rec(p.substring(i + 1))).append(")");
					for (int j = 1; j < i; j++) {
						if (p.charAt(j) == '(')
							sb.append(')');
						else
							sb.append('(');
					}
					return sb.toString();
				}
			}
			if (count < 0)
				good = false;
		}

		return null;
	}
}
