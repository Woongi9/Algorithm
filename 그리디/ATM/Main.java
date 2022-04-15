import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int [] time, total;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		time = new int [n];
		total = new int [n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i<n; i++) 
			time[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(time);
		total[0] = time[0];
		
		if(n > 1) {
			for(int i = 1; i<n; i++) {
				time[i] = time[i-1] + time[i];
				total[i] = total[i-1] + time[i];
			}
		}
		System.out.println(total[n-1]);
	}

}

