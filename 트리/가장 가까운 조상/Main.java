import java.io.*;
import java.util.*;

public class Main {
	
	static int testCase, n, x1, x2;
	static int [] parent;
	static boolean [] visited;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		testCase = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < testCase; i++) {
			
			n = Integer.parseInt(br.readLine());
			
			parent = new int [n+1];
			visited = new boolean [n+1];
			
			for(int j = 1; j < n; j++) {
				
				st = new StringTokenizer(br.readLine());
				
				int p = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				parent[c] = p;
			}
			
			st = new StringTokenizer(br.readLine());
			
			x1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			
			if(x1 == x2) {
				sb.append(x1).append("\n");
				continue;
			}	
			
			visited[x1] = true;
			find(x1);
			
			//루트 노드 들어오는 경우
			if(parent[x2] == 0) {
				
				sb.append(x2).append("\n");
				continue;
			}
			find(x2);
		}
		System.out.print(sb);
	}
	
	public static void find(int x) {
		
		while(parent[x] != 0) {
			if(visited[parent[x]]) {
				sb.append(parent[x]).append("\n");
				break;
			}else {
				visited[parent[x]] = true;
				x = parent[x];
			}	
		}
		
	}

}

