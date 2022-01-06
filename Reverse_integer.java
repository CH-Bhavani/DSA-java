/*


Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

 

Example 1:

Input: x = 123
Output: 321
Example 2:

Input: x = -123
Output: -321
Example 3:

Input: x = 120
Output: 21

*/



class Solution {
    public int reverse(int x) {
        // signMultiplier = -1 for negative numbers
        // signMultiplier = 1 for positive numbers
        int signMultiplier = 1;
        if (x < 0) {
            signMultiplier = -1;
            x = signMultiplier * x;
        }

        long res = 0;
        while (x > 0) {
            // Add the current digit into result
            res = res * 10 + x % 10;

            // Check if the result is within MaxInt32 and MinInt32 bounds
            if ((signMultiplier * res >= Integer.MAX_VALUE) || (signMultiplier * res <= Integer.MIN_VALUE)) {
                return 0;
            }
            x = x / 10;
        }
        // Restore to original sign of number (+ or -)
        return (int)(signMultiplier * res);
    }
}
}
