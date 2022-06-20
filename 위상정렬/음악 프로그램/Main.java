import java.io.*;
import java.util.*;

public class Main {
	
	static int n,m;
	static int [] cnt;
	static int [] ans;
	static ArrayList<Integer> [] list;
	static PriorityQueue<Integer> pq = new PriorityQueue<>();

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		cnt = new int [n+1];
		ans = new int [n+1];
		list = new ArrayList [n+1];
		
		for(int i = 1; i < n+1; i++) 
			list[i] = new ArrayList<>();
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int tem = Integer.parseInt(st.nextToken());
			int prev = Integer.parseInt(st.nextToken());
			
			for(int j = 1; j < tem; j++) {
				int next = Integer.parseInt(st.nextToken());
				
				cnt[next]++;
				list[prev].add(next);
				prev = next;
			}
		}
		
		for(int i = 1; i < cnt.length; i++) {
			if(cnt[i] == 0) 
				pq.add(i);
		}
		
		int in = 1;
		
		while(!pq.isEmpty()) {
			
			int x = pq.remove();
			ans[in] = x;
			
			for(int num : list[x]) {
				cnt[num]--;
				if(cnt[num] == 0)
					pq.add(num);
			}
			
			in++;
		}
		
		if(in != ans.length)
			System.out.println(0);
		else {
			for(int i = 1; i < ans.length; i++)
				System.out.println(ans[i]);
		}
	}

}
