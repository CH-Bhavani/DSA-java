/*
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

 

Example 1:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
Example 2:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true
Example 3:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false

*/



import java.util.*;
public class test{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int row=sc.nextInt();
        int col=sc.nextInt();
        char[][] arr=new char[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                arr[i][j]=sc.next().charAt(0);
            }
        }
        String word=sc.next();
        System.out.println(find_word(arr,row,col,word));
    }
    public static  boolean find_word(char[][] a,int r,int c,String word){
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(a[i][j]==word.charAt(0) && bfs(a,i,j,0,word))
                    return true;
            }
        }
        return false;
    }
    public static boolean bfs(char[][] a,int r,int c,int count,String word){
        if(count==word.length())
            return true;
        if(r<0 || c<0 || r>=a.length || c>=a[0].length || a[r][c]!=word.charAt(count))
            return false;
        char temp=a[r][c];
        a[r][c]='.';
        boolean found=bfs(a,r-1,c,count+1,word)|| bfs(a,r+1,c,count+1,word)||bfs(a,r,c-1,count+1,word)
        ||bfs(a,r,c+1,count+1,word);
        a[r][c]=temp;
        return found;
        
    }
}
