package com.leetCode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class pro225 {
    public static void main(String[] args) {
        Queue<Integer> q1 = new LinkedList<>();
        q1.add(1);
        q1.add(2);
        q1.add(3);
        q1.add(4);
        q1.add(5);
        q1.add(6);
        System.out.println(q1.poll());
        System.out.println(q1.poll());
        System.out.println(q1.poll());
        System.out.println(q1.poll());
        System.out.println(q1.poll());
        System.out.println(q1.poll());
//        MyStack s = new MyStack();
//        s.push(1);
//        s.push(2);
//        s.push(3);
//        System.out.println(s.pop());
//        System.out.println(s.pop());
//        System.out.println(s.pop());
    }
}
class MyStack {

    Deque<Integer> q1 = new LinkedList<>();
    Deque<Integer> q2 = new LinkedList<>();
    int last = 1;
    public MyStack() {
    }

    public void push(int x) {
        if(last == 1){
            if(q1.isEmpty())
                q1.push(x);
            else{
                q2.push(q1.pop());
                q1.push(x);
            }

        }
        else{
            if(q2.isEmpty())
                q2.push(x);
            else{
                q1.push(q2.pop());
                q2.push(x);
            }
        }
    }

    public int pop() {
        if(last == 1){
            int res = q1.pop();
            while(q2.size()>1){
                q1.push(q2.pop());
            }
            last = 2;
            return res;
        }
        else{
            int res = q2.pop();
            while(q1.size()>1){
                q2.push(q1.pop());
            }
            last = 1;
            return res;
        }
    }

    public int top() {
        if(last == 1)
            return q1.peek();
        else
            return q2.peek();
    }

    public boolean empty() {
        if(last == 1)
            return q1.isEmpty();
        else
            return q2.isEmpty();
    }
}