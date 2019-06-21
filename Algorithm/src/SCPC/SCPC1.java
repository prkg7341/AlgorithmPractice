package SCPC;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
You should use the standard input/output

in order to receive a score properly.

Do not use file input and output

Please be very careful. 
*/

import java.util.Scanner;

/*
   As the name of the class should be Solution , using Solution.java as the filename is recommended.
   In any case, you can execute your program by running 'java Solution' command.
 */
public class SCPC1 {
	static int Answer;

	public static void main(String args[]) throws Exception	{
		/*
		   The method below means that the program will read from input.txt, instead of standard(keyboard) input.
		   To test your program, you may save input data in input.txt file,
		   and call below method to read from the file when using nextInt() method.
		   You may remove the comment symbols(//) in the below statement and use it.
		   But before submission, you must remove the freopen function or rewrite comment symbols(//).
		 */		

		/*
		   Make new scanner from standard input System.in, and read data.
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		//Scanner sc = new Scanner(System.in);	
		//Scanner sc = new Scanner(new FileInputStream("input.txt"));

		int T = Integer.parseInt(br.readLine());
		int[][] dp = new int[1000000+1][2];
		    
	    for(int i=2 ; i<=1000000 ; i++){
	        if(i%2==1){
	            dp[i][0] = dp[i/2+1][0]+2;
	        }
	        else{
	            dp[i][0] = dp[i/2][0]+1;
	        }
	        dp[i][1] = dp[i][0]+dp[i-1][1];
	    }
	    
		for(int test_case = 0; test_case < T; test_case++) {

			Answer = 0;
			/////////////////////////////////////////////////////////////////////////////////////////////
			/*
			   Implement your algorithm here.
			   The answer to the case will be stored in variable Answer.
			 */
			String[] input = br.readLine().split(" ");
		    int from = Integer.parseInt(input[0]);
		    int to = Integer.parseInt(input[1]);
		    
		   Answer = dp[to][1]-dp[from-1][1];
		    
			/////////////////////////////////////////////////////////////////////////////////////////////


			// Print the answer to standard output(screen).
		    sb.append("Case #"+(test_case+1)).append("\n");
		    sb.append(Answer).append("\n");
		}
		System.out.println(sb.toString());
	}
}