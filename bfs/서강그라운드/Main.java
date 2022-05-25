import java.io.*;
import java.util.*;

public class Main {
	
	static int n,m,r,max;
	static int [] city;
	static ArrayList<R> [] list;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		city = new int [n+1];
		list = new ArrayList [n+1];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i < n+1; i++) {
			city[i] = Integer.parseInt(st.nextToken());
			list[i] = new ArrayList<>();
		}
		
		for(int i = 1; i < r+1; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());
			
			list[start].add(new R(end, size));
			list[end].add(new R(start, size));
		}
		
		for(int i = 1; i < n+1; i++)
			max = Math.max(max, BFS(i));
		
		System.out.println(max);
	}
	
	public static int BFS(int x) {
		
		PriorityQueue<R> pq = new PriorityQueue<>();
		pq.add(new R(x,0));
		boolean [] visited = new boolean [n+1];
		int [] dist = new int [n+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[x] = 0;
		
		while(!pq.isEmpty()) {
			
			R r = pq.remove();
			
			int cur = r.cur;
			
			if(!visited[cur])
				visited[cur] = true;
			
			for(R road : list[cur]) {
				
				if(!visited[road.cur] && dist[road.cur] > dist[cur] + road.size) {
					dist[road.cur] = dist[cur] + road.size;
					pq.add(new R(road.cur, dist[road.cur]));
				}
			}
		}
		
		int res = 0;
		
		for(int i = 1; i<n+1; i++) {
			if(dist[i] < m+1)
				res += city[i];
		}
		
		return res;
	}

}

class R implements Comparable<R>{
	
	int cur;
	int size;
	
	public R(int cur, int size) {
		this.cur = cur;
		this.size = size;
	}
	
	@Override
	public int compareTo(R r) {
		return this.size - r.size;
	}
}
