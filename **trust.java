/*In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:

The town judge trusts nobody.
Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.
You are given an array trust where trust[i] = [ai, bi] representing that the person labeled ai trusts the person labeled bi.

Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.

 

Example 1:

Input: n = 2, trust = [[1,2]]
Output: 2
Example 2:

Input: n = 3, trust = [[1,3],[2,3]]
Output: 3
Example 3:

Input: n = 3, trust = [[1,3],[2,3],[3,1]]
Output: -1


*/



//method -1
class Solution {
    public int findJudge(int n, int[][] trust) {
        int arr[] = new int[n + 1]; 
        
        for(int i = 0; i < trust.length; i++){
            arr[trust[i][0]]--;
            arr[trust[i][1]]++; 
            
        }
        for(int i = 1; i < arr.length; i++){
            if(arr[i] == n - 1) return i; 
        }
        return -1;
    }
}




//method-2


class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n == 1) return 1; // Base Condition, means if trust array length is 0.means No one trust, as only one guy is present in town.
        Set<Integer> set = new HashSet<>(); // those who trusting on someone, they can never be the judge so. Put them into HashSet.
        Map<Integer, Integer> map = new HashMap<>(); // created an frequency map, for those who trust on someone.
        
        for(int i = 0; i < trust.length; i++){
            set.add(trust[i][0]); // filling the hashset
            
            int key = trust[i][1]; // created an key variable helps in filling our hashmap
            if(map.containsKey(key)){ // if key already present in map update it's frequency by 1
                map.put(key, map.get(key) + 1);
            }
            else{ // otherwise create new frequency,
                map.put(key, 1);
            }
        }
        
        for(Integer key : map.keySet()){ // Iterating on our HashMap
            // The judge we are looking for, it's key value in hashmap is equals to n - 1 && that key is also not present in hashset 
            if(map.get(key) == n - 1 && set.contains(key) == false) return key; // if so, return key
        }
        return -1;
    }
}
