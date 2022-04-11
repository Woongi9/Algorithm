import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.Collections;

public class Main {
	
	static int n,m;
	static HashSet<String> N = new HashSet<>();
	static ArrayList<String> Answer = new ArrayList<>();
	static ArrayList<String> Temp = new ArrayList<>();

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		for(int i = 0 ; i < n; i++)
			N.add(br.readLine());
		for(int i = 0 ; i < m; i++)
		{
			String tem = br.readLine();
			if(N.contains(tem)) 
				Answer.add(tem);
		}
		
		if(Answer.size() > 0)
			Collections.sort(Answer);
		
		System.out.println(Answer.size());
		
		for(int i = 0 ; i < Answer.size(); i++)
			System.out.println(Answer.get(i));
	}
}

