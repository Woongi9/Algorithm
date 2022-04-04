import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m;
	static char [][] board;
	static int [][] count;
	static Queue<Dot> q = new LinkedList<>();
	static int [] move_x = {-1, 1, 0, 0};
	static int [] move_y = {0, 0, 1, -1};
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		board = new char [n][m];
		count = new int [n][m];
		
		for(int i = n-1; i>=0; i--)
		{
			String str = br.readLine();
			for(int j = 0; j<m; j++)
				board[i][j] = str.charAt(j);
		}
		
		count[n-1][0] = 1;
		Find(new Dot(n-1,0));
		bw.write(count[0][m-1] + "\n");
		
		bw.flush();
		bw.close();
	}
	
	static void Find(Dot dot) {
		
		q.clear();
		Dot tem = dot;
		q.add(tem);
		
		if(tem.x == n-1 && tem.y == m-1)
			return;
		
		board[tem.x][tem.y] = '0';
		
		while(!(tem.x == 0 && tem.y == m-1))
		{
			tem = q.remove();
			
			for(int i = 0; i < move_x.length; i++)
			{
				int new_x = tem.x + move_x[i];
				int new_y = tem.y + move_y[i];
				
				if(new_x>=0 && new_x<n && new_y >= 0 && new_y < m && board[new_x][new_y] == '1')
				{
					board[new_x][new_y] = '0';
					count[new_x][new_y] = count[tem.x][tem.y]+1;
					q.add(new Dot(new_x, new_y));
				}
 			}
		}
	}
}

class Dot{
	int x,y;

	public Dot(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

