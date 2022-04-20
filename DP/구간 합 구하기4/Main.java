import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n,m;
	static int [] N;
	static int [] start;
	static int [] end;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		N = new int [n];
		
		start = new int [m];
		end = new int [m];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i<n; i++) {
			int x = Integer.parseInt(st.nextToken());
			
			if(i > 0) 
				N[i] = N[i-1] + x;
			else
				N[i] = x;
		}
		
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			start[i] = Integer.parseInt(st.nextToken());
			end[i] = Integer.parseInt(st.nextToken());
			
			if(start[i] > 1)
				sb.append(N[end[i]-1] - N[start[i]-2]).append("\n");
			else
				sb.append(N[end[i]-1]).append("\n");
		}
		
		System.out.print(sb);
	}
}

