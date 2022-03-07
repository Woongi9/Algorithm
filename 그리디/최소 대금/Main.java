import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr_p[] = new int [3];
		int arr_j[] = new int [2];
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < arr_p.length; i++)
			arr_p[i] = sc.nextInt();
		for(int i = 0; i < arr_j.length; i++)
			arr_j[i] = sc.nextInt();
		
		int tem_p = arr_p[0]; 
		
		for(int i = 0; i < arr_p.length; i++)
		{
			if(arr_p[i] < tem_p)
				tem_p = arr_p[i];
		}
		
		int tem_j = arr_j[0];
		
		if(arr_j[1] < tem_j)
			tem_j = arr_j[1];
		
		float sum = tem_p + tem_j;
		sum += sum * 0.1;
		
		System.out.println(sum);
	}

}
