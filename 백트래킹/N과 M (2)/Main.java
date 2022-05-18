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
		
		for(int i = 1; i < n+1; i++) {
			int [] arr = new int [m+1];
			arr[1] = i;
			dfs(arr, 1);
		}
		
		System.out.print(sb);
		
	}
	
	public static void dfs(int [] arr, int cnt) {
		
		if(cnt == m) {
			for(int i = 1; i < cnt+1; i++) 
				sb.append(arr[i]).append(" ");
			sb.append("\n");
		}else {
			
			for(int i = arr[cnt]+1; i<n+1; i++) {
				
				arr[cnt+1] = i;
				dfs(arr, cnt+1);
			}
			
		}
		
	}

}
