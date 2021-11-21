package com.leetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class pro443 {
    public int compress(char[] chars) {

        Map<Integer,Integer> map = new HashMap<Integer,Integer>(){
            {
                put(1,2);
            }
        };
        int index = 0;
        int result = 0;
        int count =1;
        char curChar = chars[0];
        for(int i =1;i<chars.length;i++){
            if(chars[i] == curChar)
                count++;
            else{
                chars[index++] = curChar;
                if(count != 1){
                    Stack<Character> stack = new Stack<>();
                    while(count>0){
                        stack.push(String.valueOf((count%10)).charAt(0));
                        count/=10;
                    }
                    while(!stack.empty())
                        chars[index++] = stack.pop();

                }
                count=1;
                curChar = chars[i];
            }
        }
        if(count>0){
            chars[index++] = curChar;
            if(count != 1){
                Stack<Character> stack = new Stack<>();
                while(count>0){
                    stack.push((char) (count%10));
                    count/=10;
                }
                while(!stack.empty())
                    chars[index++] = stack.pop();

            }
        }
        return index+1;
    }
}
