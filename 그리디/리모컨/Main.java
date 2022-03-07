import java.util.Scanner;

public class study01 {
	
	public static int a,b,c,cnt;
	public static int k[] = {10,5,1};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		b = sc.nextInt();
		c = Math.abs(a-b);
		cnt = 0;
		
		if (a >= 0 || b >= 0 || a <= 40 || b <= 40)
		{
			Count(2);
			System.out.println(cnt);
		}
		
	}
	
	public static void Count(int d) {
		if(d != 0)
			Count(d-1);
		cnt = Math.abs(cnt + c/(k[d]));
		c = c%(k[d]);
		
		if(d+1 <= 2)
		{
			if(Math.abs(c - k[d]) < Math.abs(c-k[d+1]))
			{
				cnt++;
				c = Math.abs(c-k[d]);
			}
		}
	}

}
