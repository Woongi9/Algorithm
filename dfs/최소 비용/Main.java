import java.io.*;
import java.util.*;

public class Main {
	
	static int n,m,start,end;
	static int min;
	static int [] dist;
	static ArrayList<Road> [] city;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		city = new ArrayList [n+1];
		dist = new int [n+1];
		Arrays.fill(dist, 999999999);
		
		for(int i = 1; i < n+1; i++)
			city[i] = new ArrayList <>();
		
		StringTokenizer st;
		
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			
			city[from].add(new Road(to, cost));
		}
		
		st = new StringTokenizer(br.readLine());
		
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		dfs(start);
		
		System.out.println(dist[end]);
	}
	
	public static void dfs(int start){
		
		PriorityQueue<Road> pq = new PriorityQueue<>();
	
		boolean [] visited = new boolean [n+1];
		
		Road road = new Road(start, 0);
		dist[start] = 0;
		
		pq.add(road);
		
		while(!pq.isEmpty()) {
			
			Road r = pq.remove();
			int cur = r.toCity;
			
			if(!visited[cur]) {
				
				visited[cur] = true;
			
				for(int i = 0; i < city[cur].size(); i++) {
				
					Road tem = city[cur].get(i);
					
					if(!visited[tem.toCity] && dist[tem.toCity] > dist[cur] + tem.cost) {	
						dist[tem.toCity] = dist[cur] + tem.cost;
						pq.add(new Road(tem.toCity, dist[tem.toCity]));
					}
				}
			}
		}
	}
}

class Road implements Comparable<Road>{
	int toCity;
	int cost;
	
	public Road(int city, int cost) {
		this.toCity = city;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(Road r) {
		return this.cost - r.cost;
	}
}

