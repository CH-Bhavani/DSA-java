/*






You are given an array of strings equations that represent relationships between variables where each string equations[i] is of length 4 and takes one of two different forms: "xi==yi" or "xi!=yi".Here, xi and yi are lowercase letters (not necessarily different) that represent one-letter variable names.

Return true if it is possible to assign integers to variable names so as to satisfy all the given equations, or false otherwise.

 

Example 1:

Input: equations = ["a==b","b!=a"]
Output: false
Explanation: If we assign say, a = 1 and b = 1, then the first equation is satisfied, but not the second.
There is no way to assign the variables to satisfy both equations.
Example 2:

Input: equations = ["b==a","a==b"]
Output: true
Explanation: We could assign a = 1 and b = 1 to satisfy both equations.



*/


class Solution {
    int[] parent,rank;
    
    public boolean equationsPossible(String[] equations) {
        parent=new int[26];
        rank=new int[26];
        for(int i=0;i<26;i++){
            parent[i]=i;
            rank[i]=1;
        }
        for(String e:equations){
            if(e.charAt(1)=='='){
                union(e.charAt(0)-'a',e.charAt(3)-'a');
            }
        }
        for(String e:equations){
            if(e.charAt(1)=='!'){
                int l=find(e.charAt(0)-'a');
                int r=find(e.charAt(3)-'a');
                if(l==r)
                    return false;
            }
        }
        return true;
        
    }
    public int find(int x){
        if(parent[x]==x)
            return x;
        int temp=find(parent[x]);
        parent[x]=temp;
        return temp;
    }
    public void union(int x,int y){
        int lx=find(x);
        int ly=find(y);
        if(lx!=ly){
            if(rank[lx]>rank[ly]){
                parent[ly]=lx;
            }
            else if(rank[lx]<rank[ly]){
                parent[lx]=ly;
            }
            else{
                parent[lx]=ly;
                rank[ly]++;
            }
            
        }
    }
}
