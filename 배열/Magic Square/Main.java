import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		int a[][] = new int [n][n];
		int cnt = 1;
		int x = 0;
		int y = n/2;
		
		for(int i = n-1; i >= 0 ; i--)
		{
			for(int j = 0; j < n; j++)
			{
				a[x][y] = cnt;
				
				if(cnt%n != 0)
				{
					x--;
					y++;
				}
				else
					x++;
				
				if(x == -1)
					x = n-1;
			
				if(y == n)
					y = 0;
				cnt++;
			}
		}
		
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++)
			{
				System.out.printf(+a[i][j]+" ");
			}
			System.out.println("");
		}
	}

}
