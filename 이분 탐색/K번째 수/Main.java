import java.io.*;
import java.util.*;

public class Main {
	
	static int n,k,t,num;
	static int [] arr;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		
		long l = 1;
		long r = k;
		
		while(l < r) {
			long mid = (l+r)/2;
			long cnt = 0;
			
			for(int i = 1; i <= n; i++)
				cnt += Math.min(mid/i, n);
			
			if(k <= cnt)
				r = mid;
			else
				l = mid+1;
		}
		
		System.out.println(l);
	}

}
