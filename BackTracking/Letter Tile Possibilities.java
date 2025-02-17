/**

You have n  tiles, where each tile has one letter tiles[i] printed on it.

Return the number of possible non-empty sequences of letters you can make using the letters printed on those tiles.

 

Example 1:

Input: tiles = "AAB"
Output: 8
Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".
Example 2:

Input: tiles = "AAABBC"
Output: 188
Example 3:

Input: tiles = "V"
Output: 1
 

Constraints:

1 <= tiles.length <= 7
tiles consists of uppercase English letters.


  **/

class Solution {
    public int numTilePossibilities(String tiles) {
        Set <String>  hs = new HashSet<String>();
        bt(tiles.toCharArray(), new boolean[tiles.length()], new StringBuilder(), hs);
        return hs.size();
    }

    private void bt(char[] ch, boolean[] vis, StringBuilder temp, Set <String>  hs){
        for(int i =0; i<ch.length; i++){
            // System.out.println(i+ "     "+ Arrays.toString(vis)+ " "  + temp);
            if(!vis[i]){
                vis[i]= true;
                temp.append(ch[i]);
                hs.add(temp.toString());
                // System.out.println("Adding. "+temp);
                bt(ch, vis, temp, hs);
                // System.out.println("back. "+temp.charAt(temp.length()-1));
                temp.deleteCharAt(temp.length()-1);
                vis[i]= false;
                // System.out.println(Arrays.toString(vis));

            }
        }

    }
}
