import java.io.*;
import java.util.*;

public class Main {
	
	static int n, m;
	static int [] arr;
	static boolean [][] check;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int [n+1];
		check = new boolean [n+1][n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i < n+1; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= n; i++)
            check[i][i] = true;

        for(int i = 1; i <= n - 1; i++)
            if(arr[i] == arr[i + 1]) check[i][i + 1]= true;

        for(int i = 2; i < n; i++){
            for(int j = 1; j <= n - i; j++){
                if(arr[j] == arr[j + i] && check[j + 1][j + i - 1])
                	check[j][j + i] = true;
            }
        }
		
		m = Integer.parseInt(br.readLine());
		
		for(int i = 1; i < m+1; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			if(check[start][end]) sb.append("1\n");
            else sb.append("0\n");
		}
		
		System.out.print(sb);
	}

}
