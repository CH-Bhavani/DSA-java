/*Find Union of two unsorted arrays*/

class Solution{
    public static int doUnion(int a[], int n, int b[], int m) 
    {
        //Your code here
        {
          //stores only unique elements hashmap and hashset
        HashSet<Integer> hash = new HashSet<>();
        for(int i=0;i<n;i++){
            hash.add(a[i]);
        }
        for(int i=0;i<m;i++){
            hash.add(b[i]);
        }
        return hash.size();
        
    }
    }
}

