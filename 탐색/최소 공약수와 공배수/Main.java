class Solution {
    public int[] solution(int n, int m) {
        int[] answer = {};

        answer = new int [2];

        int min = Math.min(n,m);
        int max = Math.max(n,m);

        for(int i = min; i > 0; i--){

            if(min % i == 0 && max % i == 0){
                answer[0] = i;
                break;
            }
        }

        for(int i = max; i <= 1000000; i += max){
            if(i % n == 0 && i % m == 0){
                answer[1] = i;
                break;
            }
        }

        return answer;
    }
}
