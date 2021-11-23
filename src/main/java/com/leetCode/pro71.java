package com.leetCode;

import org.junit.Test;

import java.util.*;

public class pro71 {

    @Test
    public void test5(){
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < 10; i++) {
            queue.add(i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(queue.poll());
        }
    }

    @Test
    public void test4(){
        String str = "/2/1/3///2/23";
        String[] split = str.split("/");
        System.out.println(split.length);
        for(String s : split)
            System.out.println((s.equals("")?"empty":s));
    }

    @Test
    public void test3(){
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < 10; i++) {
            queue.push(i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(queue.poll());
        }
    }
    @Test
    public void test2(){
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            queue.add(i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(queue.poll());
        }
    }
    @Test
    public void test1(){
//        System.out.println(simplifyPath("/home/"));
        Stack<String> stack = new Stack<>();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        stack.push("5");
        for(String str : stack)
            System.out.println(str);
    }

    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        stack.push("/");
        int index=0;
        StringBuilder tmp = new StringBuilder();
        int len = path.length();
        while(index<len){
            // if(path.charAt(index) ==  '/'){
            while(index<len && path.charAt(index) ==  '/')
                index++;
            if(index == len)
                break;
            while(index<len && path.charAt(index) !=  '/')
                tmp.append(path.charAt(index++));
            switch(tmp.toString()){
                case "..":
                    if(stack.size() > 1){
                        if(stack.size() >2)
                            stack.pop();
                        stack.pop();
                    }
                    break;
                case ".":
                    break;
                default:
                    if(stack.size()!=1)
                        stack.push("/");
                    stack.push(tmp.toString());
            }
            tmp.setLength(0);
            // }
        }
        while(!stack.isEmpty())
            tmp.append(stack.poll());
        return tmp.toString();
    }
}
