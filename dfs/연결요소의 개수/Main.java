import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int n,m,count;
	static int [] l1;
	static int [] l2;
	static int [][] map;
	static ArrayList<Integer> visited = new ArrayList<>();
	static Queue<Integer> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		l1 = new int [m];
		l2 = new int [m];
		map = new int [n+1][n+1];
		
		count = 0;
		
		for(int i = 0 ; i < m; i++)
		{
			st = new StringTokenizer(br.readLine());
			l1[i] = Integer.parseInt(st.nextToken());
			l2[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < m; i++)
		{
			map[l1[i]][l2[i]] = 1;
			map[l2[i]][l1[i]] = 1;
		}
        
        if(m > 0)
    		Count(new Line(l1[0], l2[0]));
		else
            count = n;
        
		bw.write(count + "");
		
		bw.flush();
		bw.close();
		
	}
	
	static void Count(Line l) {
		
		q.clear();
		
		q.add(l.x);
		visited.add(l.x);
		q.add(l.y);
		visited.add(l.y);
		count++;
		
		while(!q.isEmpty() || visited.size() < n)
		{
            if(q.isEmpty())
			{
				int x = 1;
				while(visited.contains(x) == true && x<n+1)
				{
					x++;
				}
				q.add(x);
                visited.add(x);
				count++;
			}
			
			int tem = q.remove();
			for(int i = 0; i < n+1; i++)
			{
				if(map[tem][i] == 1)
				{
                    if(!visited.contains(i))
					{
                        q.add(i);
						visited.add(i);
					}
				}
			}
		}
	}
}

class Line{
	int x,y;
	
	public Line(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

