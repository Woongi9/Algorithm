import java.io.*;
import java.util.*;

public class Main {
	
	static int n, cnt;
	static int [] arr;
	static ArrayList<Integer> s = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int [n+1];
		
		if(n >= 2)
			s.add(2);
		
		//소수 찾기
		for(int i = 3; i <= n; i +=2) {
				
			if(arr[i] == 0) {
				s.add(i);
				
				for(int j = i; j <= n; j+=i) 
					arr[j]++;
			}		
		}
		
		//투포인터 DP
		int start = 0;
		int end = 0;
		int sum = 0;
		if(n > 1)
			sum += s.get(0);
		
		while(end < s.size() && start < s.size()) {
			
			if(sum == n) {
				cnt++;
				sum -= s.get(start);
				start++;
			}else if(sum > n) {
				sum -= s.get(start);
				start++;
			}else {
				end++;
				if(end == s.size())
					break;
				sum += s.get(end);
			}
			
		}
		
		System.out.println(cnt);
	}

}

