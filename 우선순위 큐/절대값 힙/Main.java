import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Main {
	
	static int n;
	static StringBuilder sb = new StringBuilder();
	static HashMap<Integer, Integer> set = new HashMap<>(); 
	static PriorityQueue<Integer> pq = new PriorityQueue<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<n; i++) {
			int x = Integer.parseInt(br.readLine());
			
			//입력 0
			if(x == 0) {
				//비어있는 경우
				if(set.isEmpty())
					sb.append(0).append("\n");
				else { 
					//가장 작은절대값 꺼내기
					int tem = pq.remove();
					//-절대값이 존재하는지 확인 없으면 그냥 절대값 삭제
					if(set.containsKey(tem*(-1))){
						if(set.get(tem*(-1))-1 == 0)
							set.remove(tem*(-1));
						else
							set.replace(tem*(-1), set.get(tem*(-1))-1);
						
						sb.append(tem*(-1)).append("\n");
					}else {
						if(set.get(tem)-1 == 0)
							set.remove(tem);
						else
							set.replace(tem, set.get(tem)-1);
						sb.append(tem).append("\n");
					}
				}
			}else {
				if(set.containsKey(x))
					set.replace(x, set.get(x)+1);
				else
					set.put(x, 1);
				pq.add(Math.abs(x));
			}
		}
		
		System.out.print(sb);
	}

}

