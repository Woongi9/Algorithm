import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int n,m, mid1, mid2, min;
	static int max = 200000000;
	static ArrayList<Road> [] arrlist;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arrlist = new ArrayList [n+1];
		
		for(int i = 1; i<n+1; i++) 
			arrlist[i] = new ArrayList<>();
		
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			arrlist[f].add(new Road(t, cost));
			arrlist[t].add(new Road(f, cost));
			
		}
		
		st = new StringTokenizer(br.readLine());
		mid1 = Integer.parseInt(st.nextToken());
		mid2 = Integer.parseInt(st.nextToken());
		
		int tem1 = dfs(1,mid1) + dfs(mid1,mid2) + dfs(mid2, n);
		int tem2 = dfs(1,mid2) + dfs(mid2,mid1) + dfs(mid1, n);
		
		
		min = 0;
		
		if(tem1 >= max && tem2 >= max) min = -1;
		else min = Math.min(tem1, tem2);
		System.out.println(min);
	}
	
	public static int dfs(int start, int end) {
		
		PriorityQueue<Road> q = new PriorityQueue<>();
		q.offer(new Road(start, 0));
		
		int [] dist = new int[n+1];
		boolean [] visited = new boolean [n+1];
		Arrays.fill(dist, max);
		dist[start] = 0;
		
		while(!q.isEmpty()) {
			Road current = q.poll();
			
			if(!visited[current.end]) visited[current.end] = true;
			else continue;
			
			for(int i = 0; i < arrlist[current.end].size(); i++) {
				Road next = arrlist[current.end].get(i);
				if(!visited[next.end] && dist[next.end] > dist[current.end] + next.l) { + next.end);
					dist[next.end] = dist[current.end] + next.l;
					q.offer(new Road(next.end, dist[next.end]));
				}
			}
		}
		
		return dist[end];
	}
	
	public static class Road implements Comparable<Road>{
		int l;
		int end;
		
		public Road(int end, int l) {
			this.end = end;
			this.l = l;
		}
		
		@Override
		public int compareTo(Road n) {
			return this.l - n.l;
		}
	}
}

