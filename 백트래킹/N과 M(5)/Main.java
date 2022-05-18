import java.io.*;
import java.util.*;

public class Main {
	
	static int n,m;
	static int [] num;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		num = new int [n+1];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i<n+1; i++)
			num[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(num);
		int [] tem = new int [m+1];
		boolean [] visited = new boolean [n+1];
		
		for(int i = 1; i<n+1; i++) {
			
			tem[1] = num[i];
			visited[i] = true;
			
			dfs(tem, visited, 1);
			visited[i] = false;
			
		}
		
		System.out.print(sb);
		
	}
	
	public static void dfs(int [] tem, boolean [] visited, int cnt) {
		
		if(cnt == m) {
			for(int i = 1; i < cnt+1; i++) 
				sb.append(tem[i]).append(" ");
			sb.append("\n");
		}else {
			
			for(int i = 1; i < n+1; i++) {
				
				if(!visited[i]) {
					tem[cnt+1] = num[i];
					visited[i] = true;
					dfs(tem, visited, cnt+1);
					visited[i] = false;
				}
				
			}
			
		}
	}

}
