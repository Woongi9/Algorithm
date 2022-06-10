import java.io.*;
import java.util.*;

public class Main {
	
	static int n,m;
	static int [] cnt;
	static ArrayList<Integer>[] list;
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		cnt = new int [n+1];
		
		list = new ArrayList [n+1];
		
		for(int i = 1; i < n+1; i++)
			list[i] = new ArrayList<>();
		
		for(int i = 0; i < m ; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			cnt[y]++;
			list[x].add(y);
		}
		
		for(int i = 1; i < n+1; i++) {
			if(cnt[i] == 0) {
				pq.add(i);
			}
		}
		
		while(!pq.isEmpty()) {
			
			int tem = pq.remove();
			
			System.out.print(tem + " ");
			
			for(int i = 0; i < list[tem].size(); i++) {
				int x = list[tem].get(i);
				cnt[x]--;
				
				if(cnt[x] == 0)
					pq.add(x);
			}
		}
	}
	
}
