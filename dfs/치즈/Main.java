import java.io.*;
import java.util.*;

public class Main {
	
	static int n,m,sec, cnt1;
	static int [] dx = {-1, 0, 0, 1};
	static int [] dy = {0, -1, 1, 0};
	static int [][] board; 
	static int [][] count;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		board = new int [n+1][m+1];
		
		for(int i = 1; i < n+1; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 1; j < m+1; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] == 1)
					cnt1++;
			}
		}
		
		//모서리 0으로 확인
		//치즈를 찾는게 아니라 모서리 0에서 닿는 치즈 부분 카운
		
		while(cnt1 > 0) {
			count = new int [n+1][m+1];
			sec++;
			dfs(); 
		}
		
		System.out.println(sec);
	}
	
	public static void dfs() {
		
		Queue<Dot> q = new LinkedList<>();
		boolean [][] visited = new boolean [n+1][m+1];
		
		q.add(new Dot(1,1));
		visited[1][1] = true;
		
		while(!q.isEmpty()) {
			
			Dot d = q.remove();
			
			for(int i = 0; i < dx.length; i++) {
				int newx = d.x + dx[i];
				int newy = d.y + dy[i];
				
				if(newx > 0 && newx < n+1 && newy > 0 && newy < m+1) {
					
					if(board[newx][newy] == 1) {
						count[newx][newy] += 1;
					}else {
						if(!visited[newx][newy]) {
							visited[newx][newy] = true;
							q.add(new Dot(newx, newy));
						}
					}
				}
			}
		}
		
		//Check
		for(int i = 1; i < n+1; i++) {
			
			for(int j = 1; j<m+1; j++) {
				
				if(count[i][j] >= 2) {
					board[i][j] = 0;
					cnt1--;
				}
			}
		}
	}
}

class Dot{
	int x;
	int y;
	
	public Dot(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

