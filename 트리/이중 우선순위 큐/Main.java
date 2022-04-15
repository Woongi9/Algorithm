import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	
	static int t, n, x;
	static String id;
	static TreeMap<Integer, Integer> map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		t = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < t; i++) {
			
			map = new TreeMap<>();
			n = Integer.parseInt(br.readLine());
			
			for(int j = 0 ; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				id = st.nextToken();
				x = Integer.parseInt(st.nextToken());
				
				if(id.equals("I")) {
					if(map.containsKey(x))
						map.put(x, map.get(x)+1);
					else
						map.put(x, 100);
				}else if(id.equals("D")) {
					if(!map.isEmpty()) {                   
						if(x == 1) {
							int maxkey = map.lastKey();
							int next = map.get(maxkey)-1;
							if(next == 99)
								map.remove(maxkey);
							else
								map.put(maxkey, next);
							
						}else if(x == -1) {
							int minkey = map.firstKey();
							int next = map.get(minkey)-1;
							if(next == 99)
								map.remove(minkey);
							else
								map.put(minkey, next);
						}	
					}
				}
			}
			
			if(map.size() == 0) {
				sb.append("EMPTY");
			}else 
				sb.append(map.lastKey()).append(" ").append(map.firstKey());
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
