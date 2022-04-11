import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int n,k,cnt,tem1,tem2,tem3;
	static int [] visited = new int [100001];
	static Queue<Integer> q = new LinkedList<>();
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		cnt = 0;
		
		if(n >= k)
			System.out.print(n-k);
		else {
			q.add(n);
			visited[n] = 1;
			
			BFS();
			System.out.println(cnt);
		}
	}
	
	public static void BFS() {
		
		while(true) {
			cnt++;
			
			for(int i = q.size(); i > 0; i--)
			{
				int tem = q.remove();
				tem1 = tem+1;
				tem2 = tem-1;
				tem3 = tem*2;
				
				if(tem1 >= 0 && tem1 <= 100000)
				{
					if(tem1 == k)	return;
					else if(visited[tem1] != 1)
					{
						visited[tem1] = 1;
						q.add(tem1);
					}
				}
				
				if(tem2 >= 0 && tem2 <= 100000)
				{
					if(tem2 == k)	return;
					else if(visited[tem2] != 1){
						visited[tem2] = 1;
						q.add(tem2);
					}
				}

				if(tem3 >= 0 && tem3 <= 100000)
				{
					if(tem3 == k)	return;
					else if(visited[tem3] != 1){
						visited[tem3] = 1;
						q.add(tem3);
					}
				}
			}
		}
	}
}

