import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
	static int n,m;
	static String temp;
	static HashMap<String,String> book = new HashMap<>();
	static HashMap<String,String> book2 = new HashMap<>();
	static ArrayList<String> answer = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		for(int i = 0 ; i < n ; i++)
		{
			temp = br.readLine();
			book.put(String.valueOf(i+1), temp);
			book2.put(temp, String.valueOf(i+1));
		}
		
		for(int i = 0 ; i < m; i++)
		{
			temp = br.readLine();
			if(book.containsKey(temp))
				answer.add(book.get(temp));
			else
				answer.add(book2.get(temp));
		}
		
		for(int i = 0 ; i < answer.size(); i++)
			System.out.println(answer.get(i));
	}
}

