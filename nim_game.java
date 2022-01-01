/*You are playing the following Nim Game with your friend:

Initially, there is a heap of stones on the table.
You and your friend will alternate taking turns, and you go first.
On each turn, the person whose turn it is will remove 1 to 3 stones from the heap.
The one who removes the last stone is the winner.
Given n, the number of stones in the heap, return true if you can win the game assuming both you and your friend play optimally, otherwise return false.



n=1 A take 1,A win
n=2 A take 2,A win
n=3 A take 3,A win
n=4
A take 1,B take 3,B win
A take 2,B take 2,B win
A take 3,B take 1,B win
n=5
A take 1,n=4,A always win

*/



class Solution {
    public boolean canWinNim(int n) {
        return n%4!=0;
        
    }
}
