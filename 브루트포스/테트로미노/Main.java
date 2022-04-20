import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n,m, max;
	static int [][] dx = {{0,0,0,0}, {0,1,2,3}, {0,0,1,1}, {0,1,2,2}, {0,0,0,-1}, {0,0,1,2}, {0,1,0,0}, {0,1,1,2}, {0,0,1,1}, {0,1,0,0}, {0,0,1,-1}, {0,-1,0,0}, {0,0,1,-1}, {0,0,-1,1}, {0,0,1,1}, {0,0,-1,-2}, {0,0,0,1}, {0,1,2,0}, {0,-1,0,0}};
	static int [][] dy = {{0,1,2,3}, {0,0,0,0}, {0,1,0,1}, {0,0,0,1}, {0,1,2,2}, {0,1,1,1}, {0,0,1,2}, {0,0,1,1}, {0,1,0,-1}, {0,0,1,-1}, {0,1,0,0}, {0,0,1,-1}, {0,-1,0,0}, {0,1,1,0}, {0,-1,0,1}, {0,1,1,1}, {0,-1,-2,0}, {0,0,0,1}, {0,0,1,2}};
	static int [][] board;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		board = new int [n][m];
		
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<m; j++) 
				board[i][j] = Integer.parseInt(st.nextToken());
		}
		
		max = 0;
		
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				Check(i,j);
			}
		}
		
		System.out.print(max);
		
	}
	
	public static void Check(int x, int y) {
		
		for(int i = 0; i<dx.length; i++) {
			int cnt = 0;
			for(int j = 0; j<dx[0].length; j++) {
				int newx = x + dx[i][j];
				int newy = y + dy[i][j];
				
				if(newx >= 0 && newx < n && newy >= 0 && newy < m) 
					cnt += board[newx][newy];
				else
					j = dx[0].length;
			}
			max = Math.max(max, cnt);
		}
	}
}
