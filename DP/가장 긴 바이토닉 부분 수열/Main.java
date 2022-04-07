import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n, max;
	static int [] A;
	static int [] dp_up, dp_down;
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		A = new int [n];
		dp_up = new int [n];
		dp_down = new int [n];
		max = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0 ; i < n; i++)
			A[i] = Integer.parseInt(st.nextToken());
		
		Up();
		Down();
		
		for(int i = 0 ; i < n; i ++)
		{
			if(max < dp_up[i] + dp_down[i])
				max = dp_up[i] + dp_down[i];
		}
		System.out.print(max-1);
	}
	
	public static void Up() {
		
		for(int i = 0 ; i < n; i++)
		{
			dp_up[i] = 1;
			
			for(int j = 0; j<i; j++)
			{
				if(A[i] > A[j] && dp_up[i] < dp_up[j] + 1)
					dp_up[i] = dp_up[j]+1;
			}
		}
	}
	
	public static void Down() {
		
		for(int i = n-1; i >= 0 ; i--)
		{
			dp_down[i] = 1;
			
			for(int j = n-1; j>i; j--)
			{
				if(A[i] > A[j] && dp_down[i] < dp_down[j]+1)
					dp_down[i] = dp_down[j]+1;
			}
		}
		
	}
}
