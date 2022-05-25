import java.io.*;
import java.util.*;

public class Main {
	
	static int n,m;
	static int [] board;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		board = new int [n+1];
		int [] arr = new int [n+1];
		
		for(int i = 1; i < n+1; i++) {
			arr[1] = i;
			Make(arr,1);
		}
		
		System.out.print(sb);
	}
	
	public static void Make(int [] arr, int d) {
		
		if(d == m) {
			for(int i = 1; i < d+1; i++) {
				sb.append(arr[i]).append(" " );
			}
			sb.append("\n");
		}else {
			for(int i = arr[d]; i < n+1; i++) {
				arr[d+1] = i;
				Make(arr, d+1);
			}
		}
		
	}

}
