/*


Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise, return the number of negative numbers in grid.

 

Example 1:

Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
Output: 8
Explanation: There are 8 negatives number in the matrix.
Example 2:

Input: grid = [[3,2],[1,0]]
Output: 0
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 100
-100 <= grid[i][j] <= 100



*/



class Solution {
    public int countNegatives(int[][] grid) {
        int c=0;
        for(int i=0;i<grid.length;i++){
            c+=binarySearch(0,grid[i].length,grid[i]);
        }
        return c;
    }
    public int binarySearch(int l,int r,int[] grid){
        while(l<r){
            int mid=l+(r-l)/2;
            if(grid[mid]<0)
                r=mid;
            else
                l=mid+1;
        }
        return grid.length-l;
    }
}

        
