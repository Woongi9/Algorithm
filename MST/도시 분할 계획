import java.io.*;
import java.util.*;

public class Main {
	
	static int n,m,cnt;
	static int [] parent;
	static int [] count;
	static PriorityQueue<Road> pq = new PriorityQueue<>();

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		parent = new int [n+1];
		
		for(int i = 1; i < n+1; i++)
			parent[i] = i;
		
		for(int i = 0; i < m; i ++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			pq.add(new Road(from, to, cost));
		}
		
		int size = pq.size();
		int last = 0;
		for(int i = 0 ; i < size; i++){
			
			Road r = pq.poll();
			
			int from = r.from;
			int to = r.to;
			int cost = r.cost;
			
			if(find(from) != find(to)) {
				union(from, to);
				cnt += cost;
				last = cost;
			}
		}
		
		System.out.println(cnt - last);
	}
	
	public static int find(int x) {
		if (x == parent[x]) {
			return x;
		}

		return parent[x] = find(parent[x]);
	}

	public static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x != y) {
			parent[y] = x;
		}
	}

}

class Road implements Comparable<Road>{
	
	int from;
	int to;
	int cost;
	
	public Road(int from, int to, int cost) {
		this.from = from;
		this.to = to;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(Road r) {
		return this.cost - r.cost;
	}
}
