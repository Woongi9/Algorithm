import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int n,m,cnt_day, cnt;
	static int [] dx = {-1,1,0,0};
	static int [] dy = {0,0,-1,1};
	static int [][] board;
	static boolean [][] visited;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		board = new int [m][n];
		visited = new boolean [m][n];
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int x, y;
		x = y = cnt = cnt_day = 0;
		
		Queue<Integer> qx = new LinkedList<>();
		Queue<Integer> qy = new LinkedList<>();
		
		for(int i = 0; i<m; i++) {
			for(int j = 0; j<n; j++) {
				if(board[i][j] == 1) {
					qx.add(i);
					qy.add(j);
					visited[i][j] = true;
					cnt++;
				}
			}
		}
		
		DFS(qx, qy);
		
		for(int i = 0 ; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(board[i][j] == 0)
					cnt_day = 0;
			}
		}
		
		System.out.println(cnt_day-1);
	}
	
	public static void DFS (Queue<Integer> qx, Queue<Integer> qy) {
		
		while(!qx.isEmpty()) {
			
			int tem = qx.size();
			
			for(int k = 0; k < tem; k++) {
			
				int x = qx.remove();
				int y = qy.remove();
			
				for(int i = 0 ; i < dx.length; i++) {
				
					if(x+dx[i] >= 0 && x+dx[i] < m && y+dy[i] >= 0 && y+dy[i] < n) {
						
						if(visited[x + dx[i]][y + dy[i]] == false)
							cnt++;
								
						if(board[x + dx[i]][y + dy[i]] == 0) {
							board[x + dx[i]][y + dy[i]] = 1;
							qx.add(x+dx[i]);
							qy.add(y+dy[i]);	
						}
						visited[x + dx[i]][y + dy[i]] = true;
					}
				}
			}
			cnt_day++;
		}
	}
}

