/*


Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:


 

Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
Example 2:

Input: numRows = 1
Output: [[1]]

*/


class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> fin=new ArrayList<List<Integer>>();
        for(int i=1;i<=n;i++){
            ArrayList<Integer> l=new ArrayList<>();
            for(int j=1;j<=i;j++){
            if(j==1 || i==j) l.add(1);
            else{
                List<Integer> l1=fin.get(i-2);
                int sum=l1.get(j-2)+l1.get(j-1);
                l.add(sum);
            }
        }
            fin.add(l);
        }
        return fin;
    }
}
