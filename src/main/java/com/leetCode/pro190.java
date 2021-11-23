package com.leetCode;

import org.junit.Test;

public class pro190 {

    @Test
    public void test1(){
        System.out.println(0b100<<26);
        System.out.println(reverseBits(43261596));
        //i=3
//        for (int i = 0; i < 32; i++) {
//            System.out.println(1<<i);
//        }

    }

    public int reverseBits(int n) {
        int res=0;
        int tmp=0;
        for(int i =0;i<32;i++){
            tmp = (1<<i)&n;
            tmp=tmp<<Math.abs((29-i));
            res|=tmp;
        }
        return res;
    }
}
