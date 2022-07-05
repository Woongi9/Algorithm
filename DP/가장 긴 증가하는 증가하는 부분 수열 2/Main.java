import java.io.*;
import java.util.*;

public class Main {
	
	static int n;
	static int [] arr;
	static int [] res;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int [n];
		res = new int [n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++) 
			arr[i] = Integer.parseInt(st.nextToken());
		
		res[0] = arr[0];
		int cnt = 1;
		for(int i = 1; i < n; i++) {
			int k = arr[i];
			
			if(res[cnt-1] < k) {
				cnt++;
				res[cnt-1] = k;
			}else {
				int low = 0;
				int high = cnt;
				
				while(low < high) {
					int mid = (low + high) >>> 1;
			
					if(res[mid] < k) 
						low = mid+1;
					else
						high = mid;
				}
				
				res[low] = k;
			}
		}
		
		System.out.println(cnt);
	}
}

