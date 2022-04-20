import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int n;
	static int [] N;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		N = new int [n+1];
		N[1] = 1;
		
		for(int i = 2; i<n+1; i++) {
			if(i%2 == 0)
				N[i] = (N[i-1] * 2 + 1)%10007;
			else
				N[i] = (N[i-1] * 2 - 1)%10007;
		}
		
		System.out.println(N[n]);
	}

}
