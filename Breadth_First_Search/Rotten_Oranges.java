/*

You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

 

Example 1:


Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.



*/



class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh=0;
        Queue<int[] > q=new LinkedList<>(); 
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2)
                    q.offer(new int[]{i,j});
                else if(grid[i][j]==1)
                    fresh++;
            }
        }
        int dir[][]={{1,0},{0,1},{-1,0},{0,-1}};
        int time=0;
        while(!q.isEmpty() && fresh>0){
            time++;
            int size=q.size();
            for(int i=0;i<size;i++){
                int[] temp=q.poll();
                for(int[] d:dir){
                    int x=d[0]+temp[0];
                    int y=d[1]+temp[1];
                    if(x<0 || x>=grid.length || y<0 || y>=grid[0].length || grid[x][y]==2 ||grid[x][y]==0)
                        continue;
                    q.offer(new int[]{x,y});
                    grid[x][y]=2;
                    fresh--;
                }
            }
        }
        return fresh==0?time:-1;
    }
}
