/*


Given a string licensePlate and an array of strings words, find the shortest completing word in words.

A completing word is a word that contains all the letters in licensePlate. Ignore numbers and spaces in licensePlate, and treat letters as case insensitive. If a letter appears more than once in licensePlate, then it must appear in the word the same number of times or more.

For example, if licensePlate = "aBc 12c", then it contains letters 'a', 'b' (ignoring case), and 'c' twice. Possible completing words are "abccdef", "caaacab", and "cbca".

Return the shortest completing word in words. It is guaranteed an answer exists. If there are multiple shortest completing words, return the first one that occurs in words.

 

Example 1:

Input: licensePlate = "1s3 PSt", words = ["step","steps","stripe","stepple"]
Output: "steps"
Explanation: licensePlate contains letters 's', 'p', 's' (ignoring case), and 't'.
"step" contains 't' and 'p', but only contains 1 's'.
"steps" contains 't', 'p', and both 's' characters.
"stripe" is missing an 's'.
"stepple" is missing an 's'.
Since "steps" is the only word containing all the letters, that is the answer.
Example 2:

Input: licensePlate = "1s3 456", words = ["looks","pest","stew","show"]
Output: "pest"
Explanation: licensePlate only contains the letter 's'. All the words contain 's', but among these "pest", "stew", and "show" are shortest. The answer is "pest" because it is the word that appears earliest of the 3.


*/



class Solution {
public String shortestCompletingWord(String s, String[] words) {
Map<Character,Integer> hm=new HashMap<>();
for(int i=0;i<s.length();i++)
{
if((s.charAt(i)<='z' && s.charAt(i)>='a') || (s.charAt(i)<='Z' && s.charAt(i)>='A'))
{
char key=Character.toLowerCase(s.charAt(i));
hm.put(key,hm.getOrDefault(key,0)+1);
}
}
String ans="";
int min=20;
for(int j=0;j<words.length;j++)
{
String s1=words[j];
Map<Character,Integer> hm2=new HashMap<>();
for(int i=0;i<s1.length();i++)
{
hm2.put(s1.charAt(i),hm2.getOrDefault(s1.charAt(i),0)+1);
}
int r=0;
for(var v:hm.entrySet()){
if(hm2.containsKey(v.getKey())){
if(v.getValue()>hm2.get(v.getKey()))
{
r=1;
break;
}

            }
            else{
                r=1;
                break;
            }
        }
        if(r==1)
            continue;
        int len=s1.length();
        if(len<min)
        {
            min=len;
            ans=s1;
        }
    }
    return ans;
}
}
