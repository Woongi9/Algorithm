import java.io.*;
import java.util.*;

public class Main {
	
	static boolean check;
	static int n,m;
	static int [] parent;
	static int [] self;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		parent = new int [n+1];
		self = new int [n+1];
		
		for(int i = 1; i < n+1; i++) 
			parent[i] = i;
		
		
		StringTokenizer st;
		
		for(int i = 1 ; i < n+1; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 1; j < n+1; j++) {
				
				int tem = Integer.parseInt(st.nextToken());
				
				if(j > i && tem == 1)
					Union(i,j);
			}
		}
		
		st = new StringTokenizer(br.readLine());
		
		int start = Find(Integer.parseInt(st.nextToken()));
		
		for(int i = 2; i < m+1; i++) {
			int now = Find(Integer.parseInt(st.nextToken()));
			
			if(start != now) {
				System.out.println("NO");
				return;
			}
		}
		
		System.out.println("YES");
		
	}
	
	public static int Find(int x) {
		
		if(x == parent[x])
			return x;
			
		return Find(parent[x]);
	}
	
	public static void Union(int x, int y) {
		
		x = Find(x);
		y = Find(y);
		
		if(x != y) {
			if(x < y) 
				parent[y] = x;
			else
				parent[x] = y;
		}
	}
}
