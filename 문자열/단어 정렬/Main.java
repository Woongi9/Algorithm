import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	
	static int n, l, r;
	static ArrayList<String> str = new ArrayList<>();
	static ArrayList <String> temp = new ArrayList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < n; i++)
			str.add(br.readLine());
		
		Delete();
		
		Sort(0, str.size());
		
		for(int i = 0 ; i < str.size(); i++)
			System.out.println(str.get(i));
	}
	
	public static void Sort(int start, int end) {
		
		int mid = (start + end) /2;
		
		if(end - start > 2)
		{
			Sort(start, mid);
			Sort(mid, end);
		}else if(end - start == 1){
			temp.add(str.get(l));
		}
		
		l = start;
		r = mid;
		temp.clear();
		
		while(l < mid || r < end)
		{
			
			if(l < mid && r < end)
			{
				if(str.get(l).length() < str.get(r).length()){
					temp.add(str.get(l));	
					l++;
				}else if(str.get(l).length() > str.get(r).length()) {
					temp.add(str.get(r));
					r++;
				}else {
					if(str.get(l).compareTo(str.get(r)) < 0) {
						temp.add(str.get(l));
						l++;
					}else if(str.get(l).compareTo(str.get(r)) > 0) {
						temp.add(str.get(r));
						r++;
					}
				}
			}else if(l == mid)
			{
				temp.add(str.get(r));
				r++;
			}else{
				temp.add(str.get(l));
				l++;
			}
		}
		
		for(int i = 0; i < temp.size(); i++)
			str.set(i+start, temp.get(i));
	}
	
	public static void Delete() {
		
		
		for(int i = 0 ; i < str.size()-1; i++)
		{
			for(int j = i+1 ; j < str.size(); j++)
			{
				if(str.get(i).compareTo(str.get(j)) == 0)
				{
					str.remove(j);
					j--;
				}
			}
		}
	}
}

