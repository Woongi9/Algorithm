import java.io.*;
import java.util.*;

public class Main {
	
	static Long a,b;
	static int cnt;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		a = (long) Integer.parseInt(st.nextToken());
		b = (long) Integer.parseInt(st.nextToken());
		
		cnt = -1;
		bfs(a);
		
		System.out.println(cnt);
		
	}
	
	public static void bfs(long x) {
		
		PriorityQueue<N> pq = new PriorityQueue<>();
		pq.add(new N(x,1));
		
		while(!pq.isEmpty()) {
			
			N n = pq.remove();
			
			if(n.cur == b) {
				cnt = n.cnt;
				return;
			}
			
			if(n.cur * 2 <= b)
				pq.add(new N(n.cur * 2, n.cnt+1));
			if(n.cur * 10 + 1 <= b)
				pq.add(new N(n.cur * 10 + 1, n.cnt+1));
			
		}
		
	}

}

class N implements Comparable<N>{
	long cur;
	int cnt;
	
	public N(long cur, int cnt) {
		this.cur = cur;
		this.cnt = cnt;
	}
	
	@Override
	public int compareTo(N N1) {
		return this.cnt - N1.cnt;
	}
}
