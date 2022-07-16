import java.io.*;
import java.util.*;

public class Main {
	
	static int n,m,cnt = 1;
	static boolean merge;
	static char [][] board;
	static int [][] component;
	static boolean [][] visited;
	static HashMap<Character, int []> map = new HashMap<>();

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		board = new char [n][m];
		component = new int [n][m];
		visited = new boolean [n][m];
		
		for(int i = 0 ; i < n; i++) {
			String str = br.readLine();
			board[i] = str.toCharArray();
		}
		
		map.put('L', new int [] {0,-1});
		map.put('R', new int [] {0,1});
		map.put('D', new int [] {1,0});
		map.put('U', new int [] {-1,0});
		
		for(int i = 0; i < n; i++	) {
			for(int j = 0; j < m; j ++) {
				if(component[i][j] == 0) {
					merge = false;
					UnionFind(i,j);
				}
			}
		}
		
		System.out.println(cnt-1);

	}
	
	public static int Find(int x, int y) {
		
		char tem = board[x][y];
		int [] arr = map.get(tem);
		int com = 0;
		
		int newx = x + arr[0];
		int newy = y + arr[1];
		
		visited[x][y] = true;
		
		if(visited[newx][newy]) {
			if(component[newx][newy] == 0) {
				component[x][y] = cnt;
				cnt++;
				return cnt-1;
			}else {
				component[x][y] = component[newx][newy];
				return component[newx][newy];
			}
		}else {
			com = Find(newx, newy);
			component[x][y] = com;
		}
		
		return com;
		
	}
	
	public static void UnionFind(int x, int y) {
		Find(x,y);
	}

}

