import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	
	static int m,x;
	static HashSet<Integer> set = new HashSet<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		m = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		for(int i = 0; i < m; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			String str = st.nextToken();
			
			if(str.equals("all")) {
				set.clear();
				
				for(int j = 1; j<=20; j++)
					set.add(j);
				
			}else if(str.equals("empty")) {
				
				set.clear();
				
			}else {
				
				x = Integer.parseInt(st.nextToken());
				
				if(str.equals("add")) {
					
					if(!set.contains(x))
						set.add(x);
					
				}else if(str.equals("remove")) {
					
					if(set.contains(x))
						set.remove(x);
					
				}else if(str.equals("check")) {
					
					if(set.contains(x))
						sb.append(1).append("\n");
					else
						sb.append(0).append("\n");
					
				}else if(str.equals("toggle")) {
					
					if(set.contains(x))
						set.remove(x);
					else
						set.add(x);
				}
				
			}
		}
		
		System.out.print(sb);

	}
}

