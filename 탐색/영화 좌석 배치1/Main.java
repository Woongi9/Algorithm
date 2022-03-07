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
		
		if(k >= 1 && k <= 25 && k<=n && n <=25)
		{
			for(int i = n; i > n-k; i--)
				cnt *= i;
			for(int i = k; i >= 1; i--)
				cnt /= i;

			System.out.println(+cnt);
		}
		
	}

}
