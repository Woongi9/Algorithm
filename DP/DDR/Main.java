import java.io.*;
import java.util.*;

public class Main {
	
	static int n;
	static int dp [][][];
	static ArrayList<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		while(st.hasMoreTokens()) {
			int tem = Integer.parseInt(st.nextToken());
			if(tem != 0)
				list.add(tem);
		}
		
		n = list.size();
		dp = new int [n+1][5][5];
		
		int answer = DDR(0,0,0);
		
		System.out.println(answer);
	}
	
	public static int DDR(int step, int l, int r) {
		
		if(step == n) 
			return 0;
		
		if(dp[step][l][r] != 0) 
			return dp[step][l][r];
		
		int lscore = Score(l, list.get(step)) + DDR(step + 1 , list.get(step), r);
		int rscore = Score(r, list.get(step)) + DDR(step + 1 , l, list.get(step));
		
		return dp[step][l][r] = Math.min(lscore, rscore);
	}
	
	static int Score(int from, int to) {
		if(from == to) return 1;
		if(from == 0) return 2;
		if(Math.abs(from - to) == 2) return 4;
		
		return 3;
	}

}
