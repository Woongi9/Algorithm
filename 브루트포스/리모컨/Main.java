import java.util.Scanner;

public class Main {
	
	static boolean[] broken = new boolean[10]; // 0~10

	static int possible(int c) {
		if (c == 0) { 
			if (broken[0]) {
				return 0;
			} else {
				return 1;
			}
		}
		int len = 0;
		while (c > 0) {
			if (broken[c % 10]) {
				return 0;
			}
			len += 1;
			c /= 10;
		}
		return len;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); 
		int m = sc.nextInt(); 
		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			broken[x] = true; 
		}

		int ans = Math.abs(n - 100);
		
		for (int i = 0; i < 1000000; i++) {
			int len = possible(i);
			
            //숫자 버튼만으로 이동 가능 확인
            if (len > 0) {
				int press = Math.abs(i - n);
				
                if (ans > len + press) {
					ans = len + press;
				}

			}
		}
		System.out.println(ans);
	}
}

