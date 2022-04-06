import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, k;
	static int [] coin;
	static int [] dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		coin = new int [n];
		dp = new int [k+1];
		
		if(n > 100)
			return;
		
		for(int i = 0; i < n; i++)
			coin[i] = Integer.parseInt(br.readLine());
		
		dp[0] = 1;
		
		for(int i = 0 ; i < n; i++)
		{
			for(int j = coin[i]; j < k+1; j++)
			{
				dp[j] += dp[j-coin[i]];
			}
		}	
		System.out.print(dp[k]);
	}
}

