import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, cnt, top, comp;
	static int [] mx = {-1, 1, 0, 0};
	static int [] my = {0, 0, -1, 1};
	static int [] count; 
	static int [][] N;
	static int [][] D;
	static int [][] visited;
	static Queue <Dot> near = new LinkedList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		N = new int [n][n];
		D = new int [n][n]; 
		visited = new int [n][n];
		StringTokenizer st;
		top = 0;
		
		if(n >= 2 && n <= 100)
		{
			for(int i = 0; i < n; i++)
			{
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++)
				{
					N[i][j] = Integer.parseInt(st.nextToken());
					if(top < N[i][j])
						top = N[i][j];
				}
			}
			
			count = new int [top+1];
			
			Count();
		}
		
		comp = 1;
		for(int i = 0; i < count.length; i++)
		{
			if(comp < count[i])
				comp = count[i];
		}
		
		bw.write(comp + "");
		
		bw.flush();
		bw.close();
	}
	
	public static void Count() {
		
		int x = 0;
		
		while(x <= top)
		{
			for(int i = 0; i < n; i++)
			{
				for(int j = 0; j < n; j++)
				{
					if(x > N[i][j])
					{
						D[i][j] = 0;
					}
					else {
						D[i][j] = 1;
					}
					visited[i][j] = 0;
				}
			}
			
			cnt = 0;
			comp_Find();
			near.clear();
			count[x] = cnt;
			x++;
		}
		
	}
	
	public static void comp_Find() {
		
		Dot d = new Dot(0,0);
		
		while(d.y < n)
		{
			if(D[d.x][d.y] == 1 && visited[d.x][d.y] != 1)
			{
				near.add(new Dot(d.x, d.y));
				visited[d.x][d.y] = 1;
				cnt++;
				NearFind();
			}
			
			d.x++;
			if(d.x == n && d.y+1 < n)
			{
				d.x = 0;
				d.y++;
			}
			else if(d.y+1 == n && d.x == n)
				d.y++;
		}
		
	}
	
	public static void NearFind() {
		
		while(!near.isEmpty())
		{
			Dot tem = near.remove();
            
			for(int i = 0; i < mx.length; i++)
			{
				int newx = tem.x + mx[i];
				int newy = tem.y + my[i];
				
				Dot d = new Dot(newx, newy);
			
				if(newx >= 0 && newx<n && newy>=0 && newy<n)
				{
					if(visited[newx][newy] != 1 && D[newx][newy] == 1)
					{
						near.add(d);
						visited[newx][newy] = 1;
					}	
				}
			}
		}
	}

}

class Dot
{
	int x;
	int y;
	
	public Dot(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

