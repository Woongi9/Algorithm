import java.io.*;
import java.util.*;

public class Main {
	
	static long t,cnt;
	static int n,m;
	static ArrayList<Integer> Alist = new ArrayList<>();
	static ArrayList<Integer> Blist = new ArrayList<>();
//	static HashMap<Long, Long> map = new HashMap<>(); 

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		t = Long.valueOf(br.readLine());
		n = Integer.parseInt(br.readLine());
		
		int [] A = new int [n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) 
			A[i] = Integer.parseInt(st.nextToken());
		
		m = Integer.parseInt(br.readLine());
		
		int [] B = new int [m];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i ++)
			B[i] = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < n; i++	) {
			int sum = 0;
			for(int j = i; j < n; j++) {
				sum += A[j];
				Alist.add(sum);
			}
		}
		
		for(int i = 0; i < m; i++	) {
			int sum = 0;
			for(int j = i; j < m; j++) {
				sum += B[j];
				Blist.add(sum);
			}
		}
		
		Collections.sort(Alist);
		Collections.sort(Blist);
		
		Count();
		
		System.out.println(cnt);
	}
	
	public static void Count() {
		
		int a = 0;
		int b = Blist.size()-1;
		
		while(a < Alist.size() && b >= 0) {
			
			long sum = Alist.get(a) + Blist.get(b);
			
			if(sum == t) {
				
				int ax = Alist.get(a);
				int bx = Blist.get(b);
				
				long aCnt = 0;
				long bCnt = 0;
				
				while(a < Alist.size() && Alist.get(a) == ax	) {
					aCnt++;
					a++;
				}
				while(b >= 0 && Blist.get(b) == bx) {
					bCnt++;
					b--;
				}
				
				cnt += aCnt * bCnt;
				
			}else if(sum < t) 
				a++;
			else if(sum > t) 
				b--;
		}
		
	}

}
