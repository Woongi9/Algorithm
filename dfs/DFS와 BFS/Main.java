import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int n,m,start;
	static int [][] board;
	static int [] DFS_visited;
	static Queue<Integer> BFS_visited = new LinkedList<>();
	static ArrayList<Integer> BFS_visited_list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		
		board = new int [n][n];
		DFS_visited = new int [n];
		
		for(int i = 0 ; i < m; i++)
		{
			st = new StringTokenizer(br.readLine());
			int temx = Integer.parseInt(st.nextToken());
			int temy = Integer.parseInt(st.nextToken());
			board[temx-1][temy-1] = board[temy-1][temx-1] = 1;
		}
		
		
		DFS(start-1);
		System.out.println();
		BFS_visited.add(start-1);
		BFS_visited_list.add(start-1);
		BFS();
	}
	
	public static void DFS(int v) {
		
		System.out.print(v+1 + " ");
		DFS_visited[v] = 1;
		
		for(int i = 0; i < n; i++)
		{
			if(i != v)
			{
				if(board[v][i] == 1 && DFS_visited[i] != 1)
					DFS(i);
			}
		}
		
	}
	
	public static void BFS() {
	
		int x = 0;
		
		while(BFS_visited.size() != 0)
		{
			int v = BFS_visited.remove();
			System.out.print(v+1 + " ");
			for(int i = 0; i<n; i++)
			{
				if(i != v)
				{
					if(board[v][i] == 1 && BFS_visited_list.contains(i) != true)
					{
						BFS_visited.add(i);
						BFS_visited_list.add(i);
					}
				}
			}
		}
	}

}

