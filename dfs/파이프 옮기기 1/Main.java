import java.io.*;
import java.util.*;

public class Main {
	
	static int n, cnt;
	static int [][] board;
	static int [][][] move = 
		{{{0,1},{1,1}},
			{{1,0},{1,1}},
			{{0,1},{1,0},{1,1}}};

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		board = new int [n+1][n+1];
		
		for(int i = 1; i<n+1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j = 1; j<n+1; j++) 
				board[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int [] end = {1,2};
		DFS(end, 0);
		
		System.out.println(cnt);
	}
	
	public static void DFS(int [] end, int x) {
		
		if(end[0] == n && end[1] == n) {
			cnt++;
			return;
		}
		
		if(x == 0) {
			//이전 가로
			
			for(int i = 0; i < 2; i++) {
				int newx = end[0] + move[0][i][0];
				int newy = end[1] + move[0][i][1];
				
				if(newx > 0 && newx < n+1 && newy > 0 && newy < n+1) {
					int [] newEnd = new int [2];
					newEnd[0] = newx;
					newEnd[1] = newy;
					if(i == 0 && board[newx][newy] == 0) {
						DFS(newEnd, 0);
					}else if(i == 1 && board[newx][newy] == 0
							&& board[newx][newy-1] == 0
							&& board[newx-1][newy] == 0)
						DFS(newEnd, 2);
				}
			}
			
		}else if(x == 1) {
			//이전 세로
			
			for(int i = 0; i < 2; i++) {
				int newx = end[0] + move[1][i][0];
				int newy = end[1] + move[1][i][1];
				
				if(newx > 0 && newx < n+1 && newy > 0 && newy < n+1
						&& board[newx][newy] == 0) {
					int [] newEnd = new int [2];
					newEnd[0] = newx;
					newEnd[1] = newy;
					if(i == 0 && board[newx][newy] == 0) {
						DFS(newEnd, 1);
					}else if(i == 1 && board[newx][newy] == 0
							&& board[newx][newy-1] == 0
							&& board[newx-1][newy] == 0)
						DFS(newEnd, 2);
				}
			}
			
		}else if(x == 2) {
			//이전 대각
			
			for(int i = 0; i < 3; i++) {
				int newx = end[0] + move[2][i][0];
				int newy = end[1] + move[2][i][1];
				
				if(newx > 0 && newx < n+1 && newy > 0 && newy < n+1
						&& board[newx][newy] == 0) {
					int [] newEnd = new int [2];
					newEnd[0] = newx;
					newEnd[1] = newy;
					if(i == 0 && board[newx][newy] == 0) {
						DFS(newEnd, 0);
					}else if(i == 1 && board[newx][newy] == 0) {
						DFS(newEnd, 1);
					}else if(i == 2 && board[newx][newy] == 0
							&& board[newx][newy-1] == 0
							&& board[newx-1][newy] == 0)
						DFS(newEnd, 2);
				}
			}
		}
		
	}

}
