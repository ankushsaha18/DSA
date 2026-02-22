package DynamicPrograming.DP_2D;

import java.util.Arrays;

public class NinjaTraining {
    public static void main(String[] args) {
        int[][] matrix = {{10, 40, 70}, {20, 50, 80}, {30, 60, 90}};
        System.out.println(ninjaTraining(matrix));
    }
    public static int ninjaTraining(int[][] matrix) {
        int[][] dp = new int[matrix.length][4];
        for (int[] row : dp){
            Arrays.fill(row,-1);
        }
        return helper(matrix.length-1,matrix,3,dp);
    }
    public static int helper(int day,int[][] matrix,int last,int[][] dp){
        if(dp[day][last] != -1) return dp[day][last];

        if(day == 0){
            int max = 0;
            for(int i = 0 ; i < 3 ; i++){
                if(i != last){
                    max = Math.max(matrix[0][i],max);
                }
            }
            return dp[day][last] = max;
        }
        int max = 0;
        for (int i = 0 ; i < 3 ; i++){
            if(i != last){
                int activity = matrix[day][i] + helper(day-1,matrix,i,dp);
                max = Math.max(max,activity);
            }
        }
        return dp[day][last] = max;
    }
}
