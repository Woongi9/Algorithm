import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int n, cnt;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		cnt = 0;
		
		if(n >=5)
		{
			for(int i = 5 ; i <= n; i+=5)
			{
				if(i % 125 == 0)
					cnt += 3;
				else if(i%25 == 0)
					cnt += 2;
				else
					cnt++;
			}
		}
		System.out.print(cnt);
	}
}

