import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
	
	static int n, current;
	static int [][] temp;

	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		temp = new int [n][2];
		current = 0;
		
		StringTokenizer st;
		
		for(int i = 0 ; i < n; i++)
		{
			st = new StringTokenizer(br.readLine());
			temp[i][0] = Integer.parseInt(st.nextToken());
			temp[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(temp, new Comparator<int[]>() {
			@Override
			public int compare(int [] o1, int [] o2) {
				
				if(o1[1] == o2[1])
					return o1[0] - o2[0];
				
				return o1[1] - o2[1];
			}
		});
		
		int cnt = 0;
		int prev_end_time = 0;
		
		for(int i = 0; i < n; i++) {
			// 직전 종료시간이 다음 회의 시작 시간보다 작거나 같다면 갱신 
			if(prev_end_time <= temp[i][0]) {
				prev_end_time = temp[i][1];
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}
