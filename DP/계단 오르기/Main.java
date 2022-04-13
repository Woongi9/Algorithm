import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int n;
	static int [] N;
	static int [] scored; 

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		N = new int [n+1];
		scored = new int [n+1];
		
		for(int i = 1 ; i <= n; i++)
			N[i] = Integer.parseInt(br.readLine());
		
		scored[1] = N[1];
		
		if(n >= 2)
			scored[2] = scored[1] + N[2];
		
		//DP
		for(int i = 3 ; i <= n; i++) 		
			scored[i] = Math.max(scored[i-2], scored[i-3] + N[i-1]) + N[i];
		
		//DFS
//		DFS(0,0,0, N[0]);
		
		System.out.println(scored[n]);
	}
}
