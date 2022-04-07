/*






An n x n matrix is valid if every row and every column contains all the integers from 1 to n (inclusive).

Given an n x n integer matrix matrix, return true if the matrix is valid. Otherwise, return false.

 

Example 1:


Input: matrix = [[1,2,3],[3,1,2],[2,3,1]]
Output: true
Explanation: In this case, n = 3, and every row and column contains the numbers 1, 2, and 3.
Hence, we return true.
Example 2:


Input: matrix = [[1,1,1],[1,2,3],[1,2,3]]
Output: false
Explanation: In this case, n = 3, but the first row and the first column do not contain the numbers 2 or 3.
Hence, we return false.


*/



class Solution {
    public boolean checkValid(int[][] matrix) {
        Set<String> set=new HashSet<>();
        for(int i=0;i<matrix.length;i++){
        for(int j=0;j<matrix[0].length;j++){
           if(!set.add(matrix[i][j]+"row"+i))
               return false;
            if(!set.add(matrix[i][j]+"col"+j))
                return false;
        }}
        return true;
        
    }
}






//sol2



// Using boolean matrix to check the visited numbers
class Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        for(int i=0; i<n; i++) {
            boolean[] row = new boolean[n+1];
            boolean[] col = new boolean[n+1];
            for(int j=0; j<n; j++) {
			// if either one is true, then it means the number is repeated in row or column
                if(row[matrix[i][j]] || col[matrix[j][i]]) {
                    return false;
                }
                row[matrix[i][j]] = true;
                col[matrix[j][i]] = true;
            }
        }
        return true;
    }
}



//sol3



class Solution {
    public boolean checkValid(int[][] matrix) {
        for(int i=0; i<matrix.length; i++) {
            HashSet<Integer> row = new HashSet<>();
            HashSet<Integer> col = new HashSet<>();
            for(int j=0; j<matrix[i].length; j++) {
                if(!row.add(matrix[i][j])) {
                    return false;
                }
                if(!col.add(matrix[j][i])) {
                    return false;
                }
            }
        }
        return true;
    }
}



