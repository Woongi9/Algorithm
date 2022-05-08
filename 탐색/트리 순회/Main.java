import java.io.*;
import java.util.*;

public class Main {
	
	static int n;
	static HashMap<String, Node> map = new HashMap<>();

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++) {
		
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String cur = st.nextToken();
			String left = st.nextToken();
			String right = st.nextToken();
			
			Node tem = new Node(cur, left, right);
			map.put(cur, tem);
		}
		
		Front("A");
		System.out.println();
		Middle("A");
		System.out.println();
		Back("A");
		System.out.println();
		
	}
	
	public static void Front(String cur) {
		
		Node node = map.get(cur);
		
		System.out.print(node.a);
		
		if(node.l.compareTo(".") != 0) 
			Front(node.l);
		
		if(node.r.compareTo(".") != 0) 
			Front(node.r);
	}
	
	public static void Middle(String cur) {
		
		Node node = map.get(cur);
		
		if(node.l.compareTo(".") != 0) {
			Middle(node.l);
		}
		
		System.out.print(node.a);
		
		if(node.r.compareTo(".") != 0) 
			Middle(node.r);
	}

	public static void Back(String cur) {
		
		Node node = map.get(cur);
		
		if(node.l.compareTo(".") != 0) 
			Back(node.l);
		
		if(node.r.compareTo(".") != 0) 
			Back(node.r);
		
		System.out.print(node.a);
	}

}

class Node{
	
	String a;
	
	String l;
	String r;
	
	public Node(String a , String l, String r) {
		this.a = a;
		this.l = l;
		this.r = r;
	}
	
}

