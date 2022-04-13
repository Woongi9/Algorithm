import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n,cnt0,cnt1;
	static int [][]board;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		n = Integer.parseInt(br.readLine());
		board = new int [n][n];
		
		StringTokenizer st;
		
		for(int i = 0; i < n; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++)
				board[i][j] = Integer.parseInt(st.nextToken());
		}
		
		cnt0 = cnt1 = 0;
		DFS(n,0,0);
		System.out.println(cnt0);
		System.out.println(cnt1);
	}
	
	public static void DFS(int size, int x, int y) {
		
		int tem = board[x][y];
		boolean same = true;
		
		for(int i = 0 ; i < size; i++) {
			for(int j = 0 ; j < size; j++) {
				if(board[i+x][j+y] != tem) {
					same = false;
					i = size;
					j = size;
				}
			}
		}
		
		if(same == true) {
			if(tem == 0)
				cnt0++;
			else
				cnt1++;
		}else {
			DFS(size/2, x, y);
			DFS(size/2, x, y+size/2);
			DFS(size/2, x+size/2, y);
			DFS(size/2, x+size/2, y+size/2);
		}	
	}
}

