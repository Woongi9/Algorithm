import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	
	static int min;
	static String input;
	static String [] str;
	static ArrayList<String> Str = new ArrayList<>();
	static ArrayList<String> plusStr = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		input = br.readLine();
        String [] temp;
		if(input.contains("-"))
			temp = input.split("-");
		else
		{
			temp = new String [1];
			temp[0] = input;
		}
		min = 0;
		
		if(temp.length == 1)
		{
			if(temp[0].contains("+"))
			{
				str = temp[0].split("\\+");

				for(int j = 0 ; j < str.length; j++)
				{
					plusStr.add(str[j]);
					Str.add(str[j]);
				}
			}else {
				plusStr.add(temp[0]);
				Str.add(temp[0]);
			}
		}else {
			for(int i = 0 ; i < temp.length; i++)
			{
				if(i == 0){
					if(temp[i].contains("+"))
					{
						str = temp[i].split("\\+");
						
						for(int j = 0 ; j < str.length; j++)
						{
							plusStr.add(str[j]);
							Str.add(str[j]);
						}
					}else {
						plusStr.add(temp[i]);
						Str.add(temp[i]);
					}
				}else if(temp[i].contains("+")){
					str = temp[i].split("\\+");
					
					for(int j = 0 ; j < str.length; j++)
						Str.add(str[j]);
					
				}else{
					Str.add(temp[i]);
				}
			}
		}
        
		for(int i = 0 ; i < Str.size(); i++)
		{
			if(plusStr.contains(Str.get(i)))
			{
				min += Integer.parseInt(Str.get(i));
				plusStr.remove(Str.get(i));
			}
			else
				min -= Integer.parseInt(Str.get(i));
		}
		System.out.print(min);
	}
}
