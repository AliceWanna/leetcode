package com.leetCode;

import org.junit.Test;

public class forTest {

    @Test
    public void test1(){
        String str = "12+2i";
        String[] split = str.split("\\+");
        System.out.println(split[0]);
        System.out.println(split[1]);
        System.out.println(split[1].split("i")[0]);
        String tmp = "-1";
        System.out.println(Integer.parseInt(tmp));
    }
}
