import java.io.*;
import java.util.*;

public class Main {
	
	static int t, n;
	static int [] parent;
	static int [] level;
	static StringBuilder sb = new StringBuilder();
	static HashMap<String, Integer> map = new HashMap<>();
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		t = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < t; i ++) {
			
			n = Integer.parseInt(br.readLine());
			
			parent = new int [n*2];
			level = new int [n*2];
			
			for(int j = 0; j < n*2; j++) {
				parent[j] = j;
				level[j] = 1;
			}
			
			int x = 0;
			
			for(int j = 0; j < n; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				
				String str1 = st.nextToken();
				String str2 = st.nextToken();
				
				if(!map.containsKey(str1)) {
					map.put(str1, x++);
				}
				
				if(!map.containsKey(str2)) {
					map.put(str2, x++);
				}
				
				sb.append(Union(map.get(str1), map.get(str2))).append("\n");
			}
		}
		
		System.out.print(sb);
	}
	
	public static int Find(int x) {
		if(x == parent[x])
			return x;
		
		return parent[x] = Find(parent[x]);
	}
	
	public static int Union(int x, int y) {
		x = Find(x);
		y = Find(y);
		
		if(x != y) {
			parent[y] = x;
			
			level[x] += level[y];
		}
		
		return level[x];
	}

}
