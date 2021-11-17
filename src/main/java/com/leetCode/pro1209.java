package com.leetCode;

import org.junit.Test;

import java.util.Stack;

public class pro1209 {

    @Test
    public void test1(){
        //"deeedbbcccbdaa"
        //3
        System.out.println(removeDuplicates("deeedbbcccbdaa", 3));
    }

    public String removeDuplicates(String s, int k) {
        Stack<Character> stack = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        stack.push(s.charAt(0));
        stack2.push(1);
        for(int i=1;i<s.length();i++){
            if(!stack.isEmpty()){
                if(s.charAt(i) != stack.peek()){
                    stack.push(s.charAt(i));
                    stack2.push(1);
                }else{
                    if(stack2.peek() == k-1){
                        for(int j=0;j<k-1;j++){
                            stack.pop();
                        }
                        stack2.pop();
                    }else{
                        stack2.push(stack2.pop()+1);
                    }
                }
            }else{
                stack.push(s.charAt(i));
                stack2.push(1);
            }
        }
        StringBuilder sb = new StringBuilder(stack.size());
        int size = stack.size();
        for(int i = 0;i<size;i++){
            sb.insert(0,stack.pop());
        }

        return sb.toString();
    }
}
