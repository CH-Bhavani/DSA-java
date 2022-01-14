/* check if the string is palindrome or not using stack and queue */



import java.util.LinkedList;

public class test {

    public static void main(String[] args) {
        // should return true
        System.out.println(checkForPalindrome("abccba"));
        // should return true
        System.out.println(checkForPalindrome("Was it a car or a cat I saw?"));
        // should return true
        System.out.println(checkForPalindrome("I did, did I?"));
        // should return false
        System.out.println(checkForPalindrome("hello"));
        // should return true
        System.out.println(checkForPalindrome("Don't nod"));
    }

    public static boolean checkForPalindrome(String string) {
        LinkedList<Character> stack=new LinkedList<>();
        LinkedList<Character> queue=new LinkedList<>();
        String lower =string.toLowerCase();
        for(int i=0;i<lower.length();i++){
            char c=lower.charAt(i);
            if(c>='a' && c<='z'){
                stack.push(c);
                queue.addLast(c);
            }
        }
        while(!stack.isEmpty()){
            if(!stack.pop().equals(queue.removeFirst()))
                return false;
        }
        return true;
    }
}
