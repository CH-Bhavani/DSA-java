/*


Given an array of string words. Return all strings in words which is substring of another word in any order. 

String words[i] is substring of words[j], if can be obtained removing some characters to left and/or right side of words[j].

 

Example 1:

Input: words = ["mass","as","hero","superhero"]
Output: ["as","hero"]
Explanation: "as" is substring of "mass" and "hero" is substring of "superhero".
["hero","as"] is also a valid answer.
Example 2:

Input: words = ["leetcode","et","code"]
Output: ["et","code"]
Explanation: "et", "code" are substring of "leetcode".
Example 3:

Input: words = ["blue","green","bu"]
Output: []



*/



//sol-1

class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> l=new ArrayList<>();
        for(int i=0;i<words.length;i++){
            for(int j=0;j<words.length;j++){
                if(i!=j)
                    if(words[j].indexOf(words[i])!=-1){
                        l.add(words[i]);
                        break;
                    }
            }
        }
        return l;
    }
}





//sol-2



class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> ans = new ArrayList<>();
        Arrays.sort(words, new Comparator<String>() {
            public int compare(String a, String b) {
                return a.length() - b.length();
            }
        });
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[j].contains(words[i])) {
                    ans.add(words[i]);
                    break;
                }
            }
        }
        return ans;
    }
}
