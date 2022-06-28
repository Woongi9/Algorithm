import java.io.*;
import java.util.*;

public class Main {
	
	static int n;
	static int [][] arr;
	static int [][] dp;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int [n][2];
		dp = new int [n][n];
		
		StringTokenizer st;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < n-1; i++) 
			dp[i][i+1] = arr[i][0] * arr[i][1] * arr[i+1][1];
		
		for(int i = 2; i < n; i++) {
			for(int j = 0; j + i < n; j++) {
				int k = i + j;
				dp[j][k] = Integer.MAX_VALUE;
				
				for(int x = j; x < k; x++) 
					dp[j][k] = Math.min(dp[j][k], dp[j][x] + dp[x+1][k] + (arr[j][0] * arr[k][1] * arr[x][1]));
			}
		}
		
		System.out.println(dp[0][n-1]);
	}

}
