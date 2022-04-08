import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, m, cnt, min, cycle, winner;
	static int [][] board;
	static Queue<Integer> q = new LinkedList<>();
	static ArrayList<Integer> visited = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		board = new int [n][n];
		
		for(int i = 0; i < m; i++)
		{
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			board[x-1][y-1] = board[y-1][x-1] = 1;
		}
		
		min = 100;
		winner = 101;
		
		for(int i = 0 ; i < n; i++)
		{
			visited.clear();
			q.clear();
			visited.add(i);
			q.add(i);
			cnt = 0;
			cycle = 0;
			
			DFS();
            
			if(min != cnt && Math.min(cnt, min) == cnt)
			{
				winner = i;
				min = cnt;
			}
		}
		
		System.out.print(winner+1);
	}
	
	public static void DFS() {
		
		cycle++;
		int limit = q.size();
		
		for(int x = 0; x < limit; x++)
		{
			int temp = q.remove();
			
			for(int i = 0 ; i < n; i++)
			{
				if(temp != i)
				{
					if(board[temp][i] == 1 && visited.contains(i) != true)
					{
						q.add(i);
						visited.add(i);
						cnt += cycle;
					}
				}
			}
		}
		
		if(visited.size() < n)
			DFS();
		
	}

}

