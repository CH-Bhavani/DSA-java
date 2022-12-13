/*

Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.

A falling path starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right. Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).

 

Example 1:


Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
Output: 13
Explanation: There are two falling paths with a minimum sum as shown.
Example 2:


Input: matrix = [[-19,57],[-40,-5]]
Output: -59
Explanation: The falling path with a minimum sum is shown.


*/

class Solution {
    int n,dp[][];
    public int minFallingPathSum(int[][] matrix) {
        n=matrix.length;
        dp =new int[matrix.length][matrix[0].length+1];
        int min=Integer.MAX_VALUE;
        for(int i=0;i<matrix.length;i++){
            min=Math.min(min,helper(matrix,0,i));
        }
        return min;
    }
    public int helper(int[][] matrix,int row,int col){
        if(row<0 ||row>=n || col<0 || col>=n)
            return Integer.MAX_VALUE;
        if(row==n-1) return matrix[row][col];
        if(dp[row][col]!=0) return dp[row][col];
        int bottom=helper(matrix,row+1,col);
        int bl=helper(matrix,row+1,col-1);
        int br=helper(matrix,row+1,col+1);
        int minpath=Math.min(bottom,Math.min(bl,br));
        dp[row][col]=matrix[row][col]+minpath;
        return dp[row][col];
    }
}
