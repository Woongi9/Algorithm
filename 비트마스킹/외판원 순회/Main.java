import java.io.*;
import java.util.*;

public class Main2 {
	
	static int n, INF = 987654321;
	static int [][] w; 
	static int [][] dp;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		w = new int [n][n];
		dp = new int [n][(1<<n) - 1];
		
		for(int i = 0; i < n; i++)
			Arrays.fill(dp[i], INF);
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < n; j++) 
				w[i][j] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(tsp(0,1));
	}
	
	public static int tsp(int x, int check) {
		
		if(check == ((1<<n) - 1)) {
			if(w[x][0] == 0) return INF;
			else return w[x][0];
		}
		
		if(dp[x][check] != INF) return dp[x][check];
		
		for(int i = 0; i < n; i++) {
			
			int next = check | (1<<i);
			
			if(w[x][i] == 0 || (check & (1<<i)) != 0) continue;
			
			dp[x][check] = Math.min(dp[x][check], tsp(i, next) + w[x][i]);
		}
		
		return dp[x][check];
	}

}
