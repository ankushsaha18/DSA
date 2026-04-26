#include <iostream>
#include <vector>
using namespace std;



class Solution {
public:
    int uniquePathsWithObstacles(vector<vector<int>>& matrix) {
        int m = matrix.size();
        int n = matrix[0].size();
        if(matrix[0][0] == 1 || matrix[m-1][n-1] == 1) return 0;
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

                if(i > 0 && matrix[i-1][j] != 1){
                    up = prev[j];
                }
                if(j > 0 && matrix[i][j-1] != 1){
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
    vector<vector<int>> matrix = {{0,0,0},{0,1,0},{0,0,0}};
    Solution sol;
    cout << sol.uniquePathsWithObstacles(matrix) << endl; // Output: 2
    return 0;
}