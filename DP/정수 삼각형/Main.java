import java.io.*;
import java.util.*;

public class Main {
	
	static int n, size;
	static int [] board;
	static int [] dp;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		for(int i = 1; i < n+1; i++) 
			size += i;
		
		dp = new int [size+1];
		board = new int [size+1];
		
		size = 0;
		
		for(int i = 1; i < n+1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j = 1; j <= i; j++) 
				board[size+j] = Integer.parseInt(st.nextToken());
			
			size += i;
		}
		
		dp[1] = board[1];
		int max = dp[1];
		
		int cnt = 0;
		size = 2;
		
		for(int i = 2; i < dp.length; i++) {

			if(cnt == 0) {
				//맨 왼쪽
				dp[i] = dp[i - (size-1)] + board[i];
				
			}else if(cnt == size-1){
				//맨 오른쪽
				dp[i] = dp[i - (size-1) - 1] + board[i]; 
			}else {
				//중간
				dp[i] = Math.max(dp[i-(size-1)-1], dp[i-(size-1)]) + board[i];
			}
			
			if(max < dp[i])
				max = dp[i];
			
			if(cnt == size-1) {
				cnt = 0;
				size++;
			}else {
				cnt++;
			}
		}
		
		System.out.println(max);
	}
}

