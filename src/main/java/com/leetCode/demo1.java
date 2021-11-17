package com.leetCode;

import org.junit.Test;

import java.util.Stack;

public class demo1 {

    @Test
    public void test1(){
        StringBuilder sb = new StringBuilder();
        sb.insert(0,'a');
        sb.insert(0,'b');
        sb.insert(0,'c');
        sb.insert(0,'d');
        sb.insert(0,'e');
        System.out.println(sb);
    }

    @Test
    public void test2(){
        System.out.println(reverse(123));
    }

        public int reverse(int x) {
        int i = 0;
        int up = 1;
        String str = "" + x;
        if(str.charAt(0) == '-'){
            up=-1;
            i++;
        }
        Stack<Integer> stack = new Stack<>();
        while(i<str.length()){
            stack.push(str.charAt(i) - '0');
            i++;
        }
        int sum = 0;
        int tmp = 0;
        int cur = 0;
        while(!stack.empty()){
            cur = stack.pop() - '0';
            tmp = sum;
            sum=sum*10 - cur;
            if(sum/10 != tmp)
                return (up==1?Integer.MAX_VALUE:Integer.MIN_VALUE);
        }
        if(up == 1){
            return (sum==Integer.MIN_VALUE?Integer.MAX_VALUE:sum*(-1));
        }
        return sum;
    }
    public static int divide(int a, int b) {
        if(a == 0)
            return 0;
        int isLow = 0;
        if(a > 0){
            a=-a;
            isLow++;
        }else{
            isLow--;
        }
        if(b>0){
            b=-b;
            isLow++;
        }else{
            isLow--;
        }
        int sum = 0;
        int count = 0;
        int tmp;
        while(sum > a){
            tmp = sum;
            sum+=b;
            if((sum-b)!=tmp)
                return (isLow==2||isLow==-2)?Integer.MAX_VALUE:Integer.MIN_VALUE;
            count++;
        }
        if(sum < a)
            count--;
        if(isLow==2||isLow==-2){
            return count == Integer.MIN_VALUE?Integer.MAX_VALUE:count;
        }
        return -count;
    }
}
