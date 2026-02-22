#include <iostream>
using namespace std;

class RecursiveSolution {
public:
    int uniquePaths(int m, int n) {
        return helper(0, 0, m, n);
    }

    int helper(int i, int j, int m, int n) {
        if (i >= m || j >= n) return 0;          
        if (i == m - 1 && j == n - 1) return 1;  

        return helper(i + 1, j, m, n) + helper(i, j + 1, m, n);
    }
};

class MemoizedSolution {
public:
    int dp[101][101];
    int uniquePaths(int m, int n) {
        memset(dp, -1, sizeof(dp));
        return helper(m,n,0,0);
    }
    int helper(int m,int n,int i,int j){
        if(i == m-1 && j == n-1) return 1;
        if(i > m-1 || j > n-1){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        dp[i][j] = helper(m,n,i+1,j)+helper(m,n,i,j+1);
        return dp[i][j];
    }
};

class TabulationSolution {
public:
    int uniquePaths(int m, int n) {
        vector<vector<int>> dp(m,vector<int>(n,-1));
        return helper(m,n,dp);
    }
    int helper(int m,int n,vector<vector<int>> dp){
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(i==0 && j==0){
                    dp[i][j] = 1;
                    continue;

                }
                int up = 0;
                int left = 0;

                if(i > 0){
                    up = dp[i-1][j];
                }
                if(j > 0){
                    left = dp[i][j-1];
                }
                dp[i][j] = up+left;
            }
        }
        return dp[m-1][n-1];
    }
};

class SpaceOptimizedSolution {
public:
    int uniquePaths(int m, int n) {
        return helper(m,n);
    }
    int helper(int m,int n){
        vector<int> prev(n,0);
        for(int i = 0 ; i < m ; i++){
            vector<int> temp(n,0);
            for(int j = 0 ; j < n ; j++){
                if(i==0 && j==0){
                    temp[j] = 1;
                    continue;

                }
                int up = 0;
                int left = 0;

                if(i > 0){
                    up = prev[j];
                }
                if(j > 0){
                    left = temp[j-1];
                }
                temp[j] = up+left;
            }
            prev = temp;
        }
        return prev[n-1];
    }
};

int main() {
    RecursiveSolution solution;
    int m = 3, n = 7;
    int result = solution.uniquePaths(m, n);
    cout << "Number of unique paths from top-left to bottom-right: " << result << endl;
    return 0;
}