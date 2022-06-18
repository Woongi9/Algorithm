import java.io.*;
import java.util.*;

public class Main {
	
	static int n,a,b,c;
	static long [] arr;
	static int [] ans = new int [3];
	static long min = Long.MAX_VALUE;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new long [n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++) {
			arr[i] = Long.valueOf(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		for(int i = 0; i < n-2; i++) {
			int l = i;
			int m = i+1;
			int r = n-1;
			
			while(m < r) {
				long sum = arr[l] + arr[m] + arr[r];
				
				if(min > Math.abs(sum)) {
					min = Math.abs(sum);
					ans[0] = l;
					ans[1] = m;
					ans[2] = r;
				}
				
				if(sum == 0) {
					break;
				}else if(sum > 0)
					r--;
				else
					m++;
			}
		}
		
		System.out.println(arr[ans[0]] + " " + arr[ans[1]] + " " + arr[ans[2]]);
	}

}
