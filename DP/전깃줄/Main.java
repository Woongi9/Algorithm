import java.io.*;
import java.util.*;

public class Main {
	
	static int n, min;
	static int [][] line;
	static int [] Count;
//	static PriorityQueue<Line> pq = new PriorityQueue<>();

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		line = new int [n+1][2];
		Count = new int [n+1];
		
		StringTokenizer st;
		for(int i = 1; i < line.length; i++) {
			st = new StringTokenizer(br.readLine()," ");
			line[i][0] = Integer.parseInt(st.nextToken());
			line[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// A전봇대 정렬 
		Arrays.sort(line, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
 
		for(int i = 1; i < Count.length; i++) {
			
			Count[i] = 1;
			
			for(int j = 1; j < i; j++) {
				if(line[i][1] > line[j][1]) 
					Count[i] = Math.max(Count[i], Count[j] + 1);
			}
		}
		
		int max = 0;
		
		for(int i = 1; i < n+1; i++) 
			max = Math.max(max, Count[i]);
		
		System.out.println(n - max);
		
	}
}
