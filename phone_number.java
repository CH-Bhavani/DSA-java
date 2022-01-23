/*

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.



 

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]


*/



class Solution {
    public List<String> letterCombinations(String digits) {
        Map<String, String> digitsMap = new HashMap<>();
        digitsMap.put("2", "abc");
        digitsMap.put("3", "def");
        digitsMap.put("4", "ghi");
        digitsMap.put("5", "jkl");
        digitsMap.put("6", "mno");
        digitsMap.put("7", "pqrs");
        digitsMap.put("8", "tuv");
        digitsMap.put("9", "wxyz");
        List<String> combinations = new ArrayList<>();       
        for (int i = 0; i < digits.length(); i++) {
            String currDigit = String.valueOf(digits.charAt(i));
            String letters = digitsMap.get(currDigit);
            if (i == 0) {                
                for (int j = 0; j < letters.length(); j++) {
                    combinations.add(String.valueOf(letters.charAt(j)));
                }
            } else {
                List<String> newCombinations = new ArrayList<>();
                
                for (int j = 0; j < combinations.size(); j++) {
                    String oldStr = combinations.get(j);                    
                    
                    for (int k = 0; k < letters.length(); k++) {
                        String newStr = oldStr + String.valueOf(letters.charAt(k));
                        newCombinations.add(newStr);
                    }                    
                }
                
                combinations = newCombinations;
            }            
        }
        
        return combinations;        
    }  
}
