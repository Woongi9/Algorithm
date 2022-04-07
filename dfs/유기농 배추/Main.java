import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int T, M, N, K, x, y, count;
	static int [] dx = {-1, 1, 0, 0};
	static int [] dy = {0, 0, -1, 1};
	static int [] Count;
	static int [][] board;
	static int [][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		Count = new int [T];
		
		StringTokenizer st;
		
		for(int i = 0 ; i < T; i++)
		{
			count = 0;
			st = new StringTokenizer(br.readLine());
			
			M = Integer.parseInt(st.nextToken());
			if(M < 1 || M > 50)
				return;
			N = Integer.parseInt(st.nextToken());
			if(N < 1 || N > 50)
				return;
			K = Integer.parseInt(st.nextToken());
			if(K < 1 || K > 2500)
				return;
			
			board = new int [M][N];
			visited = new int [M][N];
			
			for(int j = 0 ; j < K; j++)
			{
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				
				if(x < 0 || x > M-1 || y < 0 || y > N-1)
					return;
			
				board[x][y] = 1;
			}
			
			for(int a = 0; a<M; a++)
			{
				for(int b = 0; b<N; b++)
				{
					if(board[a][b] == 1 && visited[a][b] != 1)
					{
						count++;
						bfs(a,b);
					}
				}
			}
			Count[i] = count;
		}
		
		for(int i = 0; i < T; i++)
			System.out.println(Count[i]);
	}
	
	
	public static void bfs(int inx, int iny) {
		
		visited[inx][iny] = 1;
		
		for(int i = 0 ; i < dx.length; i++)
		{
			int newx = inx + dx[i];
			int newy = iny + dy[i];
			
			if(newx >= 0 && newx < M && newy >= 0 && newy < N
					&& visited[newx][newy] != 1 && board[newx][newy] == 1)
				bfs(newx,newy);
		}
	}
}

