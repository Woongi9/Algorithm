import java.io.*;
import java.util.*;

// 14003 가장 긴 증가하는 부분 수열 5 
public class Main {

	static int N;
	static int[] input, index; // index[i] : input[i]가 LIS에 들어간 위치
	static ArrayList<Integer> LIS;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 1. 입력받기
		N = Integer.parseInt(br.readLine());
		input = new int[N + 1];
		index = new int[N + 1];
		LIS = new ArrayList<Integer>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
        
		// ** N은 1이면 바로 끝내기
		if (N==1) {
			bw.write("1\n"+input[1]);
			bw.flush();
			bw.close();
			br.close();
			return;
		}
		
		LIS.add(input[1]);
		index[1] = 0;
		// 2. 이진탐색을 활용한 LIS 배열 만들기
		for (int i = 2; i <= N; i++) {
			// 1) 값이 더 클 경우
			if ( input[i] > LIS.get(LIS.size() - 1)) {
				LIS.add(input[i]);
				index[i] = LIS.size() - 1;
			} else {
				binarySearch(i);
			}
		}

		// 3. 정답 출력
		StringBuilder sb = new StringBuilder();
        sb.append(LIS.size() + "\n");
        // 역추적 경로를 저장할 stack
        Stack<Integer> stack = new Stack();
        int findId = LIS.size() - 1;
        for(int i = N; findId>=0 && i > 0; i--){
            if(index[i] == findId){
            	findId--;
                stack.push(input[i]);
            }
        }
        while (!stack.isEmpty()){
            sb.append(stack.pop() + " ");
        }
        bw.write(sb.toString());

		bw.flush();
		bw.close();
		br.close();
	}

	static void binarySearch(int id) {
		int start, end, mid;
		start = 0;
		end = LIS.size() - 1;

		while (start < end) {
			mid = (start + end) / 2;
			// 값이 더 크면 - lower bound 로직
			if (LIS.get(mid) >= input[id]) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		// LIS 배열 갱신해주고, 위치 기록
		LIS.set(start, input[id]);
		index[id] = start;
	}
}
