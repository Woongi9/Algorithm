import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
	
	static int n,m,cnt,known, partySize;
	static boolean [][] partyCheckList;
	static boolean [] visited; 
	static Queue<Integer> q = new LinkedList<>();
	static Queue<Integer> partyQ = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		partyCheckList = new boolean [n+1][m+1];
		visited = new boolean [m+1];
		
		st = new StringTokenizer(br.readLine());
		
		if(st.countTokens() > 1) {
			
			known = Integer.parseInt(st.nextToken());
			
			for(int i = 0; i < known; i++) 
				q.add(Integer.parseInt(st.nextToken()));
			
		}else 
			known = 0;
		
		cnt = 0;
		
		//파티 리스트 2차원 구
		for(int i = 0; i < m; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			partySize = Integer.parseInt(st.nextToken());
			
			for(int j = 0; j < partySize; j++) {
				
				int tem = Integer.parseInt(st.nextToken());
				partyCheckList[tem][i+1] = true;
			}
		}
		
		//진실을 아는 파티 bfs 등록
		if(!q.isEmpty()) {
			
			while(!q.isEmpty()) {
				
				int tem = q.remove();
				
				for(int j = 1; j<m+1; j++) {
					
					if(partyCheckList[tem][j]) {
						partyQ.add(j);
						visited[j] = true;
					}
				}
			}
		}
		
		bfs();
		
		for(int i = 1; i < visited.length; i++) {
			if(!visited[i]) 
				cnt++;
		}
			
		
		System.out.print(cnt);
	}
	
	public static void bfs() {
		
		while(!partyQ.isEmpty()) {
			
			int knownParty = partyQ.remove();
			
			for(int i = 1; i<=n; i++) {
				if(partyCheckList[i][knownParty]) {
					
					for(int j = 1; j<=m; j++) {
						if(partyCheckList[i][j] && !visited[j]) {
							partyQ.add(j);
							visited[j] = true;
						}
					}
				}
			}
		}
	}
}

