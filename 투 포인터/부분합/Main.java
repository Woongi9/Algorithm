import java.io.*;
import java.util.*;

public class Main {
	
	static int n,s,min;
	static int [] N;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		
		N = new int [n+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) 
			N[i] = Integer.parseInt(st.nextToken());
		
		int start = 0;
		int end = 0;
		int sum = 0;
		min = Integer.MAX_VALUE;
		
		while(end < n+1 && start < n+1) {
			
			if(sum >= s && min > end - start)
				min = end - start;
			
			if(sum < s) {
				sum += N[end++];
			}else if(sum >= s) {
				sum -= N[start++];
			}
		}
		
		if(min == Integer.MAX_VALUE)
			min = 0;
		
		System.out.println(min);
	}

}
