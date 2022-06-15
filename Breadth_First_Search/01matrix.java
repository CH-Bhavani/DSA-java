/*




Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.

 

Example 1:


Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
Output: [[0,0,0],[0,1,0],[0,0,0]]
Example 2:


Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
Output: [[0,0,0],[0,1,0],[1,2,1]]



*/
class Solution {
    static int  m,n;
    public int[][] updateMatrix(int[][] mat) {
        m=mat.length;
        n=mat[0].length;
        Queue<int[]> q =new LinkedList<>();
        int[][] res=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    q.offer(new int[]{i,j});
                }
                else
                    res[i][j]=-1;
            }
        }
        int dir[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        while(!q.isEmpty()){
            int[] xy=q.poll();
            for(int[] d:dir){
                int a=xy[0]+d[0];
                int b=xy[1]+d[1];
                if((a>=0 &&a<m)  &&( b>=0 && b<n)  && res[a][b]==-1){
                    res[a][b]=res[xy[0]][xy[1]]+1;
                    q.offer(new int[] {a,b});
                }
            }
        }
        return res;
    }
}



