import java.io.*;
import java.util.*;

public class Main {
	
	static int n,k;
	static int [] board;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		board = new int [100001];
		board[n] = 1;
		
		Search();
			
		System.out.println(board[k] - 1);
			
	}
	
	public static void Search() {
		
		PriorityQueue<D> pq = new PriorityQueue<>();
		pq.add(new D(n, 1));
		board[n] = 1;
		
		while(!pq.isEmpty()) {
			
			D d = pq.remove();
			
			if(d.x + 1 >= 0 && d.x+1 <= 100000) {
				if(board[d.x+1] == 0 || board[d.x+1] > d.v + 1) {
					board[d.x+1] = d.v+1;
					pq.add(new D(d.x +1, d.v +1));
				}
			}
			
			if(d.x - 1 >= 0 && d.x-1 <= 100000) {
				if(board[d.x-1] == 0 || board[d.x-1] > d.v + 1) {
					board[d.x-1] = d.v+1;
					pq.add(new D(d.x-1, d.v +1));
				}
			}
			
			if(d.x*2 > 0 && d.x*2 <= 100000) {
				if(board[d.x*2] == 0 || board[d.x*2] > d.v) {
					board[d.x*2] = d.v;
					pq.add(new D(d.x*2, d.v));
				}
			}
			
		}
		
	}
}

class D implements Comparable<D>{
	int x;
	int v;
	
	public D(int d, int y) {
		this.x = d;
		this.v = y;
	}
	
	@Override
	public int compareTo(D d) {
		return this.v - d.v;
	}
}

