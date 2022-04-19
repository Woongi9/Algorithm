import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n, target, cnt;
	static int [] coin;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		target = Integer.parseInt(st.nextToken());
		
		coin = new int [n];
		
		for(int i = 0; i < n; i++) 
			coin[i] = Integer.parseInt(br.readLine());
		
		cnt = 0;
		
		Greedy();
		
		System.out.print(cnt);
	}
	
	public static void Greedy() {
		
		for(int i = n-1; i >= 0; i--) {
			if(target/coin[i] > 0) {
				cnt += target/coin[i];
				target %= coin[i];
			}
		}
	}

}

