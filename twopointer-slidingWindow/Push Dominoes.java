/*




There are n dominoes in a line, and we place each domino vertically upright. In the beginning, we simultaneously push some of the dominoes either to the left or to the right.

After each second, each domino that is falling to the left pushes the adjacent domino on the left. Similarly, the dominoes falling to the right push their adjacent dominoes standing on the right.

When a vertical domino has dominoes falling on it from both sides, it stays still due to the balance of the forces.

For the purposes of this question, we will consider that a falling domino expends no additional force to a falling or already fallen domino.

You are given a string dominoes representing the initial state where:

dominoes[i] = 'L', if the ith domino has been pushed to the left,
dominoes[i] = 'R', if the ith domino has been pushed to the right, and
dominoes[i] = '.', if the ith domino has not been pushed.
Return a string representing the final state.

 

Example 1:

Input: dominoes = "RR.L"
Output: "RR.L"
Explanation: The first domino expends no additional force on the second domino.
Example 2:


Input: dominoes = ".L.R...LR..L.."
Output: "LL.RR.LLRRLL.."



*/


class Solution {
    public String pushDominoes(String dominoes) {
        char[] d = dominoes.toCharArray();
        int l = 0, n = dominoes.length();
        for (int r = 0; r < n; r++) {
            if(d[r]=='.')
                continue;
            else if((d[r]==d[l]) || (d[l]=='.' &&d[r]=='L' )){
                for(int k=l;k<=r;k++){
                    d[k]=d[r];
                }
            }
            else if(d[l]=='L' && d[r]=='R'){ //continue;}
                   
            else if(d[l]=='R' && d[r]=='L'){
                int m=(r-l-1)/2;
                for(int k=1;k<=m;k++){
                    d[l+k]='R';
                    d[r-k]='L';
                }
            }
            l=r;    
        }
        if (d[l] == 'R') for (int k = l; k < n; k++) d[k] = 'R';
        return new String(d);
    }
    
}
