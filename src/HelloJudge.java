import java.util.Scanner;

public class HelloJudge{

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		sc.close();
		for(int i=1 ; i<=n ; i++){
			sb.append("Hello World, Judge "+i+"!\n");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.print(sb.toString());
	}
}