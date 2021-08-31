package Kakao2021_Practice;

public class K1 {
	public static void main(String[] args) {
		K1 k1 = new K1();
		k1.solution(null);
	}

	public String solution(String new_id) {
		// new_id = "...!@BaT#*..y.abcdefghijklm";
		// new_id = "z-+.^.";
		new_id = "ab.=.ba";
		// new_id = "123_.def";
		// new_id = "abcdefghijklmn.p";

		while (new_id.contains("..")) {
			new_id = new_id.replace("..", ".");
		}

		StringBuilder sb = new StringBuilder(new_id.toLowerCase());

		while (sb.length() > 0 && sb.charAt(0) == '.')
			sb.deleteCharAt(0);
		while (sb.length() > 0 && sb.charAt(sb.length() - 1) == '.')
			sb.deleteCharAt(sb.length() - 1);

		for (int i = 0; i < sb.length(); i++) {
			char now = sb.charAt(i);

			if(!"0123456789qweytuipoasdfhgjlkzxcmn-_.".contains(Character.toString(now))){
				sb.deleteCharAt(i--);
			}
		}

		while(sb.indexOf("..")>=0){
			sb.deleteCharAt(sb.indexOf(".."));
		}

		while (sb.length() > 0 && sb.charAt(0) == '.')
			sb.deleteCharAt(0);
		while (sb.length() > 0 && sb.charAt(sb.length() - 1) == '.')
			sb.deleteCharAt(sb.length() - 1);

		if (sb.length() >= 16)
			sb.delete(15, sb.length());

		while (sb.length() > 0 && sb.charAt(0) == '.')
			sb.deleteCharAt(0);
		while (sb.length() > 0 && sb.charAt(sb.length() - 1) == '.')
			sb.deleteCharAt(sb.length() - 1);

		if (sb.length() == 0)
			sb.append('a');

		while (sb.length() < 3)
			sb.append(sb.charAt(sb.length() - 1));
		System.out.println(sb);
		return sb.toString();
	}
}
