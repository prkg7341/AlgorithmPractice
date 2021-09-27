package String;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1755 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

		int from = Integer.parseInt(stringTokenizer.nextToken());
		int to = Integer.parseInt(stringTokenizer.nextToken());

		String[] ar = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
		HashMap<String, Integer> map = new HashMap<>();

		for (int i = 0; i < ar.length; i++) {
			map.put(ar[i], i);
		}

		PriorityQueue<String> pQueue = new PriorityQueue<>();

		for (int num = from; num <= to; num++) {
			String st;
			if (num >= 10)
				st = ar[num / 10] + " " + ar[num % 10];
			else
				st = ar[num % 10];
			pQueue.add(st);
		}
		int index = 0;
		StringBuilder sBuilder = new StringBuilder();

		while (!pQueue.isEmpty()) {
			stringTokenizer = new StringTokenizer(pQueue.poll());

			while (stringTokenizer.hasMoreTokens())
				sBuilder.append(map.get(stringTokenizer.nextElement()));
			if (++index % 10 == 0)
				sBuilder.append("\n");
			else
				sBuilder.append(" ");
		}

		System.out.println(sBuilder);
	}
}
