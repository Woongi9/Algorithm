import java.util.Scanner;

public class Main {

	public static int n,m;
	public static char N[], N_[], M[], NM[];
	
	public static void Move(int t) {
		
		int cnt = 0;
		int tem = t;
		int cnt_ = 0;
		
		for(int i = n-1; i >= 0; i--)
		{
			if(i+t < n+m-cnt)
			{
				NM[i+t] = N[i];
				if(t > 0)
					t--;
				cnt++;
			}
			else
			{
				NM[n+m-1-cnt] = N[i];
				t--;
				cnt++;
			}
		}
		
		cnt = 0;
		
		for(int i = 0; i<n+m; i++)
		{
			if(cnt+1 <= n)
			{
				if(NM[i] != N[cnt])
				{
					NM[i] = M[cnt_];
					cnt_++;
				}
				else if(NM[i] == N[cnt])
					cnt++;
			}
			else
			{
				NM[i] = M[cnt_];
				cnt_++;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		N_ = new char [n];
		N = new char [n];
		M = new char [m];
		NM = new char[n+m];
		
		N_ = sc.next().toCharArray();
		for(int i = 0; i<n; i++)
			N[i] = N_[n-1-i];
		M = sc.next().toCharArray();
		
		int t = sc.nextInt();
		
		for(int i = 0; i < NM.length; i++)
			NM[i] = 'X';
		
		if(t < 0 || t > 50)
			System.exit(0);
		
		Move(t);
		
		System.out.print(NM);
		sc.close();
	}
	

}
