import java.io.*;
import java.util.*;

public class Main {
	
	static int n,m, ans;
	static boolean check;
	static int [] parent;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		parent = new int [n];
		
		for(int i = 0 ; i < n; i++)
			parent[i] = i;
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			if(!check) {
				//circle 체크
				check = Circle(x,y);
				if(check) 
					ans = i+1;
			}
		}
		
		System.out.println(ans);
	}
	
	public static int Find(int x) {
		if(parent[x] == x)
			return x;
		return Find(parent[x]);
	}
	
	public static boolean Circle(int x, int y) {
		
		int fx = Find(x);
		int fy = Find(y);
		
		if(fx == fy) {
			return true;
		}else {
			parent[fy] = fx;
		}
		
		return false;
	}

}

