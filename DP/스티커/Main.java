import java.io.*;
import java.util.*;

public class Main {

	static int testCase, n;
	static int [][] board;
	static int [][] dp;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		testCase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < testCase; i++) {
			n = Integer.parseInt(br.readLine());
			
			board = new int [3][n+1];
			dp = new int [3][n+1];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1; j < n+1; j++) 
				board[1][j] = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j < n+1; j++) 
				board[2][j] = Integer.parseInt(st.nextToken());
			
			//1열
			dp[1][1] = board[1][1];
			dp[2][1] = board[2][1];
			
			if(n == 1) {
				sb.append(Math.max(dp[1][n], dp[2][n])).append("\n");
			}else {
			
				//	2열 
				dp[1][2] = Math.max(dp[1][1], dp[2][1] + board[1][2]);
				dp[2][2] = Math.max(dp[2][1], dp[1][1] + board[2][2]);
			
				for(int k = 3; k < n+1; k++) {
					dp[1][k] = Math.max(dp[2][k-1], dp[2][k-2]) + board[1][k];
					dp[2][k] = Math.max(dp[1][k-1], dp[1][k-2]) + board[2][k];	
				}
			
				sb.append(Math.max(dp[1][n], dp[2][n])).append("\n");
			}
		}
		
		System.out.print(sb);
		
	}

}
