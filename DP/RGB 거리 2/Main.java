import java.util.*;
public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][]list=new int[n+1][n+1];
        int[][]dp=new int[n+1][n+1]; 
        int[]paint=new int[n+1]; 

        for(int i=1;i<=n;i++) {
            for (int j = 0; j < 3; j++) {
                list[i][j] = sc.nextInt();
            }
        }

        for(int i=0;i<3;i++) {    
            for (int j = 0; j < 3; j++) { 
                if (i == j)
                    dp[1][j] = list[1][j]; 
                else
                    dp[1][j] = 1001; 
            }
          
            for (int k = 2; k < n + 1; k++) {
                dp[k][0] = Math.min(dp[k - 1][1], dp[k - 1][2]) + list[k][0];
                dp[k][1] = Math.min(dp[k - 1][0], dp[k - 1][2]) + list[k][1];
                dp[k][2] = Math.min(dp[k - 1][0], dp[k - 1][1]) + list[k][2];
                if(k==n){    
                    if(i==0){
                        paint[i]=Math.min(dp[n][1],dp[n][2]);
                    }
                    if(i==1){
                        paint[i]=Math.min(dp[n][0],dp[n][2]);
                    }
                    if(i==2){
                        paint[i]=Math.min(dp[n][0],dp[n][1]);
                    }

                }
            }

        }

        System.out.print(Math.min(paint[0],Math.min(paint[1],paint[2])));
    }
}
