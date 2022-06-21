CAROM-CHALLENGE

Two players A and B play a 3-level game. The scores of A and B at each level are stored in 
arrays P and Q respectively. At each level, the winner gets one point and the loser gets 
zero points. If Its a tie then no one will get a point. Find the total points scored by the 
players by comparing the scores at each level. 

Example

lets says score of A and B are P[N]=[1,2,3] and Q[N]=[3,2,1]
Now compare the scores at each level and calculate the points score by A & B. 
Print the total points scored i.e = Y=[1,1].

input format 
The first line contains A's score in each level separated by a single space.
The second line contains B's score in each level separated by a single space.

Output format
Total points socred by both the players, each separated by a single space

Sample input
5 6 7
3 6 10
Sample output
1 1


import java.util.*;
class test{
    public static void main(String agrs[]){
        Scanner sc=new Scanner(System.in);
        int a1[]=new int[3];
        int a2[]=new int[3];
        int a=0,b=0;
        for(int i=0;i<3;i++)
        a1[i]=sc.nextInt();
        for(int i=0;i<3;i++)
        a2[i]=sc.nextInt();
        for(int i=0;i<3;i++){
            if(a1[i]>a2[i]) a++;
            else if(a1[i]==a2[i]) continue;
            else b++;
            
        }
        System.out.println(a+" "+b);
        
        
    }
    
}


To strike Ukarine,Russia has created two missiles with X and Y powers. 
Ukraine decided to develop a single missile to defend itself against Russia
missiles. Ukraines  missile can counter these two missiles 
only if its power is 
divisible by both X and Y. What is the smallest possible power Ukranie's 
missile should have ?

Input format
The first line will have an integer input X = power of first missile
The second line will have an integer input Y = power of second missile

Output format
An integer value of Ukranies missile power

input= 45
35
output = 315




import java.util.*;
class Test{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int gcd=1;
        for(int i=1;i<=Math.min(m,n);i++){
            if(m%i==0 && n%i==0){
                gcd=i;
                
            }
            
        }
        int lcm=(m*n)/gcd;
        System.out.println(lcm);
        
    }
    
}




In this game, the player needs to find out the most frequently picked card number, 
from a deal of cards . If there is more than one such card number, display the smallest of 
them.
Example

Lets say there are five cards dealth, with numbers 0 0 1 1 2
The cards with the numbers 0 and 1 appeared the most number of times
The smallest number among them is 0

Input format 
The first line contains the number of cards in the deal.
The second line lists down the card numberrs, each separated by a single space.

Output format 
The smallest of the most frequently dealt card numbers.

Sample input
6
1 4 4 4 53
Sample output
4
import java.util.*;
class test{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++) a[i]=sc.nextInt();
        HashMap<Integer,Integer> hm=new LinkedHashMap<>();
        for(int i=0;i<n;i++){
            if(hm.containsKey(a[i]))
            hm.put(a[i],hm.get(a[i])+1);
            else
            hm.put(a[i],1);
            
        }
        int maxv=0,res=-1;
        for(Map.Entry<Integer,Integer> e:hm.entrySet()){
            if(maxv<e.getValue()){
                res=e.getKey();
                maxv=e.getValue();
            }
            
        }
        System.out.println(res);
        
    }
    
    
}
