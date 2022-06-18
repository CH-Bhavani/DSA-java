/*


Given a triangle array, return the minimum path sum from top to bottom.

For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.

 

Example 1:

Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
Output: 11
Explanation: The triangle looks like:
   2
  3 4
 6 5 7
4 1 8 3
The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
Example 2:

Input: triangle = [[-10]]
Output: -10



*/



top-down


class Solution {
    public int minimumTotal(List<List<Integer>> tri) {
        for(int i=1;i<tri.size();i++){
            for(int j=0;j<tri.get(i).size();j++){
                int sum=0;
                if(j==0){
                    sum=tri.get(i).get(j)+tri.get(i-1).get(j);
                }
                else if(j==tri.get(i).size()-1){
                    sum=tri.get(i).get(j)+ tri.get(i-1).get(tri.get(i-1).size()-1);
                }
                else{
                    int min=Math.min(tri.get(i-1).get(j),tri.get(i-1).get(j-1));
                    sum=min+tri.get(i).get(j);
                }
                tri.get(i).set(j,sum);
            }
        }
        return Collections.min(tri.get(tri.size()-1));
    }
}




class Solution {
    public int minimumTotal(List<List<Integer>> tri) {
        for(int i=tri.size()-2;i>=0;i--){
            for(int j=0;j<tri.get(i).size();j++){
                int min=Math.min(tri.get(i+1).get(j),tri.get(i+1).get(j+1));
                int sum=min+tri.get(i).get(j);
                tri.get(i).set(j,sum);
            }
        }
        return tri.get(0).get(0);
    }
}




class Solution {
    Integer[][] dp;
    public int minimumTotal(List<List<Integer>> triangle) {
        dp=new Integer[triangle.size()][triangle.size()];
        return helper(triangle,0,0);
    }
    private int helper(List<List<Integer>> tri,int r,int c){
        if(r>=tri.size())
            return 0;
        if(dp[r][c]==null)
            dp[r][c]= Math.min(helper(tri,r+1,c),helper(tri,r+1,c+1))+tri.get(r).get(c);
        return dp[r][c];
    }
}





class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[] dp=new int[n];
        for(int i=0;i<n;i++){
            dp[i]=triangle.get(n-1).get(i);
        }
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<i+1;j++){
                dp[j]=Math.min(dp[j],dp[j+1])+triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}




