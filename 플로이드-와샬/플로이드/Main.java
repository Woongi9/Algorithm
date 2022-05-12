import java.io.*;
import java.util.*;

public class Main {
	
	static int n,m;
	static int [][] board;
	static ArrayList<Bus> [] busList;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		busList = new ArrayList [n+1];
		board = new int [n+1][n+1];
		
		for(int i = 1; i < n+1; i++) {
			busList[i] = new ArrayList<>();
			Arrays.fill(board[i], 99999999);
		}
		
		for(int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			busList[from].add(new Bus(to, cost));
		}
		
		for(int i = 1; i<n+1; i++) {
			board[i][i] = 0;
			dfs(i);
		}
		
		for(int i = 1; i<n+1; i++) {
			for(int j = 1 ; j<n+1; j++) 
				System.out.print(board[i][j] + " ");
			System.out.println();
		}
		
	}
	
	public static void dfs(int from) {
		
		PriorityQueue<Bus> pq = new PriorityQueue<>();
		pq.add(new Bus(from, 0));
		
		while(!pq.isEmpty()) {
			
			Bus b = pq.remove();
			int cur = b.cur;
			
			for(Bus tem : busList[cur]) {
				
				int to = tem.cur;
                
				if(b.cost + tem.cost < board[from][to] && to != from) {
					board[from][to] = b.cost + tem.cost;
					pq.add(new Bus(to, b.cost + tem.cost));
				}
			}
		}
        
        for(int i = 1; i < n+1; i++) {
			if(from != i) {
				if(board[from][i] == 99999999)
					board[from][i] = 0;
			}
		}
		
	}

}

class Bus implements Comparable<Bus>{
	int cur;
	int cost;
	
	public Bus(int cur, int cost) {
		this.cur = cur;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(Bus bus) {
		return this.cost - bus.cost;
	}
}
