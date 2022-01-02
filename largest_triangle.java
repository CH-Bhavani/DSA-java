/*area = Math.abs((x1 -x2) * (y1 - y3) - (x1 - x3) * (x1 - x2)) / 2



Given an array of points on the X-Y plane points where points[i] = [xi, yi], return the area of the largest triangle 
that can be formed by any three different points. Answers within 10-5 of the actual answer will be accepted.
*/

class Solution {
    public double largestTriangleArea(int[][] points) {
        double ret=0;
        for(int i=0;i<points.length-2;i++){
            for(int j=i+1;j<points.length-1;j++){
                int x=points[i][0]-points[j][0];
                int y=points[i][1]-points[j][1];
                for(int k=j+1;k<points.length;k++){
                    int x1=points[i][0]-points[k][0];
                    int y1=points[i][1]-points[k][1];
                    double area=Math.abs(x*y1-y*x1)/(2*1.0000000);
                    if (area>ret)
                        ret =area;
                }
            }
        }
        return ret;  
    }
}
