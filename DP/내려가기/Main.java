import java.io.*;
import java.util.*;

public class Main {
	
	static int n;
	static int [][] board;
	static int [][] dp;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		board = new int [3][n];
		dp = new int [3][n];
		
		for(int i = 0; i < n; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			board[0][i] = Integer.parseInt(st.nextToken());
			board[1][i] = Integer.parseInt(st.nextToken());
			board[2][i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < 3; i++)
			dp[i][0] = board[i][0]; 
		
		//DP
		for(int i = 1; i < n; i++) {
			for(int j = 0; j<3; j++) {
				
				if(j == 0) {
					dp[j][i] = Math.max(dp[0][i-1], dp[1][i-1]) + board[j][i];
				}else if(j == 1) {
					dp[j][i] = Math.max(dp[0][i-1], Math.max(dp[1][i-1], dp[2][i-1])) + board[j][i];
				}else if(j == 2) {
					dp[j][i] = Math.max(dp[1][i-1], dp[2][i-1]) + board[j][i];
				}
			}
		}
		
		int max = 0;
		int min = 99999999;
		
		for(int i = 0; i < 3; i++) {
			if(max < dp[i][n-1])
				max = dp[i][n-1];
		}
		
		dp = new int [3][n];
		
		for(int i = 0; i<3; i++) {
			dp[i][0] = board[i][0];
		}
		
		for(int i = 1; i < n; i++) {
			for(int j = 0; j<3; j++) {
				
				if(j == 0) {
					dp[j][i] = Math.min(dp[0][i-1], dp[1][i-1]) + board[j][i];
				}else if(j == 1) {
					dp[j][i] = Math.min(dp[0][i-1], Math.min(dp[1][i-1], dp[2][i-1])) + board[j][i];
				}else if(j == 2) {
					dp[j][i] = Math.min(dp[1][i-1], dp[2][i-1]) + board[j][i];
				}
			}
		}
		
		for(int i = 0; i < 3; i++) {
			if(min > dp[i][n-1])
				min = dp[i][n-1];
		}
		
		System.out.println(max + " " + min);
	
	}

}

