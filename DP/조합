import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
BigInteger[][] dp=new BigInteger[101][101];
		
		dp[1][0]=dp[1][1]=BigInteger.ONE;
		for(int i=2;i<=100;i++) {
			for(int j=0;j<=i;j++) {
				if(j==0 || i==j) dp[i][j]=BigInteger.ONE;
				else dp[i][j]=dp[i-1][j].add(dp[i-1][j-1]);
			}
		}
		
		System.out.println(dp[n][m]);
	}
}
