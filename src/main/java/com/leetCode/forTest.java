package com.leetCode;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class forTest {


    @Test
    public void test4() {

        int tmp =-2147483648;
        tmp |= tmp>>>1;
        tmp |= tmp>>>2;
        tmp |= tmp>>>4;
        tmp |= tmp>>>8;
        tmp |= tmp>>>16;
        System.out.println(tmp);
    }

        @Test
    public void test3() {
        Random random = new Random();
        int[] arr = new int[10];
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            arr[random.nextInt(10)]++;
        }
        System.out.println(Arrays.toString(arr));
    }

        @Test
    public void test2(){
        int a = -12332321;
        System.out.println(a%10);
    }

    @Test
    public void test1(){
        String s = "00012";
        int a = Integer.parseInt(s);
        System.out.println(a);
//        String str = "12+2i";
//        String[] split = str.split("\\+");
//        System.out.println(split[0]);
//        System.out.println(split[1]);
//        System.out.println(split[1].split("i")[0]);
//        String tmp = "-1";
//        System.out.println(Integer.parseInt(tmp));
    }
}
