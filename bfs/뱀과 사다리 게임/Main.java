import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
	
	static int n,m, cnt;
	static int [] board = new int [101];
	static Queue<Integer> q = new LinkedList<>();
	static boolean [] visited = new boolean [101];

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i<n+m; i++) {
			st = new StringTokenizer(br.readLine());
			int input = Integer.parseInt(st.nextToken());
			int output = Integer.parseInt(st.nextToken());
			
			board[input] = output;
		}
		
		cnt = 0;
		q.add(1);
		visited[1] = true;
		BFS();
		
		System.out.print(cnt);
	}
	
	public static void BFS() {
		
		while(!q.isEmpty()) {
			
			int cir = q.size();
			cnt++;
			
			for(int k = 0; k<cir; k++) {
				
				n = q.remove();
				
				for(int i = 1; i<7; i++) {
					
					int newn;
					
					if(board[n+i] != 0)
						newn = board[n+i];
					else
						newn = n + i;
					
					if(newn == 100)
						return;
					else if(newn > 0 && newn < 100 && !visited[newn]) {
						q.add(newn);
						visited[newn] = true;
					}
				}
			}
		}
	}
}

