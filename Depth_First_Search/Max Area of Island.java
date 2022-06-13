/*



You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

The area of an island is the number of cells with a value 1 in the island.

Return the maximum area of an island in grid. If there is no island, return 0.

 

Example 1:


Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
Output: 6
Explanation: The answer is not 11, because the island must be connected 4-directionally.
Example 2:

Input: grid = [[0,0,0,0,0,0,0,0]]
Output: 0


*/




class Solution {
    boolean visited[][];
    public int maxAreaOfIsland(int[][] grid) {
        visited=new boolean[grid.length][grid[0].length];
        int max=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                max=Math.max(max,area(i,j,grid));
            }
        }
        return max;
    }
    public int area(int r,int c,int[][] grid){
        if(r<0 || r>=grid.length || c<0 || c>=grid[r].length|| visited[r][c]|| grid[r][c]==0)
            return 0;
        visited[r][c]=true;
        return 1+area(r+1,c,grid)+area(r-1,c,grid)+area(r,c+1,grid)+area(r,c-1,grid);
    }
    
}
