package BruteForce;
import java.io.IOException;
import java.util.Scanner;

public class SWEA_1247 {

	static int min;

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();

		for (int tt = 1; tt <= t; tt++) {
			min = 987654321;
			int num = scanner.nextInt();
			Customer[] customers = new Customer[num];

			Customer company = new Customer(scanner.nextInt(), scanner.nextInt());
			Customer home = new Customer(scanner.nextInt(), scanner.nextInt());

			for (int i = 0; i < num; i++) {
				customers[i] = new Customer(scanner.nextInt(), scanner.nextInt());
			}

			p(customers, company, home, new int[num], new boolean[num], 0);
			System.out.printf("#%d %d\n",tt,min);
		}
		scanner.close();
	}

	private static void p(Customer[] customers, Customer company, Customer home, int[] arr, boolean[] visit,
			int index) {
		if (index == arr.length) {
			int sum = 0;

			sum += distance(company, customers[arr[0]]);

			for (int i = 1; i < arr.length; i++) {
				sum += distance(customers[arr[i]], customers[arr[i - 1]]);
				if(sum>=min) break;
			}
			sum += distance(home, customers[arr[arr.length - 1]]);

			min = Math.min(min, sum);
		}

		for (int i = 0; i < arr.length; i++) {
			if (!visit[i]) {
				visit[i] = true;
				arr[i] = index;
				p(customers, company, home, arr, visit, index + 1);
				visit[i] = false;
			}
		}
	}

	private static int distance(Customer customer, Customer customer2) {
		return Math.abs(customer.r - customer2.r) + Math.abs(customer.c - customer2.c);
	}

	static class Customer {
		int r, c;

		public Customer(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
