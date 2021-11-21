package com.leetCode;

import org.junit.Test;

public class pro47 {
    
    @Test
    public void test1(){
        System.out.println(multiply("9999", "99993"));
    }
    
    public String multiply(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int n1Index = num1.length()-1;
        int n2Index = num2.length()-1;
        int up=0;
        while(n1Index >-1 || n2Index >-1){
            int n1Num = (n1Index == -1?1:num1.charAt(n1Index--)-'0');
            int n2Num = (n2Index == -1?1:num2.charAt(n2Index--)-'0');
            int cur = n1Num*n2Num + up;
            up = cur/10;
            sb.append(cur%10);
        }
        if(up != 0)
            sb.append(up);
        return sb.reverse().toString();
    }
}
