import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n, cnt0, cnt1, cnt2; 
	static int [] judge = {0,0,0};
	static int [][] board;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		board = new int [n][n];
		cnt0 = 0;
		cnt1 = 0;
		cnt2 = 0;
		
		StringTokenizer st;
		
		for(int i = 0 ; i < n; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < n; j++) 
				board[i][j] = Integer.parseInt(st.nextToken());
		}
		
		DFS(n,0,0);
		
		System.out.println(cnt2);
		System.out.println(cnt0);
		System.out.println(cnt1);
	}
	
	public static void DFS(int size, int xfirst, int yfirst) {
		
		int tem = board[xfirst][yfirst];
		boolean same = true;
		
		for(int i = 0; i < size; i++)
		{
			for(int j = 0; j < size; j++)
			{
				if(board[xfirst + i][yfirst + j] != tem) {					
					same = false;
					j = size;
					i = size;
				}else {
					
				}
			}
		}
		
		if(same) {
			if(tem == 0)
				cnt0++;
			else if(tem == 1)
				cnt1++;
			else
				cnt2++;
			
			return;
		}else {
			DFS(size/3,xfirst, yfirst);
			DFS(size/3,xfirst, yfirst+size/3);
			DFS(size/3,xfirst, yfirst+size/3*2);
			DFS(size/3,xfirst+size/3, yfirst);
			DFS(size/3,xfirst+size/3, yfirst+size/3);
			DFS(size/3,xfirst+size/3, yfirst+size/3*2);
			DFS(size/3,xfirst+size/3*2, yfirst);
			DFS(size/3,xfirst+size/3*2, yfirst+size/3);
			DFS(size/3,xfirst+size/3*2, yfirst+size/3*2);
		}
	}

}
