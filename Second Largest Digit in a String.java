/*

Given an alphanumeric string s, return the second largest numerical digit that appears in s, or -1 if it does not exist.

An alphanumeric string is a string consisting of lowercase English letters and digits.

 

Example 1:

Input: s = "dfa12321afd"
Output: 2
Explanation: The digits that appear in s are [1, 2, 3]. The second largest digit is 2.
Example 2:

Input: s = "abc1111"
Output: -1
Explanation: The digits that appear in s are [1]. There is no second largest digit. 

*/



class Solution {
	public int secondHighest(String s) {

		int arr[] = new int[10];
		int[] ans = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

		if (s.isEmpty()) {
			return -1;
		}

		for (char c : s.toCharArray()) {
			if (Character.isDigit(c)) {
				arr[(int) (c - '0')]++;
			}
		}


		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 0) {
				ans[i] = i;
			}
		}

		Arrays.sort(ans);
		return ans[8];
	}
}
