class Solution {
    
    static int t,answer,l;
    static int [] n;
    
    public int solution(int[] numbers, int target) {
        
        t = target;
        n = numbers.clone();
        l = numbers.length;
        
        DFS(0, 0);
        
        return answer;
    }
    
    public static void DFS(int x, int sum){
        
        if(x == l){
            if(sum == t)
                answer++;
            return;
        }
        
        DFS(x+1, sum + n[x]);
        DFS(x+1, sum - n[x]);
        
    }
}
