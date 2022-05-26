import java.io.*;
import java.util.*;

public class Main {

	static int n,m,min;
	static int [][] board;
	static ArrayList<int []> store = new ArrayList<int []>();
	static ArrayList<int []> home = new ArrayList<int []>();
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		board = new int [n+1][n+1];
		
		for(int i = 1; i < n+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j < n+1; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				
				if(board[i][j] == 2) {
					
					int [] tem = new int [2];
					tem[0] = i;
					tem[1] = j;
					
					store.add(tem);
					
				}else if(board[i][j] == 1) {
					int [] tem = new int [2];
					tem[0] = i;
					tem[1] = j;
					
					home.add(tem);
				}
			}
		}
		
		min = Integer.MAX_VALUE;
		int [] arr = new int [m+1];
		for(int i = 0; i < store.size(); i++) {
			arr[1] = i;
			DFS(arr, 1);
		}
		
		System.out.println(min);
	}
	
	public static void DFS(int [] arr, int depth) {
		
		if(depth == m) {
			Cal(arr);
		}else {
			for(int i = arr[depth]+1; i < store.size(); i++) {
				arr[depth+1] = i;
				DFS(arr, depth+1);
			}
		}
	}
	
	public static void Cal(int [] arr) {
		
		int sum = 0;
		
		for(int i = 0; i < home.size(); i++) {
			
			int tem = Integer.MAX_VALUE;
			int homex = home.get(i)[0];
			int homey = home.get(i)[1];
			
			for(int j = 1; j<m+1; j++) {
				
				int storex = store.get(arr[j])[0];
				int storey = store.get(arr[j])[1];
				
				tem = Math.min(Math.abs(homex - storex) + Math.abs(homey - storey)
				, tem);
			}
			
			sum += tem;
			
		}
		
		min = Math.min(sum, min);
		
	}

}
 
