/* Suraj and Tom are two best friends. 

Both of them have given two Strings S1 and S2 
Suraj has given String S1 and Tom has given String S2
Suraj is always bothered about Tom Strings and checks if's  his string follows sSequence of Tom strings or not 

Help Suraj to solve his problem 

A sSequence of  string is a new string which is formed from the original string by removing some (can be none) of the characters without
disturbing the relative positions of the remaining characters. 

Sample Test Case1

input = abc
ahbgdc
output = true


Sample Test Case2
input = aik
appkllli
output = false

Explanation - aik is not a subsequnece of appkllli 

Sample Test Case3

input = axc 
ahbgdc
output = false

Both strings consists only of lowercase characters. */


import java.util.*;
public class sub{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String s1=sc.next();
        String seq=sc.next();
        int j=0,count=0;
        for (int i=0;i<s1.length();i++){
            while(j<seq.length()){
                if(s1.charAt(i)==seq.charAt(j)){
                count+=1;
                j++;
                break;
                }
                else
                j++;
            }
        }
        if (count==s1.length())
        System.out.println("true");
        else
        System.out.println("false");
    }
    
}
