package com.leetCode;

import org.junit.Test;

import java.util.*;

public class pro451 {
    @Test
    public void test1(){
        System.out.println(frequencySort("tree"));
    }
    public String frequencySort(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < s.length() ; i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0) + 1);
        }
        Set<Map.Entry<Character,Integer>> set = map.entrySet();
        Queue<Map.Entry<Character,Integer>> que = new PriorityQueue<>(
                (o1,o2)-> o2.getValue() - o1.getValue()
        );
        que.addAll(set);
        while(!que.isEmpty()){
            Map.Entry<Character, Integer> poll = que.poll();
            char c = poll.getKey();
            int num = poll.getValue();
            for(int i =0;i<num;i++)
                sb.append(c);
        }
        return sb.toString();
    }
}
