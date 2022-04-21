import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m;
	static String site;
	static HashMap<String, String> hash = new HashMap<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			hash.put(st.nextToken(), st.nextToken());
		}
		
		for(int i = 0; i<m; i++) {
			site = br.readLine();
			
			sb.append(hash.get(site)).append("\n");
		}
		
		System.out.print(sb);
	}
}
