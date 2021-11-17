package com.leetCode;

import org.junit.Test;

import java.util.*;

public class pro49 {
    @Test
    public void test1(){
        char[] tmp = {'a','f','d'};
        char[] tmp2 = {'d','f','a'};
        Arrays.sort(tmp);
        Arrays.sort(tmp2);
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        map.size();
        HashSet<char[]> set = new HashSet<>();
        System.out.println(tmp);
        System.out.println(tmp2);
        System.out.println(set.add(tmp));
        System.out.println(set.add(tmp2));

    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<String> list;
        List<List<String>> res = new ArrayList<>(strs.length);
        boolean[] isAdd = new boolean[strs.length];
        Set<char[]> set = new HashSet<>(strs.length);
        for(int i = 0;i<strs.length;i++){
            if(!isAdd[i]){
                list=new ArrayList<>();
                list.add(strs[i]);
                isAdd[i] = true;
                char[] tmp1 = strs[i].toCharArray();
                Arrays.sort(tmp1);
                // strs[i] = new String(Arrays.sort(strs[i].toCharArray()));
                set.add(tmp1);
                for(int j=0;j<strs.length;j++){
                    if(!isAdd[j]){
                        char[] tmp2 = strs[j].toCharArray();
                        Arrays.sort(tmp2);
                        if(!set.add(tmp2)){
                            isAdd[j] = true;
                            list.add(strs[j]);
                        }
                    }
                }
                res.add(list);
                list.clear();
                set.clear();
            }
        }
        return res;
    }

}
