/*


Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

 

Example 1:


Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
Example 2:

Input: grid = [[1,2,3],[4,5,6]]
Output: 12


*/



class Solution {
    public int minPathSum(int[][] grid) {
        if(grid==null || grid.length==0)
            return 0;
        int[][] dp=new int[grid.length+1][grid[0].length+1];
        for(int i=0;i<grid.length;i++) Arrays.fill(dp[i],-1);
        return dfs(grid,dp,0,0);
         
    }
    int sum=0,res=Integer.MIN_VALUE;
    public int dfs(int[][] grid,int[][] dp,int i,int j){
        if(i>=grid.length || j>=grid[0].length)
            return Integer.MAX_VALUE;
        if(i==grid.length-1 && j==grid[0].length-1)
            return grid[i][j];
        if(dp[i][j]!=-1)
            return dp[i][j];
        return dp[i][j]=grid[i][j]+Math.min(dfs(grid,dp,i+1,j) ,dfs(grid,dp,i,j+1));
         
        
    }
}




class Solution {
    public int minPathSum(int[][] grid) {
        if(grid==null || grid.length==0)
            return 0;
        return dfs(grid,0,0);
         
    }
    int sum=0,res=Integer.MIN_VALUE;
    public int dfs(int[][] grid,int i,int j){
        if(i>=grid.length || j>=grid[0].length)
            return Integer.MAX_VALUE;
        if(i==grid.length-1 && j==grid[0].length-1)
            return grid[i][j];
        return grid[i][j]+Math.min(dfs(grid,i+1,j) ,dfs(grid,i,j+1));
    }
}

