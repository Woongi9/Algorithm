import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {
	
	private static int n;
	private static ArrayList<Integer> List;
	private static ArrayList<Integer> Result = new ArrayList<Integer>();
	
	public static void MergeSort (int start, int end){
		
		int x = start;
		int y = (start+end)/2;
		
		if(end - start > 2)
		{
			if((end-start)/2 != 1)
				MergeSort(start, (start+end)/2);
			MergeSort((start+end)/2, end);
		}
		
		while(x < (start+end)/2 && y < end)
		{
			//1군이 더 클 경우
			if(List.get(x) > List.get(y))
			{
				Result.add(List.get(y));
				y++;
			} //2군이 더 클 경우
			else if(List.get(x) < List.get(y)) 
			{
				Result.add(List.get(x));
				x++;
			}
		}
		
		while(x != (start+end)/2)
		{
			Result.add(List.get(x));
			x++;
		}
		
		while(y != end)
		{
			Result.add(List.get(y));
			y++;
		}
		
		for(int i = start; i < end; i++)
			List.set(i, Result.get(i-start));
		
		Result.clear();
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		
		List = new ArrayList<Integer>();
		
		for(int i = 0; i < n; i++) 
			List.add(Integer.parseInt(br.readLine()));

		MergeSort(0, n);
		
		for(int i = 0 ; i < List.size(); i++)
			bw.write(List.get(i) + "\n");
		
		bw.flush();
		bw.close();
	}
}

