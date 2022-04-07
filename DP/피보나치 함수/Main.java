import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int testCase, count0, count1, max;
	static int [] N;
	static int [] dp0,dp1;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		testCase = Integer.parseInt(br.readLine());
		
		N = new int [testCase];
		dp0 = new int [41];
		dp1 = new int [41];
		max = 0;
		
		for(int i = 0; i < testCase; i++)
		{
			N[i] = Integer.parseInt(br.readLine());
			if(max < N[i])
				max = N[i];
		}
		
		dp0[0] = dp1[1] = 1;
		dp0[1] = dp1[0] =0;
	
//		DP
		if(max >= 2)
		{
			for(int j = 2; j <= max; j++)
			{
				dp0[j] = dp0[j-2] + dp0[j-1];
				dp1[j] = dp1[j-2] + dp1[j-1];
			}
		}
		
		for(int i = 0 ; i < testCase; i++)
			System.out.println(dp0[N[i]] + " " + dp1[N[i]]);
	}
}

