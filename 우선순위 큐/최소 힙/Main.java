import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	
	static int n, tem;
	static ArrayList<Integer> Answer = new ArrayList<>();
	static PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < n ; i++)
		{
			tem = Integer.parseInt(br.readLine());
			
			if(tem == 0) {
				if(priorityQueue.size() > 0) 
					Answer.add(priorityQueue.remove());
				else
					Answer.add(0);
			}else {
				priorityQueue.add(tem);
			}
		}
		
		for(int i = 0 ; i < Answer.size(); i++)
			System.out.println(Answer.get(i));
	}
}
