import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Long a = (long) Integer.parseInt(st.nextToken());
		Long b = (long) Integer.parseInt(st.nextToken());
		Long c = (long) Integer.parseInt(st.nextToken());
		
		System.out.println(Cal(a,b,c));
		
	}
	
	public static Long Cal(long a, long b, long c) {
		
		Long n = (long) 0;
		
		if(b == 1) {
			n = (long) a % c;
		}else if(b > 1 && b % 2 == 0) {
			n = Cal(a, b/2, c);
			n = n * n % c;
		}else if (b > 1 && b % 2 != 0) {
			n = Cal(a, b/2, c);
			n = (((n * n) % c) * a) % c;
		}
		return n;
	}

}
