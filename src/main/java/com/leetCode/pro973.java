package com.leetCode;

import org.junit.Test;

import java.util.*;

public class pro973 {

    @Test
    public void test2() {
        char c = '2';
        System.out.println(c*40);
        String str = "12";
//        System.out.println(Integer.parseInt(str*10));
    }

    @Test
    public void test1(){
        HashMap<Character,Integer> map = new HashMap<>();
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        Set<Character> characters = map.keySet();
        for(Map.Entry<Character, Integer> entry : entries){
        }

        int [] arr = new int [26];
        for(int  c : arr)
            c = 22;
        System.out.println(Arrays.toString(arr));

    }
    public int[][] kClosest(int[][] points, int k) {

        Arrays.sort(points,(o1,o2)->(o1[0]*o1[0]+o1[1]*o1[1])-(o2[0]*o2[0]+o2[1]*o2[1]));
        return null;
    }
}
