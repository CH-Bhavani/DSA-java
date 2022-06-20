/*
    2 Rakesh playing a puzzle with given word. word contains characters a to z small letters and '?' marks.
    3 all the question marks in the given word can be replace with any character in a to z range.
    4 help him to replace question marks with a-z range, after replacing
    5 returns the word if it is palidrome other wise print "NO".
    6 
    7 input =?a?
    8 output =aaa 
    9 in this case many possible replacements, aaa,bab,cac,dad,eae .......zaz
   10 we need to choose palindrome string which is lexicographically smallest ie aaa.
   11 
   12 
   13 input =?ab??a
   14 output =aabbaa
   15 
   16 input =bab??a
   17 output =NO
   18 
   19 */
   20 import java.util.*;
   21 public class Test{
   22     public static void main(String[] args){
   23         Scanner sc=new Scanner(System.in);
   24         String s=sc.next();
   25         System.out.println(isPalindrome(s));
   26     }
   27     public static String isPalindrome(String s){
   28         if(s.length()==0 || s==null)
   29              return "NO";
   30         int l=0,r=s.length()-1;
   31         char [] arr=s.toCharArray();
   32         while(l<=r){
   33             if(s.charAt(l)=='?' && s.charAt(r)=='?'){
   34                 arr[l]='a';
   35                 arr[r]='a';
   36                 l++;
   37                 r--;
   38             }
   39             else if(s.charAt(l)=='?' && s.charAt(r)!='?'){
   40                 arr[l]=s.charAt(r);
   41                 l++;
   42                 r--;
   43             }
   44             else if(s.charAt(l)!='?' && s.charAt(r)=='?'){
   45                 arr[r]=s.charAt(l);
   46                 l++;
   47                 r--;
   48             }
   49             else if(s.charAt(l)!=s.charAt(r)){
   50                     break;
   51             }
   52             else if(s.charAt(l)==s.charAt(r)){
   53                 l++;
   54                 r--;
   55             }
   56         }
   57         //System.out.println(Arrays.toString(arr));
   58         String temp="";
   59         for(int i=0;i<s.length();i++){
   60             if(arr[i]=='?')
   61                 return "NO";
   62             else
   63                 temp+=arr[i];
   64         }
   65         return temp;
   66     }
   67     
   68 }
   69 
     
     
     
     
     
     
     
     
     /*You have three stacks of cylinders where each cylinder has the same diameter, but they may vary in height.
    2 You can change the height of a stack by removing and discarding its topmost cylinder any number of times.
    3 
    4 Find the maximum possible height of the stacks such that all of the stacks are exactly the same height. 
    5 This means you must remove zero or more cylinders from the top of zero or more of the three stacks until 
    6 they're all the same height, then print the height. 
    7 The removals must be performed in such a way as to maximize the height.
    8 
    9 Note: An empty stack is still a stack.
   10 
   11 Input Format
   12 ------------
   13 The first line contains three space-separated integers,n1, n2, and n3, describing the respective number 
   14 of cylinders in stacks 1, 2, and 3. 
   15 The subsequent lines describe the respective heights of each cylinder in a stack from top to bottom:
   16 
   17 -> The second line contains n1 space-separated integers describing the cylinder heights in stack 1. 
   18 The first element is the top of the stack.
   19 -> The third line contains n2 space-separated integers describing the cylinder heights in stack 2. 
   20 The first element is the top of the stack.
   21 -> The fourth line contains n3 space-separated integers describing the cylinder heights in stack 3. 
   22 The first element is the top of the stack. 
   23 
   24 Output Format
   25 -------------
   26 Print a single integer denoting the maximum height at which all stacks will be of equal height.
   27 
   28 Sample Input
   29 ------------
   30 5 3 4
   31 3 2 1 1 1
   32 4 3 2
   33 1 1 4 1
   34 
   35 Sample Output
   36 -------------
   37 5
   38 
   39 Explanation:
   40 ------------
   41 Explanation
   42 
   43 Initially, the stacks look like this:
   44 
   45 1 1 1 2 3
   46 2 3 4
   47 1 4 1 1
   48 
   49 Observe that the three stacks are not all the same height. 
   50 To make all stacks of equal height, 
   51 we remove the first cylinder(3,4) from stacks 1 and 2, and then remove the top two cylinders(1,1) from stack 3.
   52 
   53 As a result, the stacks undergo the following change in height:
   54 1. 8-3   = 5
   55 2. 9-4   = 5
   56 3. 7-1-1 = 5
   57 All three stacks now have height = 5. Thus, we print 5 as our answer.
   58 
   59 */
   60 // import java.util.*;
   61 // public class Test{
   62 //     public static void main(String[] args){
   63 //         Scanner sc=new Scanner(System.in);
   64         
   65 //     }
   66 // }
   67 import java.util.*;
   68 public class Test{
   69     public static void main(String[] args) {
   70         Scanner in = new Scanner(System.in);
   71         HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
   72         int[] sum = new int[3];
   73         int[] sn = new int[3];
   74         for (int i =0; i< 3 ; i++)
   75             sn[i] = in.nextInt();
   76         for(int i =0; i < 3; i++)
   77         {
   78             map.put(i, new ArrayList<Integer>());
   79             for(int j=0 ; j < sn[i]; j++)
   80             {
   81                 int k = in.nextInt();
   82                 sum[i] += k;
   83                 map.get(i).add(0,k);
   84             }
   85         }
   86         int j=0;
   87         while (!((sum[0] == sum[1]) && (sum[1] == sum[2])))
   88         {
   89             int minSum = Math.max(Math.max(sum[0], sum[1]), sum[2]);
   90             j = 0;
   91             if (minSum == sum[0])
   92                 j =0;
   93             else if (minSum == sum[1])
   94                 j = 1;
   95             else
   96                 j = 2;
   97             sum[j] -=  map.get(j).get(map.get(j).size() - 1);
   98             map.get(j).remove(map.get(j).size() - 1);
   99         }
  100         System.out.println(sum[0]);
  101     }
  102     
  103 }






