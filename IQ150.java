import java.util.Scanner;

public class IQ150{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		if(n<1 || n>20) {
		}
		else
		{
			int arr[][]; 
			arr = new int [n][n];
		
			for(int i = 0; i<n; i++)
				arr[i][0] = sc.nextInt();
			
			for(int i = 0; i < n; i++)
			{
				for(int j = 1; j < i+1; j++)
				{
					arr[i][j] = arr[i][j-1] - arr[i-1][j-1];
				}
			}
		
			for(int i = 0; i<n; i++)
			{
				for(int j = 0; j<i+1; j++)
				{
					System.out.printf(+arr[i][j]+ " ");
				}
				System.out.println("");
			}
		}
		
	}

}
