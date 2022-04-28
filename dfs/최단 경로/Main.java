import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int n, e, start;
	static int [] cnt;
	static ArrayList<Line> [] arrlist;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		start = Integer.parseInt(br.readLine());
		
		cnt = new int [n+1];
		
		arrlist = new ArrayList [n+1];
		
		for(int i = 1; i < n+1; i++) {
			arrlist[i] = new ArrayList<>();
			cnt[i] = 999999999;
		}
		
		
		for(int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());
			
			arrlist[start].add(new Line(end,size));
		}
		
		dfs(start);
		
		for(int i = 1; i < n+1; i++) {
			if(cnt[i] == 999999999)
				System.out.println("INF");
			else
				System.out.println(cnt[i]);
		}
		
	}
	
	public static void dfs(int start) {
		
		PriorityQueue<Line> pq = new PriorityQueue<>();
		
		boolean [] visited = new boolean[n+1];
		
		pq.add(new Line(start, 0));
		cnt[start] = 0;
		
		while(!pq.isEmpty()) {
			Line currentLine = pq.remove();
			
			int current = currentLine.d;
			
			if(!visited[current]) {
				visited[current] = true;
				
				for(int i = 0; i<arrlist[current].size(); i++) {
					if(cnt[arrlist[current].get(i).d] > cnt[current] + arrlist[current].get(i).size	) {
						cnt[arrlist[current].get(i).d] = cnt[current] + arrlist[current].get(i).size;
						pq.add(new Line(arrlist[current].get(i).d, cnt[arrlist[current].get(i).d]));
					}
				}
			}		
		}	
	}
}

class Line implements Comparable<Line>{
	int d;
	int size;
	
	public Line(int d, int size) {
		this.d = d;
		this.size = size;
	}
	
	@Override
	public int compareTo(Line l) {
		return size - l.size;
	}
}