/*Given two strings s1 and s2, return the lowest ASCII sum of deleted characters to make two strings equal.
    2 
    3 input =sea
    4 eat
    5 --deleting s from sea adds the ASCII value of s(115) to the sum.
    6 -- deleting t from eat adds 116 to sum
    7 at the end, both strings are equal, and 115+116=231 is minimum sum possible to achieve this.
    8 
    9 input =delete 
   10 leet
   11 
   12 deleting dee from delete to turn the string into let.
   13 add 100(d)+101(e) to the sum
   14 Deleting "e" from "leet" adds 101[e] to the sum.
   15 
   16 At the end, both strings are equal to "let", and the answer is 100+101+101+101 = 403.
   17 If instead we turned both strings into "lee" or "eet", we would get answers of 433 or 417, which are higher.
   18 
   19 */
   20 import java.util.*;
   21 public class Test{
   22     public static void main(String[] args){
   23         Scanner sc=new Scanner(System.in);
   24         String s1=sc.next();
   25         String s2=sc.next();
   26         System.out.println(asciiSum(s1,s2));
   27     }
   28     public static int asciiSum(String s1,String s2){
   29         int dp[][]=new int[s1.length()+1][s2.length()+1];
   30         for(int i=dp.length-1 ;i>=0;i--){
   31             for(int j=dp[0].length-1;j>=0;j--){
   32                 if(i==dp.length-1 && j==dp[0].length-1) 
   33                     dp[i][j]=0;
   34                 else if(i==dp.length-1){
   35                     dp[i][j]=(int)s2.charAt(j)+dp[i][j+1];
   36                     
   37                 }
   38                 else if(j==dp[0].length-1){
   39                     dp[i][j]=(int)s1.charAt(i)+dp[i+1][j];
   40                     
   41                 }
   42                 else{
   43                     if(s1.charAt(i)==s2.charAt(j)) dp[i][j]=dp[i+1][j+1];
   44                     else dp[i][j]=Math.min((int)s1.charAt(i)+ dp[i+1][j],(int)s2.charAt(j)+dp[i][j+1]);
   45 
   46                 }
   47                 
   48             }
   49             
   50         }
   51         
   52         return dp[0][0];
   53         
   54     }
   55 }
