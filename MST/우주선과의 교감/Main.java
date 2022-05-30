import java.io.*;
import java.util.*;

public class Main {
	
	static int n,m;
	static double cnt;
	static int [] parent;
	static int [][] dot;
	static PriorityQueue<Line> pq = new PriorityQueue<>();

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		dot = new int [n+1][2];
		parent = new int [n+1];
		
		for(int i = 1; i < n+1; i++) {
			parent[i] = i;
			
			st = new StringTokenizer(br.readLine());
			
			dot[i][0] = Integer.parseInt(st.nextToken());
			dot[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i < m+1; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			Union(from, to);
		}
		
		for(int i = 1; i < n+1; i++) {
			for(int j = i+1; j < n+1; j++) {
				
				pq.add(new Line(i,j, Math.sqrt(Math.pow(dot[j][0] - dot[i][0], 2) + Math.pow(dot[j][1] - dot[i][1], 2))));
			}
		}
		
		cnt = 0;
		
		while(!pq.isEmpty()) {
			
			Line l = pq.remove();
			
			if(!isSameRoot(l.from, l.to)) {
				Union(l.from, l.to);
				cnt += l.cost;
			}
		}
		
		System.out.println(String.format("%.2f", cnt));
		
	}
	
	public static int Find(int x) {
		
		if(parent[x] == x)
			return x;
		
		return Find(parent[x]);
	}
	
	public static boolean isSameRoot(int x, int y) {
		
		x = Find(x);
		y = Find(y);
		
		if(x == y)
			return true;
		return false;
	}
	
	public static void Union(int x, int y) {
		
		x = Find(x);
		y = Find(y);
		
		if(x != y) 
			parent[y] = x;
	}

}

class Line implements Comparable<Line>{
	
	int from;
	int to;
	double cost;
	
	public Line(int from, int to, double cost) {
		this.from = from;
		this.to = to;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(Line l) {
		return Double.compare(this.cost, l.cost);
	}
}
