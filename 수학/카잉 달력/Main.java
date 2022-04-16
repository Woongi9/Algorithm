import java.io.IOException;
import java.util.Scanner;

public class Main {
	
	static int test_case;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		test_case = sc.nextInt();
		
		for (int tc = 1; tc <= test_case; tc++) {
            int M = sc.nextInt(), N = sc.nextInt(), x = sc.nextInt(), y = sc.nextInt();

            int lcm = M * N / gcd(M, N);
            int n = 0;
            int ans = -1;
            while (n * M < lcm) {
                if ((n * M + x - y) % N == 0) {
                    ans = n * M + x;
                    break;
                }
                n++;
            }

            sb.append(ans).append("\n");
        }
		
		System.out.println(sb);
    }

    static int gcd(int n1, int n2) {
        if (n2 == 0)
            return n1;
        return gcd(n2, n1 % n2);
    }
}
