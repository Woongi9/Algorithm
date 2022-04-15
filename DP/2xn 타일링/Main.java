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
		N = new int [n];
		
		N[0] = 1;
		
		if(n > 1) {
			N[1] = 2;
			
			for(int i = 2 ; i < n; i++)
				N[i] = (N[i-1] + N[i-2])%10007;
		}
		System.out.println(N[n-1]);
	}

}

