import java.io.*;
import java.util.*;

public class Main {
	
	static int t,n,k, target,min;
	static int [] cnt;
	static int [] time;
	static int [] dp;
	static ArrayList<Integer>[] list;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		t = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < t; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			cnt = new int [n+1];
			time = new int [n+1];
			list = new ArrayList [n+1];
			dp = new int [n+1];
			
			st = new StringTokenizer(br.readLine());
			
			for(int j = 1; j < n+1; j++) {
				time[j] = Integer.parseInt(st.nextToken());
				list[j] = new ArrayList<>();
			}
			
			for(int j = 1; j < k+1; j++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				cnt[to]++;
				list[from].add(to);
			}
				
			target = Integer.parseInt(br.readLine());
			
			dp = time.clone();
			
			DP();
			
			sb.append(dp[target]).append("\n");
			
		}
		
		System.out.print(sb);
		
	}
	
	public static void DP() {
		
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 1; i < n+1; i++) {
			if(cnt[i] == 0) {
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			
			int cur = q.remove();
			
			for(int i : list[cur]) {
				
				dp[i] = Math.max(dp[i], dp[cur] + time[i]);
				cnt[i]--;
				
				if(cnt[i] == 0)
					q.add(i);	
			}	
		}			
	}
}
