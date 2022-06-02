import java.io.*;
import java.util.*;

public class Main {
	
	static int n,s;
	static long ans;
	static int [] arr;
	static ArrayList<Integer> A = new ArrayList<>();
	static ArrayList<Integer> B = new ArrayList<>();

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		
		arr = new int [n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		makeSumArray(0,0,n/2,A);
		makeSumArray(0,n/2,n,B);
		
		Collections.sort(A);
		Collections.sort(B);
		
		int l = 0;
		int r = B.size() - 1;
		ans = 0;
		
		while(l < A.size() && r >= 0) {
			int lv = A.get(l);
			int rv = B.get(r);
			
			if(lv + rv == s) {
				
				long lcnt = 0;
				while(l < A.size() && A.get(l) == lv) {
					l++;
					lcnt++;
				}
				
				long rcnt = 0;
				while(r >= 0 && B.get(r) == rv) {
					r--;
					rcnt++;
				}
				
				ans += lcnt * rcnt;
			}
			
			if(lv + rv > s)
				r--;
			
			if(lv + rv < s)
				l++;
		}
		
		ans = s == 0 ? ans - 1 : ans;
		System.out.println(ans);
		
	}
	
	public static void makeSumArray(int sum, int idx, int end, ArrayList<Integer> list) {
		
		if(idx == end) {
			list.add(sum);
			return;
		}
		
		makeSumArray(sum+arr[idx], idx+1, end, list);
		makeSumArray(sum, idx+1, end, list);
		
	}

}
