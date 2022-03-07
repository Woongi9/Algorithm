import java.util.Scanner;

public class Main {

	public static int n,k;
	public static long cnt;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		cnt = 1;	
		int tem = n-k+1;
		
		if(k >= 1 && k <= 30 && k<=n && n <= 30)
		{
			for(int i = k; i > 0; i--)
			{
				cnt *= tem;
				tem--;
			}
			for(int i = k; i > 0; i--)
			{
				cnt /= i;
			}

			System.out.println(+cnt);
		}
		
	}

}
