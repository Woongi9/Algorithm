import java.io.*;
import java.util.*;

public class Main {
	
	static int n,m,max;
	static int [] dx = {-1,1,0,0};
	static int [] dy = {0,0,-1,1};
	static char [][] board;
	static HashSet<Character> set = new HashSet<>();

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		board = new char [n][m];
		
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			board[i] = str.toCharArray();
		}
		
		set.add(board[0][0]);
		DFS(0,0);
		
		System.out.println(max);
	}
	
	public static void DFS(int x, int y) {
		
		max = Math.max(max, set.size());
		
		for(int i = 0; i < dx.length; i++) {
			int newx = x + dx[i];
			int newy = y + dy[i];
			
			if(newx >= 0 && newx < n && newy >= 0 && newy < m) {
				
				if(!set.contains(board[newx][newy])) {
					set.add(board[newx][newy]);
					DFS(newx,newy);
					set.remove(board[newx][newy]);
				}
			}
		}
		
	}

}
