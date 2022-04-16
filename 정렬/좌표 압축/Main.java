import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static Long [] N;
	static Long [] sorted;
	static HashMap<Long, Long> map = new HashMap<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		N = new Long [n];
		sorted = new Long [n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i<n; i++) {
			Long tem = Long.valueOf(st.nextToken());
			sorted[i] = N[i] = tem;
		}
		
		Arrays.sort(sorted);
		
		Long rank = (long) 0;
		for(int i = 0; i < n; i++) {
			if(!map.containsKey(sorted[i])) {
				map.put(sorted[i], rank);
				rank++;
			}
				
		}
		
		
		for(int i = 0; i<n; i++) {
			sb.append(map.get(N[i])).append(" ");
		}
		
		System.out.println(sb);
			
		
	}

}

