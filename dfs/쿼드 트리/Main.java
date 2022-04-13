import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int n;
	static char [][] N;
	static String result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		N = new char [n][n];
		result = "";
		
		for(int i = 0 ; i < n; i++)
		{
			String str = br.readLine();
			N[i] = str.toCharArray();
		}
		
		DFS(n, 0, 0);
		
		System.out.println(result);
	}
	
	public static void DFS(int end, int xstart, int ystart) {
		
		char tem = N[xstart][ystart];
		boolean same = true;
		
		for(int i = 0 ; i < end; i++)
		{
			for(int j = 0; j < end; j++)
			{
				if(N[i+xstart][j+ystart] != tem) {
					same = false;
					i = end;
					j = end;
				}
			}
		}
		
		if(same == false) {
			result += "(";
			DFS(end/2, xstart, ystart);
			DFS(end/2, xstart, ystart+end/2);
			DFS(end/2, xstart+end/2, ystart);
			DFS(end/2, xstart+end/2, ystart+end/2);
			result += ")";
		}else 
			result += tem;
	}
}
