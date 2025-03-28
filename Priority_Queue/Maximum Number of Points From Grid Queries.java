/*
You are given an m x n integer matrix grid and an array queries of size k.

Find an array answer of size k such that for each integer queries[i] you start in the top left cell of the matrix and repeat the following process:

If queries[i] is strictly greater than the value of the current cell that you are in, then you get one point if it is your first time visiting this cell, and you can move to any adjacent cell in all 4 directions: up, down, left, and right.
Otherwise, you do not get any points, and you end this process.
After the process, answer[i] is the maximum number of points you can get. Note that for each query you are allowed to visit the same cell multiple times.

Return the resulting array answer.

 

Example 1:


Input: grid = [[1,2,3],[2,5,7],[3,5,1]], queries = [5,6,2]
Output: [5,8,1]
Explanation: The diagrams above show which cells we visit to get points for each query.
Example 2:


Input: grid = [[5,2,1],[1,1,2]], queries = [3]
Output: [0]
Explanation: We can not get any points because the value of the top left cell is already greater than or equal to 3.
 

Constraints:

m == grid.length
n == grid[i].length
2 <= m, n <= 1000
4 <= m * n <= 105
k == queries.length
1 <= k <= 104
1 <= grid[i][j], queries[i] <= 106

  */

class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[] result = new int[queries.length];
        int[][] DIRECTIONS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int[][] sortq = new int[queries.length][2];
        for(int i =0; i< queries.length ; i++){
            sortq[i][0] = queries[i];
            sortq[i][1] = i;
        }
        Arrays.sort(sortq, (a,b)-> a[0]-b[0]);
        PriorityQueue<int[]> minheap = new PriorityQueue<>((a,b)-> a[0]-b[0]);
        boolean[][] vis = new boolean[rows][cols];
        int points =0;
        minheap.add(new int[]{grid[0][0], 0,0});
        vis[0][0] = true;
        for(int[] q : sortq){
            int val = q[0];
            int ind = q[1];
            while(!minheap.isEmpty() && minheap.peek()[0]< val){
                int[] top = minheap.poll();
                int cellval = top[0], currentRow = top[1], currentCol = top[2];
                points++;
                for (int[] dir : DIRECTIONS) {
                    int newRow = currentRow + dir[0], newCol =
                        currentCol + dir[1];
                    if (
                        newRow >= 0 &&
                        newCol >= 0 &&
                        newRow < rows &&
                        newCol < cols &&
                        !vis[newRow][newCol]
                    ) {
                        minheap.add(
                            new int[] { grid[newRow][newCol], newRow, newCol }
                        );
                        vis[newRow][newCol] = true;
                    }
                }
            }
            result[ind] = points;
            }
        return result;
        }
    }
