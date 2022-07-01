import java.io.*;
import java.util.*;

public class Main {
	
	static int n, cnt;
	static int [] board;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		board = new int [n+1];
		
		Make1();
		
		System.out.println(cnt);
		System.out.println(sb);
	}
	
	public static void Make1() {
		
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		
		while(!q.isEmpty()) {
			
			int x = q.remove();
			
			if(x == 1)
				break;
			
			if(x % 3 == 0) {
				if(board[x/3] == 0) {
					board[x/3] = x;
					q.add(x/3);
				}
			}
			if(x % 2 == 0) {
				if(board[x/2] == 0) {
					board[x/2] = x;
					q.add(x/2);
				}
			}
			
			if(board[x-1] == 0) {
				board[x-1] = x;
				q.add(x-1);
			}
		}
		
		int tem = 1;
		Stack<Integer> stack = new Stack<>();
		stack.add(tem);
		while(tem < n) {
			cnt++;
			tem = board[tem];
			stack.add(tem);
		}
		
		while(!stack.isEmpty()) 
			sb.append(stack.pop()).append(" ");
		
	}

}
