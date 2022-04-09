/*

Given an array of strings words and an integer k, return the k most frequent strings.

Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.

 

Example 1:

Input: words = ["i","love","leetcode","i","love","coding"], k = 2
Output: ["i","love"]
Explanation: "i" and "love" are the two most frequent words.
Note that "i" comes before "love" due to a lower alphabetical order.
Example 2:

Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
Output: ["the","is","sunny","day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words, with the number of occurrence being 4, 3, 2 and 1 respectively.

*/





class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map=new HashMap<>();
        for(String w:words)
            map.put(w,map.getOrDefault(w,0)+1);
        Queue<Map.Entry<String,Integer>> q=new PriorityQueue<>(
        (a,b)->a.getValue()==b.getValue() ?a.getKey().compareTo(b.getKey()):b.getValue()-a.getValue());
        for(Map.Entry<String,Integer> m:map.entrySet())
            q.offer(m);
        ArrayList<String> arr=new ArrayList<>();
        for(int i=0;i<k;i++)
            arr.add(q.poll().getKey());
        return arr;
    }
}
