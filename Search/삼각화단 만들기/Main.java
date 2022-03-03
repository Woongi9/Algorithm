public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int result;
		
		if(n > 3 || n<=100)
		{
			result = cal(n);
			System.out.println(+result+"");
		}
		
	}
	public static int cal(int n)
	{
		int x, y, z;
		int cnt3 = 0;
		int cnt2 = 0;
		int cnt1 = 0;
		int cnt;
		for(x = (n-1)/2; x > 0; x --)
		{
			for(y = x; y > 0 ; y--)
			{
				z = n - x - y; 
				if(z <= (n-1)/2)
				{
					if(x == y && y == z)
						cnt1++;
					else if(x == y || y == z || x == z)
						cnt2++;
					else
						cnt3++;
				}
			}
		}
		
		cnt = cnt1 + cnt2/2 + cnt3/3;
			
		return cnt;		
	}

}
