/*Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.


*/



class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk=new Stack<>();
        for(int i=0;i<s.length();i++){
             char ch=s.charAt(i);
            if(ch=='(' || ch=='{'|| ch=='[')
                stk.push(ch);
            else if(stk.isEmpty())
                return false;
            else{
                char c=stk.pop();
                if(c=='('  && ch!=')'|| c=='{'  && ch!='}'|| c=='[' && ch!=']')
                    return false;
            }
        }
        return stk.isEmpty()?true:false;
    }
}
