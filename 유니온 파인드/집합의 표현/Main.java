import java.io.*;
import java.util.*;

public class Main {
	
	static int n,m;
	static int [] board;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		board = new int [n+1];
		
		for(int i = 0; i<n+1; i++)
			board[i] = i;
		
		for(int i = 0; i < m; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			int check = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			if(check == 0) {
				Union(x,y);
			}else if(check == 1){
				UnionFind(x,y);
			}
			
		}
		System.out.print(sb);
		
	}
	public static int Find(int i) {
		if(board[i] == i)
			return i;
		
		return board[i] = Find(board[i]);
	}
	
	public static void Union(int x, int y) {
		
		x = Find(x);
		y = Find(y);
		
		if(x != y) {
			if(x<y)
				board[y] = x;
			else
				board[x] = y;
		}
	}
	
	public static void UnionFind(int x, int y) {
		
		x = Find(x);
		y = Find(y);
		
		if(x == y) {
			sb.append("YES").append("\n");
			return;
		}
		
		sb.append("NO").append("\n");
		
	}
}
