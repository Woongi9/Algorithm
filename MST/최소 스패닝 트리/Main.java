import java.io.*;
import java.util.*;

public class Main {
	
	static int n, m, min;
	static int [] parent;
	static ArrayList<L> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		parent = new int [n+1];
		
		for(int i = 0; i < m; i ++) {
			
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			list.add(new L(x,y,cost));
		}
		Collections.sort(list);
		
		for(int i = 1; i < n+1; i++)
			parent[i] = i;
		
		MST();
		
		System.out.println(min);
		
	}
	
	public static void MST() {
		
		for(L l : list) {
			
			if(!Circle(l.x, l.y)) {
				Union(l.x, l.y);
				min += l.cost;
			}
		}
	}
	
	public static int Find(int x) {
		if(parent[x] == x)
			return x;
		else
			return parent[x] = Find(parent[x]);
	}
	
	public static boolean Circle(int x, int y) {
		x = Find(x);
		y = Find(y);
		
		if(x == y)
			return true;
		else
			return false;
	}
	
	public static void Union(int x, int y) {
		x = Find(x);
		y = Find(y);
		
		if(x != y) 
			parent[y] = x;
	}
}

class L implements Comparable<L>{
	
	int x;
	int y;
	int cost;
	
	L(int x, int y, int cost){
		this.x = x;
		this.y = y;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(L l) {
		return this.cost - l.cost;
	}
}
