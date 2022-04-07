import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N,r,c,cnt;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		cnt = 0;
		
		DFS(N,0,0);
		
		System.out.print(cnt);
	}
	
	public static void DFS(int n, int x, int y) {
		
		if(n-1 < 0)
			return;
		
		int midx = x + (int)Math.pow(2, n-1);
		int midy = y + (int)Math.pow(2, n-1);
		
		if(r >= midx)
		{
			cnt += 2*(int)Math.pow((int)Math.pow(2, n-1), 2);
			if(c >= midy) {
				cnt += (int)Math.pow((int)Math.pow(2, n-1), 2);
				DFS(n-1,midx,midy);
			}else {
				DFS(n-1,midx,y);
			}
		}else {
			if(c >= midy){
				cnt += (int)Math.pow((int)Math.pow(2, n-1), 2);
				DFS(n-1, x, midy);
			}else {
				DFS(n-1, x, y);
			}
		}
	}
}

