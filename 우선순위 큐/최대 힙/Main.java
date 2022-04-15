import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	
	static int n;
	static PriorityQueue<Long> pq =new PriorityQueue<>(Collections.reverseOrder());
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<n; i++)
		{
			String str = br.readLine();
			if(str.equals("0")) {
				if(pq.isEmpty())
					sb.append(0).append("\n");
				else
					sb.append(pq.remove()).append("\n");
			}else
				pq.add(Long.valueOf(Integer.parseInt(str)));
		}
		System.out.println(sb);
	}

}

