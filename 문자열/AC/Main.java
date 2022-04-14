import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int test_case, n;
	static char [] p;
	static char [] temp;
	static String str;
	static ArrayDeque<Integer> deque;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		test_case = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < test_case; i++)
		{
			p = br.readLine().toCharArray();
			n = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine(), "[],");
			
			deque = new ArrayDeque<Integer>();
			
			for(int j = 0 ; j < n; j++) 
				deque.add(Integer.parseInt(st.nextToken()));

			AC();
			
		}
		
		System.out.print(sb);
	}
	
	public static void AC() {
		
		str = "";
		
		boolean rl = true;
		
		for(int i = 0 ; i < p.length; i++) {
			if(p[i] == 'D') {
				
				if(rl == true) {
					if(deque.pollFirst() == null) {
						sb.append("error\n");
						return;
					}
				}else {
					if(deque.pollLast() == null) {
						sb.append("error\n");
						return;
					}
				}
			}else if(p[i] == 'R')
				rl = !rl;
		}
		
		makePrintString(deque, rl);
	}
	
public static void makePrintString(ArrayDeque<Integer> deque, boolean rl) {
		
		sb.append("[");
		
		if(deque.size() > 0) {
			if(rl) {
				sb.append(deque.pollFirst());
				
				while(!deque.isEmpty())
				{
					sb.append(",").append(deque.pollFirst());
				}
			}else {
				sb.append(deque.pollLast());
			
				while(!deque.isEmpty()) {
					sb.append(",").append(deque.pollLast());
				}
			}
		}
		
		sb.append("]").append("\n");
	}
}
