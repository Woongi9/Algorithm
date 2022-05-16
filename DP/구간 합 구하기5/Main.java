import java.io.*;
import java.util.*;

public class Main {
	
	static int n,m;
	static int [][] dp;
	static ArrayList<Dot> start = new ArrayList<>();
	static ArrayList<Dot> end = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		dp = new int [n+1][n+1];
		
		for(int i = 1; i < n+1; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 1; j < n+1; j++)
				dp[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			start.add(new Dot(x1, y1));
			end.add(new Dot(x2, y2));
		}
		
		//dp 저장
		for(int i = 1; i < n+1; i++) {
			for(int j = 2; j<n+1; j++)
				dp[i][j] += dp[i][j-1];
		}
		
		//계산
		for(int i = 0; i < m; i++) {
			int x1 = start.get(i).x;
			int y1 = start.get(i).y;
			
			int x2 = end.get(i).x;
			int y2 = end.get(i).y;
			
			int cnt = 0;
			
			for(int k = x1; k <= x2; k++) {
				cnt += dp[k][y2];
				
				if(y1 > 1)
					cnt -= dp[k][y1-1];
			}
			
			sb.append(cnt).append("\n");
		}
			
		
		System.out.print(sb);
		
	}

}

class Dot{
	int x;
	int y;
	
	public Dot(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
