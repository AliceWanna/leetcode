package com.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class pro350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>(nums1.length);
        List<Integer> list = new ArrayList<>(nums1.length);
        for(int i =0;i<nums1.length;i++){
            map.put(nums1[i],map.getOrDefault(nums1,0)+1);
        }
        for(int i = 0;i<nums2.length;i++){
            if(map.containsKey(nums2[i])){
                if(map.get(nums2[i]) == 1){
                    map.remove(nums2[i]);
                }else{
                    map.put(nums2[i],map.get(nums2[i])-1);
                }
                list.add(nums2[i]);
            }
        }
//        Object[] objects = list.toArray();
//        int[] arr = objects;
        return null;
    }
}
