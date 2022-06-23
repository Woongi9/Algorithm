import java.util.*;

class Solution {
    
    ArrayList<int []> list = new ArrayList<>();
    public int[][] solution(int n) {
        
        minoi(n,1,3,2);
        
        int[][] answer = new int [list.size()][2];
        for(int i = 0; i < list.size(); i++){
            int [] tem = list.get(i);
            answer[i][0] = tem[0];
            answer[i][1] = tem[1];
        }
            
        return answer;
    }
    
    public void minoi(int n, int from, int to, int via){
        int [] move = {from, to};
        
        if(n == 1)  list.add(move);
        else{
            minoi(n-1, from, via, to);
            list.add(move);
            minoi(n-1, via, to, from);
        }
            
    }
}
