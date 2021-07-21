import java.util.Scanner;

public class Origami {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = (int) Math.pow(sc.nextInt(),2);
		int result = 0;
		
		while(n-- != 0){
			result += sc.nextInt();
		}
		System.out.println(result);
	}
}
