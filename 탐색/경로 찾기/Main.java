import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int [][] N;
	static int [][] result;
	static Queue<Integer> q = new LinkedList<>();
	static HashSet<Integer> visited = new HashSet<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		N = new int [n][n];
		result = new int [n][n];
		
		for(int i = 0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<n; j++) 
				N[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i<n; i++) {
			q.clear();
			visited.clear();
			for(int j = 0; j<n; j++) {
				if(N[i][j] == 1) {
					q.add(j);
					visited.add(j);
				}
			}
			DFS(i);
		}
		
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) 
				System.out.print(N[i][j]+ " ");
			System.out.println();
		}
		
	}
	
	public static void DFS(int x) {
		
		while(!q.isEmpty()) {
			int tem = q.remove();
			N[x][tem] = 1;
			
			for(int i = 0; i<n; i++) {
				if(N[tem][i] == 1 && !visited.contains(i)) {
					q.add(i);
					visited.add(i);
				}
			}
		}
	}
}

