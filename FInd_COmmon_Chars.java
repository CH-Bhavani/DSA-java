/*



Given a string array words, return an array of all characters that show up in all strings within the words (including duplicates). You may return the answer in any order.

 

Example 1:

Input: words = ["bella","label","roller"]
Output: ["e","l","l"]
Example 2:

Input: words = ["cool","lock","cook"]
Output: ["c","o"]

*/



class Solution {
    public List<String> commonChars(String[] words) {
        HashMap<Character,Integer> cmap =new HashMap<>();
    
    for(int i=0;i<words[0].length();i++){
        char ch = words[0].charAt(i);
        cmap.put(ch,cmap.getOrDefault(ch,0)+1);
    }
    for(int i =1;i<words.length;i++){
        String word = words[i];
        
        HashMap<Character,Integer> map =new HashMap<>();
        
        for(int j=0;j<word.length();j++){
            char ch = word.charAt(j);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        HashMap<Character,Integer> map2 =new HashMap<>();
        for(char key : map.keySet()){
            if(cmap.containsKey(key)== true){
                map2.put(key,Math.min(map.get(key),cmap.get(key)));
            }
        }
     
        cmap = map2;
    }
    List<String> res = new ArrayList<>();
    
    for(char key: cmap.keySet()){
        int frq = cmap.get(key);
        for(int i=0;i<frq;i++){
            res.add(""+key);
        }
    }
    return res;
}
}
