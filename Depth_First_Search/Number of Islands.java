/*



Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3


*/


class Solution {
    public int numIslands(char[][] dp) {
        int count=0;
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[i].length;j++){
                if(dp[i][j]=='1'){
                    count++;
                    dfs(dp,i,j);
                }
            }
        }
        return count;
    }
    public static void dfs(char[][] dp,int i,int j){
        if(i<0 || i>=dp.length|| j<0||j>=dp[i].length|| dp[i][j]=='0')
            return ;
        dp[i][j]='0';
        dfs(dp,i+1,j);
        dfs(dp,i-1,j);
        dfs(dp,i,j-1);
        dfs(dp,i,j+1);
        }
    }
