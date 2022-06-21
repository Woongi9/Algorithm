import java.io.*;
import java.util.*;

public class Main {
	
	static int n,m,sum,min;
	static int [] w;
	static int [] v;
	static int [][] dp;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		w = new int [n+1];
		v = new int [n+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) 
			w[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			v[i] = Integer.parseInt(st.nextToken());
			sum += v[i];
		}
		
		dp = new int [n+1][sum+1];
		
		for(int i = 1; i <= n; i++) {
			
			for(int j = 0; j < sum+1; j++) {
				
				if(v[i] > j) {
					dp[i][j] = dp[i-1][j];
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-v[i]] + w[i]);
				}
			}
		}
		
		int input = 0;
		while(input < sum+1) {
			
			if(dp[n][input] >= m) {
				min = input;
				break;
			}
			input++;
		}
		
		System.out.println(min);
		
	}
}
