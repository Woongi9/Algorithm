import java.io.*;
import java.util.*;

public class Main {
	
	static int n,m;
	static ArrayList<Integer> list = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i < n+1; i++) 
			list.add(Integer.parseInt(st.nextToken()));
		
		Collections.sort(list);
		
		int [] arr = new int [m];
		
		for(int i = 0; i < n; i++) {
			arr[0] = list.get(i);
			Make(arr, i, 0);
		}
		
		System.out.print(sb);

	}
	
	public static void Make(int [] arr, int input, int d) {
		
		if(d == m-1) {
			for(int i = 0; i < arr.length; i++)
				sb.append(arr[i]).append(" ");
			sb.append("\n");
		}else {
			
			for(int i = input; i < n; i++) {
				
				arr[d+1] = list.get(i);
				Make(arr, i, d+1);
			}
			
		}
		
	}

}
