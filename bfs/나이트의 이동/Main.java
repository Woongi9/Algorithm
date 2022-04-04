import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static Queue<Dot> q = new LinkedList<>();
	static boolean [][] remember;
	static int [] move_x = {-2,-2,2,2,-1,1,-1,1};
	static int [] move_y = {1,-1,1,-1,2,2,-2,-2};
	static int [][] count;
	static int n, test_case;
	static int start_x, start_y, end_x, end_y;
	static int result [];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		test_case = Integer.parseInt(br.readLine());
		result = new int [test_case];
		
		for(int i = 0; i < test_case; i++)
		{
			n = Integer.parseInt(br.readLine());
			
			count = new int [n][n];
			remember = new boolean [n][n];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			start_x = Integer.parseInt(st.nextToken());
			start_y = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			end_x = Integer.parseInt(st.nextToken());
			end_y = Integer.parseInt(st.nextToken());
			
			bfs(new Dot(start_x, start_y));
			bw.write(count[end_x][end_y] + "\n");
			
		}
		
		bw.flush();
		bw.close();
		
	}
	
	static void bfs (Dot d) {
		
		q.clear();
		q.add(d);
		count[d.x][d.y] = 0;
		remember[d.x][d.y] = true;
		
		while(!q.isEmpty())
		{
			Dot tem = q.remove();
			
			if(tem.x == end_x && tem.y == end_y)
				break;
			
			for(int i = 0; i < move_x.length; i++)
			{
				int new_x = tem.x + move_x[i];
				int new_y = tem.y + move_y[i];
				
				if(new_x >= 0 && new_x < n && new_y >= 0 && new_y < n && !remember[new_x][new_y]) 
				{
					q.add(new Dot(new_x, new_y));
					remember[new_x][new_y] = true;
					count[new_x][new_y] = count[tem.x][tem.y]+1;
				}
			}
		}
	}
}

class Dot{
	int x,y;
	
	public Dot(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

