import java.io.*;
import java.util.*;

public class Main {
	
	static int n;
	static long a,b,min;
	static ArrayList<N> list = new ArrayList<>();

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i < n+1; i++) {
			long tem = Long.valueOf(st.nextToken());
			list.add(new N(tem, Math.abs(tem)));
		}
		
		Collections.sort(list);
		min = Long.MAX_VALUE;
		
		for(int i = 1; i < n; i++) {
			N n1 = list.get(i-1);
			N n2 = list.get(i);
			
			if(min >= Math.abs(n1.num + n2.num)) {
				min = Math.abs(n1.num + n2.num);
				a = Math.min(n1.num, n2.num);
				b = Math.max(n1.num, n2.num);
			}
		}
			
		System.out.println(a + " " + b);
	}

}

class N implements Comparable <N>{
	long num;
	long a;
	
	public N (long num, long a) {
		this.num = num;
		this.a = a;
	}
	
	@Override
	public int compareTo(N n) {
		return (int) (n.a - this.a);
	}
}
