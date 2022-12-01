/*


You are given an integer array deck where deck[i] represents the number written on the ith card.

Partition the cards into one or more groups such that:

Each group has exactly x cards where x > 1, and
All the cards in one group have the same integer written on them.
Return true if such partition is possible, or false otherwise.

 

Example 1:

Input: deck = [1,2,3,4,4,3,2,1]
Output: true
Explanation: Possible partition [1,1],[2,2],[3,3],[4,4].
Example 2:

Input: deck = [1,1,1,2,2,2,3,3]
Output: false
Explanation: No possible partition.


*/


class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        int[] c=new int[10000];
        for(int i=0;i<deck.length;i++){
            c[deck[i]]++;
        }
        Search: for(int x=2;x<=deck.length;x++){
            for(int val:c)
                if(val%x!=0)
                    continue Search;
            return true;
        }
        return false;
    }
}
