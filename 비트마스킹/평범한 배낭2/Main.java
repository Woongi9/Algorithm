import java.io.*;
import java.util.*;

public class Main {
	
	static int n,m;
	static int [][] dp;
	static ArrayList<int []> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < n; i ++) {
			
			st = new StringTokenizer(br.readLine());
			
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int count = Integer.parseInt(st.nextToken());
			
			for(int j = 0 ; count > 0; j++) { //비트마스킹으로 저장
				
				int tmp = Math.min(count, 1<<j);
				int cw = tmp * w;
				int cv = tmp * v;
				
				list.add(new int[] {cw, cv});
				count -= tmp;
			}
		}
		
		// 배낭 문제
		int curN = list.size();
		dp = new int [curN +1][m+1];
		
		for(int i = 1; i <= curN; i++) {
			for(int j = 1; j <= m; j++) {
				if(j >= list.get(i-1)[0]) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - list.get(i-1)[0]] + list.get(i-1)[1]);
				}else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		
		System.out.println(dp[curN][m]);
	}

}
