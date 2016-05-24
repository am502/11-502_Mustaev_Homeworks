package ru.itis.inform;

import java.util.*;

public class Checker {
    public boolean check(String s){
        boolean b = false;
        boolean b1 = true;
        Stack<Character> st = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if(function1(s.charAt(i))){
                st.push(s.charAt(i));
            }
            else if(function2(s.charAt(i))){
                if(st.isEmpty())
                    b1 = false;
                else if(st.peek() == '(')
                    st.pop();
                else if(st.peek() == '[')
                    st.pop();
                else if(st.peek() == '{')
                    st.pop();
            }
        }

        if(st.isEmpty() && b1)
            b = true;
        return b;
    }

    private boolean function1(char a){
        boolean b = false;
        if(a == '(' || a == '[' || a == '{')
            b = true;
        return b;
    }
    private boolean function2(char a) {
        boolean b = false;
        if (a == ')' || a == ']' || a == '}')
            b = true;
        return b;
    }
}
