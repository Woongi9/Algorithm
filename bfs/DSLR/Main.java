import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int testCase, a,b;
	static boolean [] visited;
	static Queue<Integer> q = new LinkedList<>();
	static Queue<String> result = new LinkedList<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		testCase = Integer.parseInt(br.readLine());
		
		for( int i = 0; i<testCase; i++) {
			visited = new boolean[10000];
			q.clear();
			result.clear();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			result.add("");
			q.add(a);
			
			BFS();
			sb.append(result.remove()).append("\n");
		}
		
		System.out.print(sb);
	}
	
	static void BFS() {
		
		while(!q.isEmpty()) {
			
			int tem = q.remove();
			
			if(tem == b)
				break;
			else if(tem < 0) {
			}
			else if(visited[tem])
				result.remove();
			else if(tem >= 0){
				
				visited[tem] = true;
				String str = result.remove();
				
				for(int i = 0; i < 4; i++) {
					//D
					if(i == 0) {
						if(!visited[tem*2%10000]) {
							q.add(tem*2%10000);
							result.add(str+"D");
						}
					}
					
					//S
					if(i == 1) {
						if(tem-1 < 0)
							q.add(9999);
						else
							q.add(tem-1);
						result.add(str+"S");
					}
					
					int x1000 = tem/1000;
					int newtem = tem % 1000;
					int x100 = newtem/100;
					newtem = newtem % 100;
					int x10 = newtem/10;
					newtem = newtem % 10;
					int x1 = newtem;
					
					//L
					if(i == 2) {
						q.add(x100 * 1000 + x10 * 100 + x1 * 10 + x1000);
						result.add(str+"L");
					}
					
					//R
					if(i == 3) {
						q.add(x1*1000 + x1000 * 100 + x100 * 10 + x10);
						result.add(str+"R");
					}
				}
			}
		}
	}
}
