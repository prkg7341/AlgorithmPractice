import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_2616 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] ar = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());

		int num = Integer.parseInt(br.readLine());

		PriorityQueue<Position> pq = new PriorityQueue<>();
		HashSet<Integer> visit_set = new HashSet<>();

		for (int i = 0; i < n; i++) {
			ar[i] = Integer.parseInt(st.nextToken());
			if (i > 0)
				ar[i] += ar[i - 1];
			if (i >= num - 1) {
				visit_set.add(i);
				try {
					pq.add(new Position(i, ar[i] - ar[i - num]));
				} catch (ArrayIndexOutOfBoundsException e) {
					pq.add(new Position(i, ar[i]));
				}
			}
		}

		int count = 3;

		int sum = 0;

		while (!pq.isEmpty() && count > 0) {
			Position now = pq.poll();

			int index = now.end_index;

			if (visit_set.contains(index)) {
				for (int i = 0; i < num; i++) {
					visit_set.remove(index - i);
				}
				sum += now.value;
				count--;
				System.out.println(now.value);
			}
		}

		System.out.println(sum);
	}

	static class Position implements Comparable<Position> {
		int end_index, value;

		public Position(int end_index, int value) {
			this.end_index = end_index;
			this.value = value;
		}

		@Override
		public int compareTo(Position o) {
			return o.value - this.value;
		}
	}
}