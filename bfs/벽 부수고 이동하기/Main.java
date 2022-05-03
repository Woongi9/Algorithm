import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int n,m, min;
	static int [] dx = {-1,0,0,1};
	static int [] dy = {0,-1,1,0};
	static int [][] board;
	static Queue<Dot> q = new LinkedList<>();

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		board = new int [n+1][m+1];
		
		for(int i = 0; i<n; i++) {
			char [] tem = br.readLine().toCharArray();
			for(int j = 0; j<m; j++) 
				board[i+1][j+1] = tem[j] - '0';
		}
		
		if(n == 1 && m == 1) {
			System.out.print(1);
			return;
		}
		
		min = 999999999;
		q.add(new Dot(1,1,1,false));
		bfs();
		
		if(min == 999999999)
			System.out.print(-1);
		else
			System.out.print(min);
		
	}
	
	public static void bfs() {
		
		int size = 1;
		int cycle = 1;
		boolean [][][] visited = new boolean [2][n+1][m+1];
		
		while(cycle <= size) {
			
			Dot d = q.remove();
			
			for(int i = 0; i<dx.length; i++) {
				int newx = d.x + dx[i];
				int newy = d.y + dy[i];
				
				if(newx > 0 && newx < n+1 && newy >0 && newy < m+1) {
					
					if(newx == n && newy == m) {
						min = d.cnt+1;
						return;
					}else if(board[newx][newy] == 0) {
						
						if(!d.chance && !visited[0][newx][newy]) {
							q.add(new Dot(newx, newy, d.cnt+1, d.chance));
							visited[0][newx][newy] = true;
						}else if(d.chance && !visited[1][newx][newy]){
							q.add(new Dot(newx, newy, d.cnt+1, d.chance));
							visited[1][newx][newy] = true;
						}
						
					}else {
						if(!d.chance) {
							visited[1][newx][newy] = true;
							q.add(new Dot(newx, newy, d.cnt+1, true));
						}
					}
					
				}
			}
			
			if(cycle == size) {
				size = q.size();
				cycle = 1;
			}else
				cycle++;
		}
	}
}

class Dot{
	int x,y,cnt;
	boolean chance;
	
	public Dot(int x, int y, int cnt, boolean chance) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
		this.chance = chance;
	}
}

