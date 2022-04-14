import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int n,m,cnt;
	static String IO;
	static char [] str;
	static int [] count;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		str = br.readLine().toCharArray();
		count = new int [str.length];
		
		cnt = 0;
		
		for(int i = 1; i < str.length-1; i++) {
			if(str[i] == 'O' && str[i+1] == 'I') {
				count[i+1] = count[i-1] + 1;
				
				if(count[i+1] >= n && str[i - 2*n +1] == 'I') 
					cnt++;
			}
		}
  
		System.out.println(cnt);
	}
}
