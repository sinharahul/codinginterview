package nw;

import java.util.Stack;

public class BackspaceString {
    public static void main(String[] args) {
        System.out.println(backspaceCompare("a#c","b"));
    }
    public static boolean backspaceCompare(String S, String T) {
        boolean flag=false;
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<S.length();i++){
            char ch=S.charAt(i);
            if(ch!='#'){
                stack.push(ch);
            }else{
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }
        }
        Stack<Character> f=new Stack<>();
        for(int i=0;i<S.length();i++){
            char ch=S.charAt(i);
            if(ch!='#'){
                f.push(ch);
            }else{
                if(!f.isEmpty()){
                    f.pop();
                }
            }
        }
        return stack.equals(f);
    }
}
