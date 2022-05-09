import java.io.*;
import java.util.*;

public class Main {
	
	static int n;
	static ArrayList<Integer> preOrder = new ArrayList<>();
	static ArrayList<Integer> inOrder = new ArrayList<>();
	static ArrayList<Integer> postOrder = new ArrayList<>();

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		//인오더 저장
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) 
			inOrder.add(Integer.parseInt(st.nextToken()));
		
		//포스트오더 저장
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) 
			postOrder.add(Integer.parseInt(st.nextToken()));
		
		PreOrder(0, inOrder.size());
		
		for(int i = 0; i<preOrder.size(); i++) 
			System.out.print(preOrder.get(i) + " ");
		
	}
	
	public static void PreOrder(int start, int size) {
		
		int root;
		
		if(start != size)
			root = postOrder.get(start + size-1);
		else{
			root = postOrder.get(start);
			return;
		}
		
		preOrder.add(root);
		
		int i = 0;
		while(inOrder.get(i) != root) {
			i++;
		}
		
		inOrder.remove(i);
		postOrder.remove(size-1);
		
		if(!postOrder.isEmpty()) {
			if(i != 0)
				PreOrder(0, i);
			if(postOrder.size() > 0)
				PreOrder(0, size-1-i);
		}	
	}
}
