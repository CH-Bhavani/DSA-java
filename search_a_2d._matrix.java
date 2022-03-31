/*


Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
 

Example 1:


Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
Output: true
Example 2:


Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
Output: false


*/



class Solution {
    public boolean searchMatrix(int[][] m, int target) {
        int row=0,col=m[0].length-1;
        while(row<m.length && col>=0){
            if(target<m[row][col])
                col--;
            else if(target>m[row][col])
                row++;
            else 
                return true;
        }
        return false;
    }
}
