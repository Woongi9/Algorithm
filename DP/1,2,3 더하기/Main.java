import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

	static int n,t;
	static int [] N = new int [11];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		t = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < t; i++) {
			
			n = Integer.parseInt(br.readLine());
			
			N[0] = 1;
			N[1] = 2;
			N[2] = 4;
			
			if(n >= 3) {
			for(int j = 3 ; j < n; j++)
				N[j] = N[j-1] + N[j-2] + N[j-3];
			}
			sb.append(N[n-1]).append("\n");
		}	
		System.out.println(sb);
	}
}

