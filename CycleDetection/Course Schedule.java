/*There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 

Constraints:

1 <= numCourses <= 2000
0 <= prerequisites.length <= 5000
prerequisites[i].length == 2
0 <= ai, bi < numCourses
All the pairs prerequisites[i] are unique.


  */


class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
         List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] p:prerequisites){
            graph.get(p[0]).add(p[1]);
        }
        int[] vis=new int[numCourses];  // 0-visited ,1-processing ,2-processed 
        for(int c=0;c<numCourses;c++){
            if(hasCycle(c,vis,graph))
                return false;
        }
        return true;
    }
    public static boolean hasCycle(int c,int[] vis,List<List<Integer>> graph ){
        if(vis[c]==1)
            return true;
        vis[c]=1;
        for(int g:graph.get(c)){
            if(vis[g]!=2 && hasCycle(g,vis,graph))
                return true;
        }
        vis[c]=2;
        return false;
        
    }
}
