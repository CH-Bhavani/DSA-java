/* write a program to check if the given string is palindrome or not using stack .Ignore case,spaces and puntutuations */


import java.util.LinkedList;
public class palindrome {
    public static void main(String[] args) {
        System.out.println(checkforpalindrome("abccba"));
        System.out.println(checkforpalindrome("Was it a car or a cat I saw"));
        System.out.println(checkforpalindrome("I did,did i?"));
        System.out.println(checkforpalindrome("hello"));
        System.out.println(checkforpalindrome("Don't nod!"));
    }
    public static boolean checkforpalindrome(String str){
        LinkedList<Character> stack =new LinkedList<>();
        StringBuilder StringNoPunctutation =new StringBuilder(str.length());
        String lowercase=str.toLowerCase();
        for(int i=0;i<lowercase.length();i++){
            if(lowercase.charAt(i)>='a' && lowercase.charAt(i)<='z'){
                StringNoPunctutation.append(lowercase.charAt(i));
                stack.push(lowercase.charAt(i));
            }
        }
        StringBuilder reversed =new StringBuilder(stack.size());
        while(!stack.isEmpty()){
            reversed.append(stack.pop());
        }
        return reversed.toString().equals(StringNoPunctutation.toString());
    }
}
