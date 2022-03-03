import java.util.Scanner;

public class Main {
	public static int cnt = 0;
	public static int k [];
	public static int b [];
	public static int n;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int m;
		
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		int a = 0;
		k = new int [n];
		b = new int [n];
		
		if(n >= 0 || n <=20)
		{
			for(int i = 0; i < n; i++)
				k[i] = sc.nextInt();
			
			cal(m, a, a);
			System.out.print(+cnt);
		}
		else if(n == 0)
			System.out.print(+cnt);
	}
	
	public static void cal(int m, int x, int a) {
		
		for(int i = 0; i < 2; i++)
		{
			if(x < n)
			{
				if(i == 0)
				{
					a = a + k[x];
					b[x] = k[x];
					if(x+1 < k.length)
						cal(m, x+1, a);
				}
				else
				{
					a = a - k[x];
					b[x] = -k[x];
					if(x+1 < k.length)
						cal(m, x+1, a);
				}
			
				if(a == m && x==k.length-1)
					++cnt;
				else
					a = a - b[x];
			}
			
		}
	}
}
