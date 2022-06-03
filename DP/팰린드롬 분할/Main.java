import java.io.*;
import java.util.*;

public class Main{

	static int N;
	static int[] dp;
	static boolean[][] palindrome;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		N = str.length();
		str = "."+str;
		palindrome = new boolean[N+1][N+1];
		dp = new int[N+1]; // 1~i번째까지의 문자열에서 팰린드롬의 개수를 저장
		
        // str의 부분문자열에 대한 팰린드롬을 모두 체크한다.
		checkPalindrome(str);
		
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= i; j++) {
				if(palindrome[j][i]) dp[i]=Math.min(dp[i], dp[j-1]+1);
			}
		}
		System.out.println(dp[N]);
	}//end of main
	
	private static void checkPalindrome(String str) {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= i; j++) {
				boolean flag = true;
				int from = j;
				int to = i;
				while(from<=to) {
					if(str.charAt(from++) != str.charAt(to--)) {
						flag = false;
						break;
					}
				}
				if(flag) palindrome[j][i] = true;
			}
		}
	}
}//end of class
