import java.io.*;
import java.util.*;

public class Main {
	
	static int m,a,b;
	static Long result;
	static int [] count;
	static int mod = 1000000007;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		m = Integer.parseInt(br.readLine());
		
		count = new int [m+1];
		result = 0L;
		
		for(int i = 1; i < m+1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			b = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			
			result += (a * Sigma(1000000005, 1L)) % mod;
			result %= mod;
		}
		
		System.out.println(result);
		
	}
	
	public static Long Sigma(int x, Long y) {
		
		if(x == 0)
			return (long) y;
		
		if(x > 1) {
			y = Sigma(x/2, y);
			y = (y * y) % 1000000007;
			y = Sigma(x%2, y);
		}else {
			y = (y * b) % 1000000007;
		}
		
		return (long) y;
	}

}
