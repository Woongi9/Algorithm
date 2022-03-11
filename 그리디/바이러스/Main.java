import java.util.Scanner;

public class Main {
	
	public static int n,linked, l;
	public static int arr_link[][];
	public static int checked[];
	
	public static void Count(int a) {
		int tem = checked[a];
		int already = 0;
		
		for(int i = 0; i < linked; i++)
		{
			for(int j = 0; j < 2; j++)
			{
				if(arr_link[i][j] == tem)
				{
					for(int k = 0; k<=l; k++)
					{
						if(checked[k] == arr_link[i][1-j])
							already++;
					}
					if(already == 0)
					{
						checked[l+1] = arr_link[i][1-j];
						l++;
					}
					already = 0;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		linked = sc.nextInt();
		arr_link = new int [linked][2];
		checked = new int [n];
		checked[0] = 1;
		l = 0;
		
		for(int i = 0 ; i < linked; i++)
		{
			for(int j = 0; j < 2; j++)
				arr_link[i][j] = sc.nextInt();
		}
		
		for(int i = 0; i<=l; i++)
			Count(i);
		
		System.out.print(l);
		
	}
	
	

}
