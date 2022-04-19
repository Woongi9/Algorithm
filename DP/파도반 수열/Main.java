import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static Long testCase;
	static int n;
	static Long [] N;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		testCase = Long.valueOf(br.readLine());
		
		for(int i = 0; i<testCase; i++) {
			
			n = Integer.parseInt(br.readLine());
			
			if(n <= 5) {
				N = new Long [5];
				N[0] = N[1] = N[2] = (long) 1;
				N[3] = N[4] = (long)2;
			}else {
				N = new Long [n];
				N[0] = N[1] = N[2] = (long)1;
				N[3] = N[4] = (long)2;
				
				for(int j = 5; j<n; j++) {
					N[j] = N[j-1] + N[j-5];
				}
			}
			sb.append(N[n-1]).append("\n");
		}	
		System.out.print(sb);
	}
}

