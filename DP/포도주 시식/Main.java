import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int n;
	static int [] N;
	static int [] max;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		N = new int [n+1];
		max = new int [n+1];
		
		for(int i = 1; i < n+1; i++) 
			N[i] = Integer.parseInt(br.readLine());
		
		max[1] = N[1];
		if (n > 1) {
			max[2] = N[1] + N[2];
		}
		for (int i = 3; i <= n; i++) 
			max[i] = Math.max(max[i - 1], Math.max(max[i - 2] + N[i], max[i - 3] + N[i - 1] + N[i]));
		System.out.println(max[n]);
	}
}
