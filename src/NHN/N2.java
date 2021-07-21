package NHN;

import java.util.Scanner;

public class N2 {
	private static void solution(int day, int width, int[][] blocks) {
		// TODO: 이곳에 코드를 작성하세요. 추가로 필요한 함수와 전역변수를 선언해서 사용하셔도 됩니다.
		int[][] ar = new int[width][3];
		int count = 0;

		for(int i=0 ; i<day ; i++) {

			for(int j=0 ; j<width ; j++) {
				ar[j][0] += blocks[i][j];
			}

			int leftmax = 0;

			for(int j=0 ; j<width ; j++) {
				leftmax = Math.max(leftmax, ar[j][0]);
				ar[j][1] = leftmax;
			}

			int rightmax = 0;

			for(int j=width-1 ; j>=0 ; j--) {
				rightmax = Math.max(rightmax, ar[j][0]);
				ar[j][2] = rightmax;
			}

			for(int j=0 ; j<width ; j++) {
				int num = Math.min(ar[j][1], ar[j][2])-ar[j][0];
				count += num;
				ar[j][0] += num;
			}
		}

		System.out.println(count);
	}

	private static class InputData {
		int day;
		int width;
		int[][] blocks;
	}

	private static InputData processStdin() {
		InputData inputData = new InputData();

		try (Scanner scanner = new Scanner(System.in)) {
			inputData.day = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));      
			inputData.width = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

			inputData.blocks = new int[inputData.day][inputData.width];
			for (int i = 0; i < inputData.day; i++) {
				String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
				for (int j = 0; j < inputData.width; j++) {
					inputData.blocks[i][j] = Integer.parseInt(buf[j]);
				}
			}
		} catch (Exception e) {
			throw e;
		}

		return inputData;
	}

	public static void main(String[] args) throws Exception {
		InputData inputData = processStdin();

		solution(inputData.day, inputData.width, inputData.blocks);
	}
}