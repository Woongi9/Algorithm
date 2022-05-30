import java.io.*;
import java.util.*;

public class Main {
	
	static int n;
	static double cnt;
	static int [] parent;
	static double [][] d;
	static PriorityQueue<R> pq = new PriorityQueue<>();

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		d = new double [n+1][2];
		parent = new int [n+1];
		
		for(int i = 1; i < n+1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			d[i][0] = Double.parseDouble(st.nextToken());
			d[i][1] = Double.parseDouble(st.nextToken());
		}
		
		for(int i = 1; i < n+1; i++) {
			parent[i] = i;
		}
		
		for(int i = 1; i < n+1; i++) {
			for(int j = i+1; j < n+1; j++) {
				pq.add(new R(i,j, Math.sqrt(Math.pow(d[j][0] - d[i][0], 2) + Math.pow(d[j][1] - d[i][1], 2))));
			}
		}
		
		cnt = 0;
		
		while(!pq.isEmpty()) {
			
			R r = pq.remove();
			
			if(!isSameRoot(r.to, r.from)) {
				Union(r.to, r.from);
				cnt += r.cost;
			}
		}
		
		System.out.println(Math.round(cnt*100)/100.0);
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
		
		parent[y] = x;
	}

}

class R implements Comparable<R>{
	int from;
	int to;
	double cost;
	
	public R(int from, int to, double cost) {
		this.from = from;
		this.to = to;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(R r) {
		return Double.compare(this.cost, r.cost);
	}
}
