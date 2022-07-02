
/*

You are given a rectangular cake of size h x w and two arrays of integers horizontalCuts and verticalCuts where:

horizontalCuts[i] is the distance from the top of the rectangular cake to the ith horizontal cut and similarly, and
verticalCuts[j] is the distance from the left of the rectangular cake to the jth vertical cut.
Return the maximum area of a piece of cake after you cut at each horizontal and vertical position provided in the arrays horizontalCuts and verticalCuts. Since the answer can be a large number, return this modulo 109 + 7.

 

Example 1:


Input: h = 5, w = 4, horizontalCuts = [1,2,4], verticalCuts = [1,3]
Output: 4 
Explanation: The figure above represents the given rectangular cake. Red lines are the horizontal and vertical cuts. After you cut the cake, the green piece of cake has the maximum area.
Example 2:


Input: h = 5, w = 4, horizontalCuts = [3,1], verticalCuts = [1]
Output: 6
Explanation: The figure above represents the given rectangular cake. Red lines are the horizontal and vertical cuts. After you cut the cake, the green and yellow pieces of cake have the maximum area.
Example 3:

Input: h = 5, w = 4, horizontalCuts = [3], verticalCuts = [3]
Output: 9

*/


class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int mod=(int)10e+7;
        int m=horizontalCuts.length,n=verticalCuts.length;
        int maxHeight=Math.max(horizontalCuts[0],h-horizontalCuts[m-1]);
        int maxwidth=Math.max(verticalCuts[0],w-verticalCuts[n-1]);
        for(int i=1;i<m;i++){
            maxHeight=Math.max(maxHeight,horizontalCuts[i]-horizontalCuts[i-1]);
        }
        for(int i=1;i<n;i++){
            maxwidth=Math.max(maxwidth,verticalCuts[i]-verticalCuts[i-1]);
        }
        return (int)((long)maxwidth * maxHeight % 1000000007);
    }
}
