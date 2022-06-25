import java.io.*;
import java.util.*;

public class Main {
	
	static int t, n, start;
	static int [] parent;
	static int [] check;
	static HashSet<Integer> set = new HashSet<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		t = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < t; i++) {
			n = Integer.parseInt(br.readLine());
			parent = new int [n+1];
			check = new int [n+1];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1; j < n+1; j++) {
				parent[j] = Integer.parseInt(st.nextToken());
				if(j == parent[j])
					check[j] = 2;
			}
			
			for(int j = 1; j < n+1; j++) {
				if(check[j] == 0) {
					start = j;
					set.clear();
					set.add(j);
					Find(j);
				}
			}
			
			int cnt = 0;
			for(int j = 1; j < n+1; j++) {
				if(check[j] == 1)
					cnt++;
			}
			
			sb.append(cnt).append("\n");
		}
		
		System.out.print(sb);
	}
	
	public static void Find(int x) {
		
		if(parent[x] == start) {
			MakeCheck(parent[x]);
			return;
		}else if(set.contains(parent[x])) {
			MakeCheck(parent[x]);
			return;
		}
		
		if(check[parent[x]] == 0) {
			set.add(parent[x]);
			Find(parent[x]);
		}
		
		if(check[x] == 0) {
			check[x] = 1;
		}
	}
	
	public static void MakeCheck(int x) {
		
		check[x] = 2;
		
		if(check[parent[x]] == 0)
			MakeCheck(parent[x]);
	}

}

