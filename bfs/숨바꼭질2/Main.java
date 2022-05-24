import java.io.*;
import java.util.*;

public class Main {
	
	static int n,k,cnt,result,min;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		min = 99999999;
		BFS();
		
		System.out.println(result);
		System.out.println(cnt);
		
	}
	
	public static void BFS() {
		
		PriorityQueue <Node> pq = new PriorityQueue<>();
		pq.add(new Node(n, 0));
		
		int [] visited = new int [100001]; 
		Arrays.fill(visited, 999999999);
		visited[n] = 0;
		
		while(!pq.isEmpty()) {
			
			Node node = pq.remove();
			int cur = node.x;
			
			if(node.n > min)
				continue;
			
			if(cur == k) {
				
				if(visited[k] == node.n) {
					cnt++;
				}else if(visited[k] > node.n) {
					visited[k] = node.n;
					min = visited[k];
					cnt = 1;
				}
				continue;
			}else {
				if(visited[cur] > node.n)
					visited[cur] = node.n;
			}
		
			if(cur-1 >= 0) {
				if(cur-1 >= 0 && visited[cur-1] > node.n + 1) 
					pq.add(new Node(cur-1, node.n+1));
			}
			
			if(cur+1 <= 100000) {
				if(cur+1 <= 1000000 && visited[cur+1] > node.n+1) 
					pq.add(new Node(cur+1, node.n + 1));
			}
			
			if(cur * 2 <= 100000) {
				if(visited[cur * 2] > node.n+1)
					pq.add(new Node(cur*2, node.n + 1));
			}
		}
		
		result = visited[k];
	}
}

class Node implements Comparable<Node>{
	int x;
	int n;
	
	public Node(int x, int n) {
		this.x = x;
		this.n = n;
	}
	
	@Override
	public int compareTo(Node node) {
		return this.n - node.n;
	}
}
