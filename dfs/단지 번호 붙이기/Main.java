import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int n,x,y;
	static char [][] board;
	static boolean [][] visited;
	static int [] dx = {-1,1,0,0};
	static int [] dy = {0,0,-1,1};
	static ArrayList<Integer> component = new ArrayList<>(); 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		board = new char [n][n];
		visited = new boolean [n][n];
		
		for(int i = 0 ; i < n; i++)
			board[i] = br.readLine().toCharArray();
		
		x = y = 0;
		
		while(x < n) {
			
			if(visited[x][y] != true) {
				if(board[x][y] == '1') { 
					component.add(1);
					DFS(x,y);
				}else
					visited[x][y] = true;
			}
			
			if(y+1 < n) {
				y++;
			}else if(y+1 == n) {
				y = 0;
				x++;
			}
		}
		
		Collections.sort(component);
		System.out.println(component.size());
		for(int i = 0 ; i < component.size(); i++)
			System.out.println(component.get(i));
	}
	
	public static void DFS (int x, int y) {
		
		if(visited[x][y] == false) {
			visited[x][y] = true;
			
			for(int i = 0; i < dx.length; i++) {
				int newx = x+dx[i];
				int newy = y+dy[i];
				
				if(newx >= 0 && newx < n && newy >= 0 && newy < n) {
					if(visited[newx][newy] == false && board[newx][newy] == '1') {
						component.set(component.size()-1, component.get(component.size()-1)+1);
						DFS(newx, newy);
					}else {
						visited[newx][newy] = true;
					}
				}
			}
		}
	}
}
