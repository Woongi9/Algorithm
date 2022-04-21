import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int n;
	static int [] N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		N = new int [50001];
		
		N[1] = 1;
		
		solve(n);
		
		System.out.println(N[n]);
	}
	
	static void solve(int n) {
		for (int i = 2; i <= n; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 1; j * j <= i; j++) {
				min = Math.min(min,	N[i - j * j]);
			}
			N[i] = min + 1; 
		}
	}
}
