import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	static int n;
	static Integer[] List;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		List = new Integer[n+1];
		List[0] = List[1] = 0;
		
		if(n >= 1 && n<= 1000000)
			bw.write(Count(n, 0) + "");
		
		bw.flush();
		bw.close();
		return;
	}
	
	public static int Count(int n, int cnt) {
		
		if(n < 2)
			return cnt;
		return Math.min(Count(n/2, cnt + 1 + (n%2)), Count(n/3, cnt + 1+ (n%3)));
	}
	

}
