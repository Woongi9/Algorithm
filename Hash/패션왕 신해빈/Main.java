import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
	static int testCase, n, cnt;
	static HashMap<String, Integer> map = new HashMap<>();
	static ArrayList<String> keys = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		testCase = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < testCase; i++) {
			
			n = Integer.parseInt(br.readLine());
			keys.clear();
			map.clear();
			
			for(int j = 0; j<n; j++) {
				
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				String value = st.nextToken();
				String key = st.nextToken();
				
				if(!map.containsKey(key)) {
					map.put(key, 1);
					keys.add(key);
				}else
					map.replace(key, map.get(key)+1);
			}
			
			Count();
			sb.append(cnt).append("\n");
		}
		
		System.out.print(sb);
	}
	
	public static void Count() {
		
		cnt = 1;
		
		for(int i = 0; i<keys.size(); i++) 
			cnt *= map.get(keys.get(i))+1;
		
		cnt--;
	}

}

