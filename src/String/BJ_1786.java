package String;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ_1786 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] text = br.readLine().toCharArray();
		char[] pattern = br.readLine().toCharArray();

		int[] p_array = new int[pattern.length];

		int i1 = 1, i2 = 0;

		while (i1 < pattern.length) {
			if (pattern[i1] == pattern[i2]) {
				p_array[i1++] = ++i2;
			} else if (i2 == 0) {
				i1++;
			} else {
//				i2 = p_array[i1];
				i2 = p_array[i2 - 1];
			}
		}

		int tIndex = 0, pIndex = 0;

		ArrayList<Integer> list = new ArrayList<>();

		while (tIndex < text.length) {
//			System.out.println(tIndex+" "+pIndex);
//			System.out.println(text[tIndex]+" "+pattern[pIndex]);
			if (text[tIndex] == pattern[pIndex]) {
//				System.out.println("same");
				tIndex++;
				pIndex++;
			} else if (pIndex == 0) {
				tIndex++;
			} else {
				pIndex = p_array[pIndex - 1];
			}
			if (pIndex == pattern.length) {
				list.add(tIndex - (pattern.length - 1));
				pIndex = p_array[pIndex - 1];
			}
		}

		System.out.println(list.size());
		StringBuilder sb = new StringBuilder();
		for (int i : list)
			sb.append(i).append(" ");
		System.out.println(sb);
	}
}
