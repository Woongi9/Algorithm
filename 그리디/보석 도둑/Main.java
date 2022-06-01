import java.io.*;
import java.util.*;

public class Main {
	
	static int n,k;
	static long max;
	static ArrayList<P> w = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		int [] bag = new int [k];
		
		for(int i = 1; i < n+1; i++	) {
			
			st = new StringTokenizer(br.readLine());
			
			int m = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			w.add(new P(m,v));
		}
		
		for(int i = 0; i < k; i++) {
			bag[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(bag);
		Collections.sort(w);
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		
		for(int i = 0, j = 0; i < k; i++) {
			while(j < n && w.get(j).m <= bag[i]) {
				pq.offer(w.get(j++).v);
			}
			
			if(!pq.isEmpty())
				max += pq.poll();
		}
		
		System.out.println(max);
		
	}
}

class P implements Comparable<P>{
	
	int m;
	int v;
	
	public P(int m, int v) {
		this.m = m;
		this.v = v;
	}
	
	@Override
	public int compareTo(P p) {
		return this.m - p.m;
	}
}
